package src.code.mstr.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import src.code.mstr.config.MonsterRepository;
import src.code.mstr.entidade.Monster;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PropertyPlaceholderAutoConfiguration.class, ApiMonsterTeste.DynamoDBConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiMonsterTeste {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ApiMonsterTeste.class);
	
	@Configuration
	@EnableDynamoDBRepositories(basePackageClasses = MonsterRepository.class)
	public static class DynamoDBConfig {

		@Value("${amazon.aws.accesskey}")
		private String amazonAWSAccessKey;

		@Value("${amazon.aws.secretkey}")
		private String amazonAWSSecretKey;

		public AWSCredentialsProvider amazonAWSCredentialsProvider() {
			return new AWSStaticCredentialsProvider(amazonAWSCredentials());
		}

		@Bean
		public AWSCredentials amazonAWSCredentials() {
			return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
		}

		@Bean
		public AmazonDynamoDB amazonDynamoDB() {
			return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
					.withRegion(Regions.US_EAST_1).build();
		}
	}
	
	@Autowired
	private MonsterRepository repository;
	
	@Test
	public void teste1Criacao() {
		
		LOGGER.info("Criando objetos...");
		
		Monster monstrinho1 = new Monster(
				                "Larrah", 
				                "Kranheiming", 
				                "Aquático", 
				                "Meio arraia meio lacraia, sua aparência lembra muito esses dois animais.", 
				                "É um monstro de hábitos noturnos, e gosta de aproveitar da sua camuflagem no ambiente em que vive para poder caçar suas presas. Possuí duas quelíceras na região do rosto e um ferrão na ponta da cauda. É um monstro que antes de vir para terra era venesoso, mas depois de ver que suas presas eram mais fáceis de capturar, ele evoluiu em tamanho e força e deixando o veneno de lado", 
				                "Reina", 
				                "Pantanos", 
				                "Pequenos e grandes animais, também costuma comer cascas e galhos de árvores podres", 
				                "3.2", 
				                "Não sobrevive por muito tempo fora d'agua em ambientes secos e de pouca umidade");
		repository.save(monstrinho1);
	
		Iterable<Monster> lista = repository.findAll();
		assertNotNull(lista.iterator());
		
		for (Monster monstro : lista) {
			LOGGER.info(monstro.toString());
		}
		LOGGER.info("Pesquisado um objeto");
		
		List<Monster> result = repository.findByNome("Larrah");
		assertEquals(result.size(), 4);
		LOGGER.info("Encontrado: {}", result.size());
	}
	
	@Test
	public void teste2Exclusao(){
		
		LOGGER.info("Excluindo objetos...");
		List<Monster> result = repository.findByNome("Larrah");
		for (Monster monstro : result) {
			LOGGER.info("Excluindo monstro do id = "+ monstro.getId());
			repository.delete(monstro);
		}
		result = repository.findByNome("Larrah");
		assertEquals(result.size(), 0);
		LOGGER.info("Exclusão feita com sucesso");
	}
}
