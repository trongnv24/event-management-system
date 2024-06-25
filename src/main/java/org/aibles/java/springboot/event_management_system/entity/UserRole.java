package org.aibles.java.springboot.event_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "user_role")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserRole.class)
public class UserRole {
    @Id
    private String userId;
    @Id
    private String roleId;
}
