package com.smalaca.bank.repository;

import com.smalaca.bank.domain.Client;
import com.smalaca.bank.http.dto.ClientDto;

public class ClientRepository {
    private DbConnection dbConnection;

    public int edit(String clientId, ClientDto clientDto) {
        Object object = dbConnection.getFromTable("Client").findBy("clientId", clientId);

        if (object == null) {
            return 0;
        } else {
            Client client = (Client) object;
            client.update(clientDto);
            store(client);

            return 1;
        }
    }

    private void store(Client client) {

    }

    public void removeById(String clientId) {
        int removedRows = dbConnection.removeFromTable("Client").by("clientId", clientId);

        if (removedRows == 0) {
            throw new NotExistingClientException();
        }
    }
}
