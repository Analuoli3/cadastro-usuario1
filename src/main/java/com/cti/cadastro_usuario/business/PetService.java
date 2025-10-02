package com.cti.cadastro_usuario.business;

import com.cti.cadastro_usuario.infrastructure.entitys.Pet;
import com.cti.cadastro_usuario.infrastructure.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PetService {
    private final PetRepository repository;

    public void salvarPet(Pet pet) {
        repository.saveAndFlush(pet);
    }

    public Pet buscarPetPorNome(String nome) {
        return repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado!"));
    }

    public void deletarPetPorNome(String nome) {
        repository.deleteByNome(nome);
    }

    public void atualizarPetPorId(Integer id, Pet pet) {
        Pet petEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        Pet petAtualizado = Pet.builder()
                .id(petEntity.getId())
                .nome(pet.getNome() != null ? pet.getNome() : petEntity.getNome())
                .idade(pet.getIdade() != null ? pet.getIdade() : petEntity.getIdade())
                .raca(pet.getRaca() != null ? pet.getRaca() : petEntity.getRaca())
                .nomeTutor(pet.getNomeTutor() != null ? pet.getNomeTutor() : petEntity.getNomeTutor())
                .petiscoFavorito(pet.getPetiscoFavorito() != null ? pet.getPetiscoFavorito() : petEntity.getPetiscoFavorito())
                .build();

        repository.saveAndFlush(petAtualizado);
    }
}
