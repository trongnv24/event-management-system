package org.aibles.java.springboot.event_management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    @Id
    private String id;
    @Column(nullable = false, unique = true)
    private String name;
    private String createdBy;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;
}
