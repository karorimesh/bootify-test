package com.test.bootify.bootify_test.service;

import com.test.bootify.bootify_test.repos.FlywayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meshack.karori on 11/27/2024.
 */
@RequiredArgsConstructor
@Service
public class FlywayService {
    private final FlywayRepository flywayRepository;

    public void delete(Long id) {
        flywayRepository.deleteById(id);
    }
}
