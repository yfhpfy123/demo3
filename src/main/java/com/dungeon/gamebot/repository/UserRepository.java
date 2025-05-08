package com.dungeon.gamebot.repository;

import com.dungeon.gamebot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
