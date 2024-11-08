package com.mavila.task_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mavila.task_app.models.Task;

public interface taskRepository  extends JpaRepository<Task,Long>{}
