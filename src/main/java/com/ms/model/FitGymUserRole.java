package com.ms.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fitgymuserrole", schema = "public")
public class FitGymUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userroleid")
    private long userroleid;

    @OneToMany(mappedBy = "fitGymUserRole", fetch = FetchType.LAZY)
    Set<FitGymUser> fitGymUsers = new HashSet<>();


    @Column(name = "rolename")
    private String rolename;

    public FitGymUserRole(String rolename) {
        this.rolename = rolename;
    }

    public FitGymUserRole() {
    }

    public Set<FitGymUser> getFitGymUsers() {
        return fitGymUsers;
    }

    public void setFitGymUsers(Set<FitGymUser> fitGymUsers) {
        this.fitGymUsers = fitGymUsers;
    }

    public long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(long userroleid) {

        this.userroleid = userroleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }


}
