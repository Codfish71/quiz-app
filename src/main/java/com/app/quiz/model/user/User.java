package com.app.quiz.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Column(length = 60)
    private String firstName;

    @NotBlank
    @Column(length = 60)
    private String lastName;

    @NotBlank
    @Email
    @Column(length = 60)
    private String userEmail;

    @NotBlank
    @Column(length = 60)
    private String userPassword;

    @Column(length = 10)
    private String userGender;

    @Column(length = 10)
    private Long mobileNumber;

    @ElementCollection
    private Set<String> userRoles;

    public User() {
    }

    public User(Long userId, String firstName, String lastName, String userEmail, String userPassword, String userGender, Long mobileNumber, Set<String> userRoles) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.mobileNumber = mobileNumber;
        this.userRoles = userRoles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public @NotBlank String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank @Email String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(@NotBlank @Email String userEmail) {
        this.userEmail = userEmail;
    }

    public @NotBlank String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(@NotBlank String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Set<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<String> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userGender, user.userGender) && Objects.equals(mobileNumber, user.mobileNumber) && Objects.equals(userRoles, user.userRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, userEmail, userPassword, userGender, mobileNumber, userRoles);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userGender='" + userGender + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", userRoles=" + userRoles +
                '}';
    }
}
