package net.serenitybdd.tutorials.features.petstore;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.tutorials.model.Pet;
import net.serenitybdd.tutorials.questions.GetPet;
import net.serenitybdd.tutorials.steps.serenity.PetStoreSteps;
import net.serenitybdd.tutorials.tasks.StartWith;
import net.serenitybdd.tutorials.tasks.rest.AddToStore;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class AddAPetToThePetStoreTest {

    @Steps
    PetStoreSteps petStore;

    Actor peter =  Actor.named("Peter");

    @Test
    public void shouldBeAbleToAddPetsToAStoreStepsApproach() {

        Pet fido = new Pet("available","fido");

        petStore.when_i_add_the_pet_to_the_store(fido);

        petStore.the_pets_should_be_available();

    }

    @Test
    public void shouldBeAbleToAddPetsToStoreScreenPlayApproach() {

        Pet fido = new Pet("available","fido2");
        fido.setId(Math.abs(new Random().nextInt()));

        givenThat(peter).wasAbleTo(StartWith.NoListingForPet(fido));

        when (peter).attemptsTo(AddToStore.newPet(fido));

        // todo - better way of checking hte results with the matcher
        then (peter).should(seeThat(GetPet.entryForId(fido.getId()), containsString("fido2")));

    }


}