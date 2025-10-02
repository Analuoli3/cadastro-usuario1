package com.cti.cadastro_usuario.controller;

import com.cti.cadastro_usuario.business.PetService;
import com.cti.cadastro_usuario.infrastructure.entitys.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @PostMapping
    public ResponseEntity<Void> salvarPet(@RequestBody Pet pet) {
        petService.salvarPet(pet);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Pet> buscarPetPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(petService.buscarPetPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPetPorNome(@RequestParam String nome) {
        petService.deletarPetPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarPetPorId(@RequestParam Integer id, @RequestBody Pet pet) {
        petService.atualizarPetPorId(id, pet);
        return ResponseEntity.ok().build();
    }
}
