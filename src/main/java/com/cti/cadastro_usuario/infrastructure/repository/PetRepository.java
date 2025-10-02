package com.cti.cadastro_usuario.infrastructure.repository;

import com.cti.cadastro_usuario.infrastructure.entitys.Pet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface PetRepository extends JpaRepository<Pet, Integer> {
    Optional<Pet> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}
