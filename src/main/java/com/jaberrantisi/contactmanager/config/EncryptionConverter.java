package com.jaberrantisi.contactmanager.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.stereotype.Component;

@Component
@Converter(autoApply = true)
public class EncryptionConverter implements AttributeConverter<String, String> {
    private static final AES256TextEncryptor encryptor = new AES256TextEncryptor();

    @Value("${encryption.secret}")
    public void setEncryptionKey(String key) {
        encryptor.setPassword(key);
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return (attribute == null || attribute.isBlank()) ? null : encryptor.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return (dbData == null || dbData.isBlank()) ? null : encryptor.decrypt(dbData);
    }
}
