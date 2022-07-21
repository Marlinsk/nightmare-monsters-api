package com.diary.nightmaremonsters.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diary.nightmaremonsters.models.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, UUID> {
	
	boolean existsByName(String name);
	
	Optional<Monster> findByName(String name);
}
