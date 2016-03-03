package net.serenitybdd.tutorials.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.List;

/**
 * Created by gtarrant-fisher on 02/03/2016.
 */
public class StartWithATodoListContaining implements Task {

    private final List<String> todos;

    public StartWithATodoListContaining(List<String> todos) {
        this.todos = todos;
    }

    @Override
    @Step("{0} starts with a todo list containing #todos")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(StartWith.anEmptyTodoList());
        todos.forEach(
                todoItem -> actor.attemptsTo(AddATodoItem.called(todoItem))
        );
    }
}
