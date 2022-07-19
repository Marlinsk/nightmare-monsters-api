package com.diary.nightmaremonsters.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diary.nightmaremonsters.dtos.MonsterDTO;
import com.diary.nightmaremonsters.models.Monster;
import com.diary.nightmaremonsters.services.MonsterService;

@RestController
@RequestMapping("/nightmare-diary/monsters")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MonsterController {
	
	private final MonsterService monsterService;

	public MonsterController(MonsterService monsterService) {
		this.monsterService = monsterService;
	}
	
	@PostMapping("/create-monster")
	public ResponseEntity<Object> createMonster(@RequestBody @Valid MonsterDTO monsterDTO) {
		if (monsterService.existsByName(monsterDTO.getName())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: The monster name is already in use!");
		}
		var monster = new Monster();
		BeanUtils.copyProperties(monsterDTO, monster);
		return ResponseEntity.status(HttpStatus.CREATED).body(monsterService.save(monster));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Monster>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(monsterService.findAll());
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Object> getByName(@RequestParam String name) {
		Optional<Monster> monsterModelOptional = monsterService.findByName(name);
		if (!monsterModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This monster not found!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(monsterModelOptional.get());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneMonster(@PathVariable(value = "id") UUID id) {
		Optional<Monster> monsterModelOptional = monsterService.findById(id);
		if (!monsterModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This monster not exist!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(monsterModelOptional.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateMonster(@PathVariable(value = "id") UUID id, @RequestBody @Valid MonsterDTO monsterDTO) {
		Optional<Monster> monsterModelOptional = monsterService.findById(id);
		if (!monsterModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
		}
		var monster = new Monster();
		BeanUtils.copyProperties(monsterDTO, monster);
		monster.setId(monsterModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(monsterService.save(monster));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteMonster(@PathVariable(value = "id") UUID id) {
		Optional<Monster> monsterModelOptional = monsterService.findById(id);
		if (!monsterModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted record!");
	}
}
