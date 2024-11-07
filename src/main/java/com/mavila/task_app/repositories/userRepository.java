package com.mavila.task_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavila.task_app.models.User;

@Repository
public interface userRepository extends JpaRepository<User, Long>{}
