package com.smalaca.designpatterns.state;

public class SomeDomainObject {
    private String someStringValue;
    private int someIntValue;

    public String getSomeStringValue() {
        return someStringValue;
    }

    public int getSomeIntValue() {
        return someIntValue;
    }

    public void changeStateTo(SomeState state) {
        switch (state) {
            case STATE_1:
                changeAccordingToState1();
                break;

            case STATE_2:
                changeAccordingToState2();
                break;

            case STATE_3:
                changeAccordingToState3();
                break;
        }
    }

    private void changeAccordingToState1() {
        someIntValue = 13;
        someStringValue = "foo";
    }

    private void changeAccordingToState2() {
        someIntValue = 69;
        someStringValue = "bar";
    }

    private void changeAccordingToState3() {
        someIntValue = 13 + 69;
        someStringValue = "fooBarBaz";
    }
}
