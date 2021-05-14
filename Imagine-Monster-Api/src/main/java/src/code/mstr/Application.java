package src.code.mstr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import src.code.mstr.config.DynamoDBConfig;

@SpringBootApplication
@Import({DynamoDBConfig.class})
public class Application {
	
	private static final Logger lon = LoggerFactory.getLogger(Application.class);
    
	public static void main(String[] args) {

		lon.info("Iniciando...");
		System.setProperty("server.servlet.context-path", "/monstrinho-api");
		new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
         
	}
	
}
