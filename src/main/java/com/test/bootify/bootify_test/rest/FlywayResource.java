package com.test.bootify.bootify_test.rest;

import com.test.bootify.bootify_test.service.FlywayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meshack.karori on 11/27/2024.
 */
@RestController
@RequestMapping("flyway")
@RequiredArgsConstructor
public class FlywayResource {
    private final FlywayService flywayService;

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        flywayService.delete(id);
    }
}
