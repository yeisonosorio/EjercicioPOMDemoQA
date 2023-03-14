package com.sofkau.util;

public enum log4j {

    LOG4J_PROPERTIES_FILE_PATH("/src/test/resources/log4j.properties");

    //LOAD(); MANEJO DE LAS CONTANTES NO MAS DE 20


    private final String value;

    log4j(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
