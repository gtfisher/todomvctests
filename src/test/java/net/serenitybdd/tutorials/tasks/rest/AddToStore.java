package net.serenitybdd.tutorials.tasks.rest;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.tutorials.model.Pet;
import net.thucydides.core.annotations.Step;

import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.rest;


/**
 * Created by gtarrant-fisher on 02/03/2016.
 */
public class AddToStore implements Task {

    private Pet pet;

    public AddToStore(Pet pet) {
        this.pet = pet;
    }

    public static Task newPet(Pet pet) {
        return Instrumented.instanceOf(AddToStore.class)
                .withProperties(pet);
    }


    @Override
    @Step("{0} adds a pet  '#pet'")
    public <T extends Actor> void performAs(T actor) {

        String jsonPet = "{\"id\": " + pet.getId() + " , \"name\": \""
                + pet.getName() + "\", \"photoUrls\": [], \"status\": \""
                + pet.getStatus() + "\"}";

        rest().given().contentType("application/json")
                .content(jsonPet).post("http://petstore.swagger.io/v2/pet");

    }
}
