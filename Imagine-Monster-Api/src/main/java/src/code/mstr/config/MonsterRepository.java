package src.code.mstr.config;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import src.code.mstr.entidade.Monster;

@EnableScan()
public interface MonsterRepository extends CrudRepository<Monster, String>{
    List<Monster>findByNome(String nome);
}
