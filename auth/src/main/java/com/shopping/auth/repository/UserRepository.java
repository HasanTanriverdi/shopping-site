package com.shopping.auth.repository;

import com.shopping.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserId(int userId);
    public User findByEmail(String email);
}
