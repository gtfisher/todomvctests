package net.serenitybdd.tutorials.tasks.rest;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.tutorials.model.Pet;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by gtarrant-fisher on 03/03/2016.
 */
public class GetPetByEmptyId implements Task {

    private Pet pet;

    public GetPetByEmptyId(Pet pet){
        this.pet = pet;
    }



    @Override
    @Step("{0} starts with a pet list not containing '#pet'")
    public <T extends Actor> void performAs(T actor) {
        rest().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
                .then().statusCode(404)
                .and().body("message", equalTo("Pet not found"));
    }
}
