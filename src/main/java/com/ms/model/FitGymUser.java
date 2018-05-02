package com.ms.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fitgymusers", schema = "public")
public class FitGymUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private long userid;
    @Column(name = "userimie")
    private String userimie;
    @Column(name = "usernazwisko")
    private String usernazwisko;

    public FitGymUser() {
    }

    @Column(name = "useremail")

    private String useremail;
    @Column(name = "usernumerkarty")
    private String usernumerkarty;

    public FitGymUser(String userimie, String usernazwisko, String useremail, String usernumerkarty) {
        this.userimie = userimie;
        this.usernazwisko = usernazwisko;
        this.useremail = useremail;
        this.usernumerkarty = usernumerkarty;
    }

    public long getUserId() {
        return userid;
    }

    public void setUserId(long userId) {
        this.userid = userId;
    }

    public String getUserimie() {
        return userimie;
    }

    public void setUserimie(String userimie) {
        this.userimie = userimie;
    }

    public String getUsernazwisko() {
        return usernazwisko;
    }

    public void setUsernazwisko(String usernazwisko) {
        this.usernazwisko = usernazwisko;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsernumerkarty() {
        return usernumerkarty;
    }

    public void setUsernumerkarty(String usernumerkarty) {
        this.usernumerkarty = usernumerkarty;
    }
}
