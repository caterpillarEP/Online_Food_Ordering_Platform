package com.food.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

	Optional<UserModel> findByEmail(String email);
}
