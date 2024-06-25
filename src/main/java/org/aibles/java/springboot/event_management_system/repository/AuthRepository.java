package org.aibles.java.springboot.event_management_system.repository;

import org.aibles.java.springboot.event_management_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Account, String> {
    Optional<Account> findByUsername(String username);
}
