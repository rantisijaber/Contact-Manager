package com.jaberrantisi.contactmanager.model;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
@Table(name = "contacts")
public class Contact {

    public Contact() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
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

    public String getFirstName() {
        return firstName;
    }

    private Contact(ContactBuilder contactBuilder) {
        this.firstName = contactBuilder.firstName;
        this.lastName = contactBuilder.lastName;
        this.phoneNumber = contactBuilder.phoneNumber;
        this.email = contactBuilder.email;
        this.website = contactBuilder.website;
        this.address = contactBuilder.address;
        this.city = contactBuilder.city;
        this.state = contactBuilder.state;
        this.zipcode = contactBuilder.zipcode;
        this.country = contactBuilder.country;
        this.linkedinUrl = contactBuilder.linkedinUrl;
        this.facebookUrl = contactBuilder.facebookUrl;
        this.twitterUrl = contactBuilder.twitterUrl;
        this.instagramUrl = contactBuilder.instagramUrl;
        this.companyName = contactBuilder.companyName;
        this.jobTitle = contactBuilder.jobTitle;
        this.relationshipType = contactBuilder.relationshipType;
        this.birthday = contactBuilder.birthday;
        this.notes = contactBuilder.notes;
        this.profilePictureUrl = contactBuilder.profilePictureUrl;
        this.createdAtTimestamp = contactBuilder.createdAtTimestamp;
        this.updatedAtTimestamp = contactBuilder.updatedAtTimestamp;
        this.gender = contactBuilder.gender;

    }

    public static class ContactBuilder {


        private String firstName;

        private String lastName;


        private String phoneNumber;

        private String email;

        private String website;

        private String address;

        private String city;

        private String state;

        private String zipcode;

        private String country;

        private String linkedinUrl;

        private String facebookUrl;

        private String twitterUrl;

        private String instagramUrl;

        private String companyName;

        private String jobTitle;

        private String relationshipType;

        private LocalDate birthday;

        private String notes;

        private String profilePictureUrl;

        private Timestamp createdAtTimestamp;

        private Timestamp updatedAtTimestamp;

        private Character gender;

        public ContactBuilder FirstName(String FirstName) {
            this.firstName = FirstName;
            return this;
        }
        public ContactBuilder LastName(String LastName) {
            this.lastName = LastName;
            return this;
        }
        public ContactBuilder PhoneNumber(String PhoneNumber) {
            this.phoneNumber = PhoneNumber;
            return this;
        }

        public ContactBuilder Email(String Email) {
            this.email = Email;
            return this;
        }
        public ContactBuilder Website(String Website) {
            this.website = Website;
            return this;
        }
        public ContactBuilder Address(String Address) {
            this.address = Address;
            return this;
        }
        public ContactBuilder City(String City) {
            this.city = City;
            return this;
        }
        public ContactBuilder State(String State) {
            this.state = State;
            return this;
        }
        public ContactBuilder Zipcode(String Zipcode) {
            this.zipcode = Zipcode;
            return this;
        }
        public ContactBuilder Country(String Country) {
            this.country = Country;
            return this;
        }
        public ContactBuilder LinkedinUrl(String LinkedinUrl) {
            this.linkedinUrl = LinkedinUrl;
            return this;
        }
        public ContactBuilder FacebookUrl(String FacebookUrl) {
            this.facebookUrl = FacebookUrl;
            return this;
        }
        public ContactBuilder TwitterUrl(String TwitterUrl) {
            this.twitterUrl = TwitterUrl;
            return this;
        }
        public ContactBuilder InstagramUrl(String InstagramUrl) {
            this.instagramUrl = InstagramUrl;
            return this;
        }
        public ContactBuilder CompanyName(String CompanyName) {
            this.companyName = CompanyName;
            return this;
        }
        public ContactBuilder JobTitle(String JobTitle) {
            this.jobTitle = JobTitle;
            return this;
        }
        public ContactBuilder RelationshipType(String RelationshipType) {
            this.relationshipType = RelationshipType;
            return this;
        }
        public ContactBuilder Birthday(LocalDate Birthday) {
            this.birthday = Birthday;
            return this;
        }
        public ContactBuilder Notes(String Notes) {
            this.notes = Notes;
            return this;
        }
        public ContactBuilder ProfilePictureUrl(String ProfilePictureUrl) {
            this.profilePictureUrl = ProfilePictureUrl;
            return this;
        }
        public ContactBuilder CreatedAtTimestamp(Timestamp CreatedAtTimestamp) {
            this.createdAtTimestamp = CreatedAtTimestamp;
            return this;
        }
        public ContactBuilder UpdatedAtTimestamp(Timestamp UpdatedAtTimestamp) {
            this.updatedAtTimestamp = UpdatedAtTimestamp;
            return this;
        }
        public ContactBuilder Gender(Character Gender) {
            this.gender = Gender;
            return this;
        }
        public ContactBuilder() {}

        public Contact build() {
            return new Contact(this);
        }

    }


}
