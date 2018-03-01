package com.lanu.sambamedia.repositories;

import com.lanu.sambamedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
