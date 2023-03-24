package com.amrit.javarestapiwithspring_springboot_hibernate.jpa;

import com.amrit.javarestapiwithspring_springboot_hibernate.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
