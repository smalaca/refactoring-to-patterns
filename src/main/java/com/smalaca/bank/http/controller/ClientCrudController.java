package com.smalaca.bank.http.controller;

import com.smalaca.bank.http.dto.ClientDto;
import com.smalaca.bank.http.response.Response;
import com.smalaca.bank.repository.ClientRepository;
import com.smalaca.bank.repository.NotExistingClientException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

class ClientCrudController {
    private final ClientRepository clientRepository;

    ClientCrudController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    Response edit(String clientId, ClientDto clientDto) {
        int result = clientRepository.edit(clientId, clientDto);

        if (result == 0) {
            return new Response(NOT_FOUND);
        }

        return new Response(OK);
    }

    Response remove(String clientId) {
        try {
            clientRepository.removeById(clientId);
            return new Response(OK);
        } catch (NotExistingClientException exception) {
            return new Response(NOT_FOUND);
        }
    }
}
