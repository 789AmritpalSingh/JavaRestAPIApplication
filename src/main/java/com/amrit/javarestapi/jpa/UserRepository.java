package com.amrit.javarestapi.jpa;

import com.amrit.javarestapi.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
