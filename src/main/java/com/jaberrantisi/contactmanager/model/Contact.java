package com.jaberrantisi.contactmanager.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "contacts")
@Getter
@Builder
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


    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    private String website;

    @Column(name = "street_address")
    private String address;

    private String city;

    private String state;

    @Column(name = "postal_code")
    private String zipcode;

    private String country;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "facebook_url")
    private String facebookUrl;

    @Column(name = "twitter_url")
    private String twitterUrl;

    @Column(name = "instagram_url")
    private String instagramUrl;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "relationship_type")
    private String relationshipType;

    private LocalDate birthday;

    private String notes;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "created_at")
    private Timestamp createdAtTimestamp;

    @Column(name = "updated_at")
    private Timestamp updatedAtTimestamp;

    private Character gender;

    private UUID userId;


}
