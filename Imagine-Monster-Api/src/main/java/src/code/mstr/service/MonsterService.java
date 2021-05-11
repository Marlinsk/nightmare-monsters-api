package src.code.mstr.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import src.code.mstr.entidade.Monster;
import src.code.mstr.repository.MonsterRepository;

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
	
	public Monster getMonsterByCodigo(String codigo){
        if(logger.isInfoEnabled()){
            logger.info("Buscando monstro com o codigo {}", codigo);
        }
        Optional<Monster> retorno = this.monsterRepo.findById(codigo);
        if(!retorno.isPresent()){
            throw new RuntimeException("Monstro com o código "+ codigo + " não encontrada");
        }
        return retorno.get();
    }
	
	public Monster getMonsterByNome(String nome){
        if(logger.isInfoEnabled()){
            logger.info("Buscando monstro com o nome {}",nome);
        }
        List<Monster> lista = this.monsterRepo.findByNome(nome);
        if(lista == null || lista.isEmpty()){
            throw new RuntimeException("Monstro com o nome "+ nome +" não encontrada");
        }
        return lista.get(0);
    }
	
	public Monster saveMonster(Monster monster){
        if(logger.isInfoEnabled()){
            logger.info("Salvando monstro com os detalhes {}", monster.toString());
        }
        return this.monsterRepo.save(monster);
    }
	
	public void deleteMonster(String codigo){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo monstro com id {}", codigo);
        }
        this.monsterRepo.deleteById(codigo);
    }
	
	public boolean isMonsterExists(Monster monster){
    	Optional<Monster> retorno = this.monsterRepo.findById(monster.getId());
        return retorno.isPresent() ? true:  false;
    }

    public boolean isMonsterExists(String codigo){
    	Optional<Monster> retorno = this.monsterRepo.findById(codigo);
        return retorno.isPresent() ? true:  false;
    }
}
