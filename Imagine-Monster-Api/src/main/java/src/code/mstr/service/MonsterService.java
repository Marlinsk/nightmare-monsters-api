package src.code.mstr.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import src.code.mstr.config.MonsterRepository;
import src.code.mstr.entidade.Monster;

@Service
public class MonsterService {
    
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private final MonsterRepository monsterRepo;
	
	public MonsterService(MonsterRepository monsterRepository){
        this.monsterRepo=monsterRepository;
    }
	
	public List<Monster> getMonster(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Monster> lista = this.monsterRepo.findAll();
        if (lista == null) {
        	return new ArrayList<Monster>();
        }
        return IteratorUtils.toList(lista.iterator());
    }    

	public Monster getMonsterById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando monstro com o código {}",id);
        }
        Optional<Monster> retorno = this.monsterRepo.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Monstro com o código "+ id +" não encontrada");
        }
        return retorno.get();
    }
	
	public List<Monster> getMonsterByNome(String nome){
    	if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Monster> lista = this.monsterRepo.findByNome(nome);
        if (lista == null) {
        	return new ArrayList<Monster>();
        }
        return IteratorUtils.toList(lista.iterator());
    }
	
	public Monster saveMonster(Monster monster){
        if(logger.isInfoEnabled()){
            logger.info("Salvando monstro com os detalhes {}", monster.toString());
        }
        return this.monsterRepo.save(monster);
    }
	
    public void deleteMonster(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo monstro com id {}", id);
        }
        this.monsterRepo.deleteById(id);
    }
}
