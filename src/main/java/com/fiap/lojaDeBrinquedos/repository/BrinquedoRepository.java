package com.fiap.lojaDeBrinquedos.repository;

import com.fiap.lojaDeBrinquedos.model.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
}
