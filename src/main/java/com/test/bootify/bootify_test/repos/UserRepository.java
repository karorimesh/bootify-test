package com.test.bootify.bootify_test.repos;

import com.test.bootify.bootify_test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
