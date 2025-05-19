package com.example.examen;

import com.example.examen.dtos.ClientDTO;
import com.example.examen.entities.*;
import com.example.examen.enums.CreditStatut;
import com.example.examen.enums.TypeBien;
import com.example.examen.enums.TypeRembouresement;
import com.example.examen.mappers.CreditMapperImpl;
import com.example.examen.repositories.ClientRepository;
import com.example.examen.repositories.CreditRepository;
import com.example.examen.repositories.RemboursementRepository;
import com.example.examen.services.CreditService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

//@Bean
CommandLineRunner start(ClientRepository clientRepository, CreditRepository creditRepository, RemboursementRepository remboursementRepository){
	return args->{
		Stream.of("hassan","Yassine","Yassmine","Aicha").forEach(name->{
			Client client=new Client();
			client.setNom(name);
			client.setEmail(name+"@gmail.com");
			clientRepository.save(client);
		});
		clientRepository.findAll().forEach(cl->{
			CreditImmobilier creditImmobilier=new CreditImmobilier();
			creditImmobilier.setTypeBien(TypeBien.Appartement);
			creditImmobilier.setDateAcceptation(new Date());
			creditImmobilier.setMontant(Math.random()*2000);
			creditImmobilier.setTauxInteret(3.2);
			creditImmobilier.setStatut(CreditStatut.EENCOURS);
			creditImmobilier.setDateDemande(new Date());
			creditImmobilier.setDureeRemboursement(270);
			creditImmobilier.setClient(cl);
			creditRepository.save(creditImmobilier);
			CreditPersonnel cp = new CreditPersonnel();
			cp.setClient(cl);
			cp.setDateDemande(new Date());
			cp.setStatut(CreditStatut.ACCEPTE);
			cp.setMontant(50000);
			cp.setTauxInteret(4.5);
			cp.setDureeRemboursement(36);
			cp.setMotif("Achat de voiture");
			creditRepository.save(cp);


		});

		creditRepository.findAll().forEach(cred->{
			Remboursement remboursement=new Remboursement();
			remboursement.setMontant(Math.random()*1200);
			remboursement.setDate(new Date());
			remboursement.setType(TypeRembouresement.Mensualite);
			remboursement.setCredit(cred);
			remboursementRepository.save(remboursement);


		});
	};
}


}
