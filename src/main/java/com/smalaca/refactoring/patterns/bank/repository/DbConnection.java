package com.smalaca.refactoring.patterns.bank.repository;

interface DbConnection {
    DbConnection getFromTable(String table);

    Object findBy(String columnName, String columnValue);

    DbConnection removeFromTable(String table);

    int by(String columnName, String columnValue);
}
