package com.smalaca.designpatterns.example.command.housecontrol;

import com.smalaca.designpatterns.example.command.housecontrol.command.Command;
import com.smalaca.designpatterns.example.command.housecontrol.domain.TimeSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

class HomeAssistance {
    private final Map<TimeSpecification, List<Command>> commands = new HashMap<>();

    void schedule(TimeSpecification timeSpecification, Command command) {
        if (!commands.containsKey(timeSpecification)) {
            commands.put(timeSpecification, new ArrayList<>());
        }

        commands.get(timeSpecification).add(command);
    }

    void invokeFor(TimeSpecification timeSpecification) {
        commands.getOrDefault(timeSpecification, emptyList()).stream().forEach(Command::execute);
    }
}
