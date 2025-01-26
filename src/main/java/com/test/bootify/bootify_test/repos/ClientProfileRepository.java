package com.test.bootify.bootify_test.repos;

import com.test.bootify.bootify_test.domain.ClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long> {
}
