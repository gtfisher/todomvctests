package net.serenitybdd.tutorials.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.tutorials.ui.ToDoList;

import java.util.List;

/**
 * Created by gtarrant-fisher on 02/03/2016.
 */
public class TheTodoItems implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(ToDoList.ITEMS)
                .viewedBy(actor)
                .asList();
    }

    public static Question<List<String>> displayed() {
        return new TheTodoItems();
    }
}
