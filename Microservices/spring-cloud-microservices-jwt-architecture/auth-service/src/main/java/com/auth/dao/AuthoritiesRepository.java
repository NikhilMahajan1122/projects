package com.auth.dao;

import com.auth.modal.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {
    public Optional<Authority> findByAuthority(String authority);
}
