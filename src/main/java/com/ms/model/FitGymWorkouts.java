package com.ms.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fitgymworkouts")
public class FitGymWorkouts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workoutid;

    @Column(name = "workoutstart")
    private Timestamp workoutstart;

    @Column(name = "workoutend")
    private Timestamp workoutend;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private FitGymUser fitGymUser;

    public FitGymUser getFitGymUser() {
        return fitGymUser;
    }

    public void setFitGymUser(FitGymUser fitGymUser) {
        this.fitGymUser = fitGymUser;
    }

    public FitGymWorkouts() {
    }
    public FitGymWorkouts(Timestamp workoutstart, Timestamp workoutend) {
        this.workoutstart = workoutstart;
        this.workoutend = workoutend;
    }

    public long getWorkoutid() {
        return workoutid;
    }

    public void setWorkoutid(long workoutid) {
        this.workoutid = workoutid;
    }

    public Timestamp getWorkoutstart() {
        return workoutstart;
    }

    public void setWorkoutstart(Timestamp workoutstart) {
        this.workoutstart = workoutstart;
    }

    public Timestamp getWorkoutend() {
        return workoutend;
    }

    public void setWorkoutend(Timestamp workoutend) {
        this.workoutend = workoutend;
    }
}
