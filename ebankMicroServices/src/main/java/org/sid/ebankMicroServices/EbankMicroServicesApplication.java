package org.sid.ebankMicroServices;

import org.sid.ebankMicroServices.entities.Compte;
import org.sid.ebankMicroServices.enums.TypeCompte;
import org.sid.ebankMicroServices.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankMicroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbankMicroServicesApplication.class, args);
	}

@Bean
	CommandLineRunner start(CompteRepository compteRepository){
		return args -> {
			for(int i=0; i<10;i++){
				Compte compte=Compte.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? TypeCompte.CREDIT:TypeCompte.EPARGNE)
						.dateCreation(new Date())
						.montantCmpt(150000)
						.devise("MAD")
						.build();
				compteRepository.save(compte);
			}
		};
}

}
