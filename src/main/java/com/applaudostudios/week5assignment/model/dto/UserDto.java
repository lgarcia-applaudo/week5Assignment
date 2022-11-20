package com.applaudostudios.week5assignment.model.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

    private Integer id;
    @NotNull(message ="Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message ="Firstname is mandatory")
    @Size(max = 50)
    private String firstName;
    @NotNull(message ="Lastname is mandatory")
    @Size(max = 50)
    private String lastName;
    @Pattern(regexp = "(\\+503)[0-9]{8}" ,message ="Phonenumber must be valid")
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    private UserDto(){

    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public static class Builder{

        private Integer id;
        private String email;

        private String firstName;

        private String lastName;

        private String phoneNumber;


        public Builder id(Integer id){

            this.id = id;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserDto build(){

            UserDto userDto = new UserDto();

            userDto.setId(this.id);
            userDto.setEmail(this.email);
            userDto.setFirstName(this.firstName);
            userDto.setLastName(this.lastName);
            userDto.setPhoneNumber(this.phoneNumber);

            return userDto;
        }
    }
}
