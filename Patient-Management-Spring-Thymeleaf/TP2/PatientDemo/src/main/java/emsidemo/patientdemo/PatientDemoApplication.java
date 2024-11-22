package emsidemo.patientdemo;

import emsidemo.patientdemo.entities.Patient;
import emsidemo.patientdemo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Clock;
import java.util.Date;
import java.util.List;

@SpringBootApplication

public class PatientDemoApplication implements CommandLineRunner {
	@Autowired //injecter PatientRepository a la variable
private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(PatientDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0;i<100;i++) {
			patientRepository.save(new Patient(null, "hassan", new Date(), (int)(Math.random()*100), Math.random()>0.5?true:false));
		}
// on peut iterer le contenu de la page
		Page<Patient> patients= patientRepository.findAll(PageRequest.of(1,5));
		System.out.println("Total pages : "+patients.getTotalPages());
		System.out.println("Total Elements : "+patients.getTotalElements());
		System.out.println("Num Page : "+patients.getNumber());
		List<Patient> content=patients.getContent(); // contenue de la page
		Page<Patient> byMalade = patientRepository.findByMalade(true,PageRequest.of(0,4));
		List<Patient> patientList= patientRepository.chercherPatients("%h%",40);

		patientList.forEach(
				p->{
					System.out.println("=============================");
					System.out.println(p.getId());
					System.out.println(p.getNom());
					System.out.println(p.getScore());
					System.out.println(p.getDateNaissance());
					System.out.println(p.isMalade());

				}
		);
		System.out.println("********************************");
Patient patient=patientRepository.findById(1L).orElse(null);
// or elsethrow ou bien or else null , la method get retourne soit l'objet recherché ou bei nrenvoie une erreur qu' on a pas traité.

if(patient!=null){
	System.out.println(patient.getNom());
	System.out.println(patient.isMalade());
}
patient.setScore(870);
patientRepository.save(patient);
patientRepository.deleteById(1L);


	}
}
