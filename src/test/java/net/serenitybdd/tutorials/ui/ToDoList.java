package net.serenitybdd.tutorials.ui;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Created by gtarrant-fisher on 02/03/2016.
 */
public class ToDoList {
    public static Target WHAT_NEEDS_TO_BE_DONE
            = Target.the("'What needs to be done? field").locatedBy("#new-todo");
    public static Target ITEMS =Target.the("List of todo items")
            .locatedBy(".view label");
}
