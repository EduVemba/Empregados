package com.example.Empregados;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpregadoRepository extends
        JpaRepository<Empregado, Long> {
    Optional<Empregado> findByEmail(String email);
}
