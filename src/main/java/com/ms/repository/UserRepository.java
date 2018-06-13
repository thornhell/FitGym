package com.ms.repository;

import com.ms.model.FitGymUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository  {
    long allUserCount();
    long allActiveUserCount();
    FitGymUser findByFitgymid(String name);
    List<FitGymUser> allUsers();
    void persist(FitGymUser fitGymUser);
}
