package parser;

import parser.acts.Act;

public class Action {
    public Act action;
    //if action = shift : number is state
    //if action = reduce : number is number of rule
    public int number;

    public Action(Act action, int number) {
        this.action = action;
        this.number = number;
    }

    public String toString() {
        return action.toCustomString() + number;
    }
}