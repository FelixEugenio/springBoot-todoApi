package com.mavila.task_app.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavila.task_app.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByUser_Id(Long id);
}
