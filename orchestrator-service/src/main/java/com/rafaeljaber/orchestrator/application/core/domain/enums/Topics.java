package com.rafaeljaber.orchestrator.application.core.domain.enums;

public enum Topics {

    ORCHESTRATOR("tp-saga-orchestrator"),
    SALE("tp-saga-sale"),
    INVENTORY("tp-saga-inventory"),
    PAYMENT("tp-saga-payment");


    private final String topic;

    Topics(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
