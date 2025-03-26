package com.jaberrantisi.contactmanager.model;


import com.jaberrantisi.contactmanager.config.EncryptionConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false, name = "contact_id")
    private UUID contactId;

    @Column(name = "first_name")
    @NotNull(message = "First name required")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name required")
    private String lastName;

    @Convert(converter = EncryptionConverter.class)
    @Column(name = "phone_number")
    private String phoneNumber;

    @Convert(converter = EncryptionConverter.class)
    private String email;

    @Convert(converter = EncryptionConverter.class)
    private String website;

    @Convert(converter = EncryptionConverter.class)
    @Column(name = "company_name")
    private String companyName;

    @Convert(converter = EncryptionConverter.class)
    @Column(name = "job_title")
    private String jobTitle;

    @Convert(converter = EncryptionConverter.class)
    @Column(name = "relationship_type")
    private String relationshipType;

    @Convert(converter = EncryptionConverter.class)
    private LocalDate birthday;

    @Convert(converter = EncryptionConverter.class)
    private String notes;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "created_at")
    private Timestamp createdAtTimestamp;

    @Column(name = "updated_at")
    private Timestamp updatedAtTimestamp;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;




}
