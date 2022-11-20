package com.applaudostudios.week5assignment.model.entity;

import javax.persistence.*;

@Entity
@Table(name="`user`")
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="`user_id`")
    private Integer userId;

    @Column(name="`user_email`")
    private String userEmail;

    @Column(name="`user_first_name`")
    private String userFirstName;

    @Column(name="`user_last_name`")
    private String userLastName;

    @Column(name="`user_phone_number`")
    private String userPhoneNumber;

    public UserEntity() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
}
