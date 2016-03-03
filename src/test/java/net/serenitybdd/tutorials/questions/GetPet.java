package net.serenitybdd.tutorials.questions;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.rest;

/**
 * Created by gtarrant-fisher on 03/03/2016.
 */
public class GetPet implements Question<String> {

    private int petId;

    public GetPet(int id)
    {
        this.petId = id;
    }

    @Override
    public String answeredBy(Actor actor) {
        String result = rest().get("http://petstore.swagger.io/v2/pet/{id}", petId).print();
        return result;
    }

    public static Question<String> entryForId(int petId) { return new GetPet(petId);}
}
