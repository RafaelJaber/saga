package com.rafaeljaber.orchestrator.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafaeljaber.orchestrator.adapters.out.message.SaleMessage;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;


public class CustomDeserializer implements Deserializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public SaleMessage deserialize(String s, byte[] bytes) {
        try {
            if (bytes == null) {
                return null;
            }
            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), SaleMessage.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing SaleMessage from byte[]");
        }
    }

}
