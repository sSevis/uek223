package ch.noser.uek223.domain.user.dto;

import java.util.UUID;

public class UserDTOSupplier {

    private UUID id;

    private String firstname;

    private String surname;

    public UserDTOSupplier(UUID id, String firstname, String surname) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
    }

    public UserDTOSupplier() {
    }

    public UUID getId() {
        return id;
    }

    public UserDTOSupplier setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public UserDTOSupplier setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserDTOSupplier setSurname(String surname) {
        this.surname = surname;
        return this;
    }
}
