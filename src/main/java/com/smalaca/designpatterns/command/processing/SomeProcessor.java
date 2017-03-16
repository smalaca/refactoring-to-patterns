package com.smalaca.designpatterns.command.processing;

import com.smalaca.domain.InputParameter;

public class SomeProcessor {
    private final ActionType actionType;
    private final Action1 action1;
    private final Action2 action2;
    private final Action3 action3;

    public SomeProcessor(
            ActionType actionType, Action1 action1, Action2 action2, Action3 action3) {
        this.actionType = actionType;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
    }


    public void process(InputParameter inputParameter) {
        switch (actionType) {
            case SOME_ACTION:
                doSomething(inputParameter);
                break;

            case DIFFERENT_ACTION:
                doSomethingDifferent(inputParameter);
                break;

            case ANOTHER_ACTION:
                doYetAnotherThing(inputParameter);
                break;
        }
    }

    private void doSomething(InputParameter inputParameter) {
        action1.process(inputParameter);
    }

    private void doSomethingDifferent(InputParameter inputParameter) {
        action2.process(inputParameter);
    }

    private void doYetAnotherThing(InputParameter inputParameter) {
        action3.process(inputParameter);
    }
}
