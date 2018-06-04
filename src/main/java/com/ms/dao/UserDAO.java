package com.ms.dao;

import com.ms.model.FitGymUser;
import org.springframework.data.repository.CrudRepository;


public interface UserDAO extends CrudRepository<FitGymUser, Long> {
    FitGymUser findUserByFitgymid(String fitgymid);
}
