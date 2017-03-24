package com.smalaca.designpatterns.example.command.housecontrol;

import com.smalaca.designpatterns.example.command.housecontrol.domain.Fan;
import com.smalaca.designpatterns.example.command.housecontrol.domain.Light;
import com.smalaca.designpatterns.example.command.housecontrol.domain.TimeSpecification;
import com.smalaca.designpatterns.example.command.housecontrol.operation.Operation;

import java.util.HashMap;
import java.util.Map;

import static com.smalaca.designpatterns.example.command.housecontrol.operation.UnsupportedHomeOperationException.anUnsupportedFanOperation;
import static com.smalaca.designpatterns.example.command.housecontrol.operation.UnsupportedHomeOperationException.anUnsupportedLightOperation;
import static java.util.Collections.emptyMap;

class HomeAssistance {
    private final Map<TimeSpecification, Map<Operation, Fan>> fanOperations = new HashMap<>();
    private final Map<TimeSpecification, Map<Operation, Light>> lightOperations = new HashMap<>();

    void schedule(TimeSpecification timeSpecification, Operation operation, Fan fan) {
        if (!fanOperations.containsKey(timeSpecification)) {
            fanOperations.put(timeSpecification, new HashMap<>());
        }

        fanOperations.get(timeSpecification).put(operation, fan);
    }

    void schedule(TimeSpecification timeSpecification, Operation operation, Light light) {
        if (!lightOperations.containsKey(timeSpecification)) {
            lightOperations.put(timeSpecification, new HashMap<>());
        }

        lightOperations.get(timeSpecification).put(operation, light);
    }

    void invokeFor(TimeSpecification timeSpecification) {
        fanOperations.getOrDefault(timeSpecification, emptyMap()).entrySet().stream().forEach(this::executeForFan);
        lightOperations.getOrDefault(timeSpecification, emptyMap()).entrySet().stream().forEach(this::executeForLight);
    }

    private void executeForFan(Map.Entry<Operation, Fan> fanOperation) {
        switch (fanOperation.getKey()) {
            case FAN_SWITCH_ON:
                fanOperation.getValue().switchOn();
                break;
            case FAN_SWITCH_OFF:
                fanOperation.getValue().switchOff();
                break;
            case FAN_REDUCE_POWER:
                fanOperation.getValue().reducePower();
                break;
            case FAN_INCREASE_POWER:
                fanOperation.getValue().increasePower();
                break;

            default:
                throw anUnsupportedFanOperation();
        }
    }

    private void executeForLight(Map.Entry<Operation, Light> lightOperation) {
        switch (lightOperation.getKey()) {
            case LIGHT_TURN_ON:
                lightOperation.getValue().turnOn();
                break;
            case LIGHT_TURN_OFF:
                lightOperation.getValue().turnOff();
                break;
            case DARKEN_LIGHT:
                lightOperation.getValue().darken();
                break;
            default:
                throw anUnsupportedLightOperation();
        }
    }
}
