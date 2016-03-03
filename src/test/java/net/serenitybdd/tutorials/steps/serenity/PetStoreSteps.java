package net.serenitybdd.tutorials.steps.serenity;

import net.serenitybdd.tutorials.model.Pet;
import net.thucydides.core.annotations.Step;

import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by gtarrant-fisher on 02/03/2016.
 */
public class PetStoreSteps {

    Pet pet;
    String jsonPet;

    @Step
    public void when_i_add_the_pet_to_the_store(Pet pet) {
        this.pet = pet;
        int id = Math.abs(new Random().nextInt());
        System.out.println("pushed id->" + id);
        this.jsonPet = "{\"id\": " + id + " , \"name\": \""
                + pet.getName() + "\", \"photoUrls\": [], \"status\": \""
                + pet.getStatus() + "\"}";

        rest().given().contentType("application/json")
                .content(jsonPet).post("http://petstore.swagger.io/v2/pet");

        this.pet.setId(id);
    }

    @Step
    public void the_pets_should_be_available() {
        System.out.println("get pet for id->" + pet.getId());
        rest().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
                .then().statusCode(200)
                .and().body("name", equalTo(pet.getName()));
    }
}
