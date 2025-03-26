package com.jaberrantisi.contactmanager.config;

import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EncryptionConverter implements AttributeConverter<String, String> {
    private static final Logger logger = LoggerFactory.getLogger(EncryptionConverter.class);
    private final AES256TextEncryptor encryptor = new AES256TextEncryptor();

    @Value("${encryption.secret}")
    private String encryptionKey;

    @PostConstruct
    public void init() {
        if (encryptionKey == null || encryptionKey.length() < 32) {
            throw new IllegalStateException("Invalid encryption key");
        }
        encryptor.setPassword(encryptionKey);
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return (attribute == null || attribute.isBlank()) ? null : encryptor.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }
        try {
            return encryptor.decrypt(dbData);
        } catch (EncryptionOperationNotPossibleException e) {
            logger.warn("Failed to decrypt data (may be plaintext)");
            return dbData; // Return as-is (assume plaintext)
        }
    }
}