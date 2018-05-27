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
    @Column(name = "password")
    private String password;
    @Column(name = "adres")
    private String adres;
    @Column(name = "enabled")
    private Boolean enabled;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userroleid")
    private FitGymUserRole fitGymUserRole;

    public FitGymUser() {
    }

    public FitGymUser(String userimie, String usernazwisko, String useremail, String fitgymid, String password, String adres, Boolean enabled) {
        this.userimie = userimie;
        this.usernazwisko = usernazwisko;
        this.useremail = useremail;
        this.fitgymid = fitgymid;
        this.password = password;
        this.adres = adres;
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = password;
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

    @Override
    public String toString() {
        return "FitGymUser\n{" +
                " \nuserid=" + userid +
                ", \nuserimie='" + userimie + '\'' +
                ", \nusernazwisko='" + usernazwisko + '\'' +
                ", \nuseremail='" + useremail + '\'' +
                ", \nfitgymid='" + fitgymid + '\'' +
                ", \npassword='" + password + '\'' +
                ", \nadres='" + adres + '\'' +
                ", \nenabled=" + enabled +
                "\n}";
    }
}
