package com.ms.repository;

import com.ms.model.FitGymUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<FitGymUser, Long> {
}
