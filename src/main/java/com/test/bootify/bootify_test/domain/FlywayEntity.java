package com.test.bootify.bootify_test.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author meshack.karori on 11/27/2024.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"flyway_schema_history\"")
public class FlywayEntity {
    @Id
    @Column(name = "\"installed_rank\"")
    private Long id;
}
