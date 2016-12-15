package com.smalaca.bank.repository;

public interface DbConnection {
    DbConnection getFromTable(String table);

    Object findBy(String columnName, String columnValue);

    DbConnection removeFromTable(String table);

    int by(String columnName, String columnValue);
}
