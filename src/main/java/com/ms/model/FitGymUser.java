package com.ms.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fitgymuser")
public class FitGymUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "username")
    private String userName;

    public FitGymUser(String userName) {
        this.userName = userName;
    }

    public FitGymUser() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
