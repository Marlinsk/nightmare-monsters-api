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
		return this.monsterRepository.save(monster);
	}
	
	public boolean existsByName(String name) {
		return this.monsterRepository.existsByName(name);
	}
	
	public List<Monster> findAll() {
		return this.monsterRepository.findAll();
	}
	
	public Optional<Monster> findByName(String name){
		return this.monsterRepository.findByName(name);
	}
	
	public Optional<Monster> findById(UUID id) {
		return this.monsterRepository.findById(id);
	}
	
	@Transactional
	public void Delete(Monster monsterModel) {
		this.monsterRepository.delete(monsterModel);
	}
}
