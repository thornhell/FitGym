package com.ms.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fitgymuser", schema = "public")
public class FitGymUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private long userid;
    @Column(name = "userimie")
    private String userimie;
    @Column(name = "usernazwisko")
    private String usernazwisko;
    @Column(name = "useremail")
    private String useremail;
    @Column(name = "fitgymid")
    private String fitgymid;
    @Column(name = "adres")
    private String adres;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userroleid")
    private FitGymUserRole fitGymUserRole;

    public FitGymUser() {
    }

    public FitGymUser(String userimie, String usernazwisko, String useremail, String fitgymid, String adres) {
        this.userimie = userimie;
        this.usernazwisko = usernazwisko;
        this.useremail = useremail;
        this.fitgymid = fitgymid;
        this.adres = adres;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
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

    public String getFitgymid() {
        return fitgymid;
    }

    public void setFitgymid(String fitgymid) {
        this.fitgymid = fitgymid;
    }

    public FitGymUserRole getFitGymUserRole() {
        return fitGymUserRole;
    }

    public void setFitGymUserRole(FitGymUserRole fitGymUserRole) {
        this.fitGymUserRole = fitGymUserRole;
    }
}
