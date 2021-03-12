package ch.noser.uek223.domain.user.dto;

public class UserDTONew {
    private String email;
    private String password;
    private String firstName;
    private String surname;

    public UserDTONew() {
    }

    public UserDTONew(String email, String password, String firstName, String surname) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public UserDTONew setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTONew setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTONew setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserDTONew setSurname(String surname) {
        this.surname = surname;
        return this;
    }
}
