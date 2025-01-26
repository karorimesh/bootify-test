package com.test.bootify.bootify_test.repos;

import com.test.bootify.bootify_test.domain.FlywayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author meshack.karori on 11/27/2024.
 */

public interface FlywayRepository extends JpaRepository<FlywayEntity, Long> {
}
