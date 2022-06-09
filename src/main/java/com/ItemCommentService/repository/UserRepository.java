package com.ItemCommentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ItemCommentService.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
