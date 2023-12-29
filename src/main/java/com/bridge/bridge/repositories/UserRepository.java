package com.bridge.bridge.repositories;

import com.bridge.bridge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
