package com.lanu.sambamedia.repositories;

import com.lanu.sambamedia.entities.Task;
import com.lanu.sambamedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
