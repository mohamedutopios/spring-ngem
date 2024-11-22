package tp3.patientsmvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tp3.patientsmvc.entities.Patient;
import tp3.patientsmvc.repositories.PatientRepository;


import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsMvcApplication.class, args);
	}
	//@Bean mettre bean en commantaire pour pas executer cette methode
CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {

			patientRepository.save(new Patient(null,"Hassan",new Date(),false,122));
			patientRepository.save(new Patient(null,"Yasmine",new Date(),false,232));
			patientRepository.save(new Patient(null,"Mohamed",new Date(),false,562));
			patientRepository.save(new Patient(null,"Hanaa",new Date(),false,452));
			patientRepository.findAll().forEach(p->{
				System.out.println(p.getNom());
			});

		};

}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
