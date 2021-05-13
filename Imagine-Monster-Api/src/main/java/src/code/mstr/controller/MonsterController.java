package src.code.mstr.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import src.code.mstr.entidade.Monster;
import src.code.mstr.service.MonsterService;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "monstrinhos")
public class MonsterController {
   
	private final MonsterService monsterService;
	
	public MonsterController(MonsterService monsterService) {
		this.monsterService=monsterService;
	}
	
	@GetMapping
    public List<Monster> getMonster(){
        return monsterService.getMonster();
    }
	
	@GetMapping(value="{id}")
    public Monster getMonsterById(@PathVariable String id) throws Exception{
        if(!ObjectUtils.isEmpty(id)){
           return monsterService.getMonsterByCodigo(id);
        }
        throw new Exception("Monstro com código "+ id +" não encontrado");
    }
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Monster createMonster(@RequestBody @NotNull Monster monster) throws Exception {
    	if (monsterService.isMonsterExists(monster.getId())) {
    		throw new Exception("Monstro com código " + monster.getId() + " já existe");
    	} 
        return monsterService.saveMonster(monster);
    }
	
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Monster updateMonster(@PathVariable String id, 
    		@RequestBody @NotNull Monster monster) throws Exception {
    	if (!id.equals(monster.getId())) {
    		throw new Exception("Código "+ id +" não está correto");
    	}
    	if (!monsterService.isMonsterExists(monster)) {
    		throw new Exception("Monstro com código " + id + " não existe");
    	}
        return monsterService.saveMonster(monster);
    }
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public boolean updateCriptomoeda(@PathVariable String id) throws Exception {
    	if (!monsterService.isMonsterExists(id)) {
    		throw new Exception("Monstro com código " + id + " não existe");
    	} 
    	monsterService.deleteMonster(id);
        return true;
    }
}
