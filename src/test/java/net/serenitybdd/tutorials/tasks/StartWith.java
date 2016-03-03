package net.serenitybdd.tutorials.tasks;



import com.google.common.collect.Lists;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.tutorials.model.Pet;
import net.serenitybdd.tutorials.tasks.rest.GetPetByEmptyId;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by gtarrant-fisher on 02/03/2016.
 */
public class StartWith  {

    public static StartWithAnEmptyList anEmptyTodoList() {
        return instrumented(StartWithAnEmptyList.class);
    }

    public static StartWithATodoListContaining aTodoListContaining(String... todos) {
        return Instrumented.instanceOf(StartWithATodoListContaining.class)
                .withProperties(Lists.newArrayList(todos));
    }

    public static GetPetByEmptyId NoListingForPet(Pet pet) {
        return Instrumented.instanceOf(GetPetByEmptyId.class)
                .withProperties(pet);
    }

}
