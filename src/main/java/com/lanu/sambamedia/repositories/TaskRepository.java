package com.lanu.sambamedia.repositories;

import com.lanu.sambamedia.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
