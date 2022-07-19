package com.diary.nightmaremonsters.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diary.nightmaremonsters.models.Monster;
import com.diary.nightmaremonsters.repositories.MonsterRepository;

@Service
public class MonsterService {
	
	private final MonsterRepository monsterRepository;

	public MonsterService(MonsterRepository monsterRepository) {
		this.monsterRepository = monsterRepository;
	} 
	
	@Transactional
	public Monster save(Monster monster) {
		return monsterRepository.save(monster);
	}
	
	public boolean existsByName(String name) {
		return monsterRepository.existsByName(name);
	}
	
	public List<Monster> findAll() {
		return monsterRepository.findAll();
	}
	
	public Optional<Monster> findById(UUID id) {
		return monsterRepository.findById(id);
	}
	
	@Transactional
	public void Delete(Monster monsterModel) {
		monsterRepository.delete(monsterModel);
	}
}
