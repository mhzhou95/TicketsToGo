package com.github.mhzhou95.javaSpringBootTemplate.model;


import com.github.mhzhou95.javaSpringBootTemplate.model.Ticket;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import java.time.ZonedDateTime;

@Entity
public class Organization {
    //Id is auto generated. Do not add to constructor or create a getter/setter or it will create error.
    //Most likely the error missing default constructor for the Id
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;

    @NotNull
    @Column(unique = true)
    private String organizationName;
    @NotNull
    @Column(unique = true)
    private long accountNumber;
    //Need this tag for collections for some reason. Don't know why it fixed the issue:
    //"Could not determine type for: java.util.Set."
    @OneToMany(fetch = FetchType.LAZY)
    private Set<User> contacts;
    @OneToMany(fetch = FetchType.LAZY)
    Set<Ticket> allUsersTickets;
    private boolean isForeignAddress;
    private String city;
    private String state;
    private String streetAddress;
    private String zipcode;
    private String country;
    private String organizationPhoneNumber;
    //the java.time is the newest java date API
    private final ZonedDateTime dateCreated = ZonedDateTime.now();
    private ZonedDateTime dateModified = ZonedDateTime.now();;

    //Kept getting the error "error missing default constructor"
    //For some reason adding in an empty constructor seems to solve the issue. Not sure why


    public Organization() {
    }

    public Organization(String organizationName, long accountNumber, Set<User> contacts, boolean isForeignAddress, String city, String state, String streetAddress, String zipcode, String country, String organizationPhoneNumber) {
        this.organizationName = organizationName;
        this.accountNumber = accountNumber;
        this.contacts = contacts;
        this.isForeignAddress = isForeignAddress;
        this.city = city;
        this.state = state;
        this.streetAddress = streetAddress;
        this.zipcode = zipcode;
        this.country = country;
        this.organizationPhoneNumber = organizationPhoneNumber;
    }

    //Id is auto-generated so we do not have a setter.
    //However, we need this getter so that the Json response will give the Id
    //in its http response.
    public Long getId() {
           return id;
       }

    public String getOrganizationName() {
        return organizationName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public Set<Ticket> getAllUsersTickets() {
        return allUsersTickets;
    }

    public void setAllUsersTickets(Set<Ticket> allUsersTickets) {
        this.allUsersTickets = allUsersTickets;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Set<User> getContacts() {
        return contacts;
    }

    public void setContacts(Set<User> contacts) {
        this.contacts = contacts;
    }

    public boolean isForeignAddress() {
        return isForeignAddress;
    }

    public void setForeignAddress(boolean foreignAddress) {
        isForeignAddress = foreignAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrganizationPhoneNumber() {
        return organizationPhoneNumber;
    }

    public void setOrganizationPhoneNumber(String organizationPhoneNumber) {
        this.organizationPhoneNumber = organizationPhoneNumber;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(ZonedDateTime dateModified) {
        this.dateModified = dateModified;
    }
}
