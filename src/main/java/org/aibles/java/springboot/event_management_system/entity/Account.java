package org.aibles.java.springboot.event_management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String id;
    private String userId;
    @Column(name = "username")
    private String username;
    @Column(name = "is_activated")
    private boolean isActivated;
    private String password;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    private Long createAt;
    @Column (name = "last_updated_by")
    private String lastUpdatedBy;
    @Column(name = "last_updated_at")
    private Long lastUpdatedAt;
}
