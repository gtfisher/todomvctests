package net.serenitybdd.tutorials.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.tutorials.ui.TodoMvcApplicationHomePage;
import net.thucydides.core.annotations.Step;

/**
 * Created by gtarrant-fisher on 02/03/2016.
 */
public class StartWithAnEmptyList implements Task {

    TodoMvcApplicationHomePage todoMvcApplicationHomePage;

    @Override
    @Step("{0} starts with an empty todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(todoMvcApplicationHomePage)
        );
    }
}
