package parser;

import parser.acts.Act;

public class Action {
    public Act action;
    public int number;

    public Action(Act action, int number) {
        this.action = action;
        this.number = number;
    }

    public String toString() {
        return action.toCustomString() + number;
    }
}