package com.amrit.javarestapi.jpa;

import com.amrit.javarestapi.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
