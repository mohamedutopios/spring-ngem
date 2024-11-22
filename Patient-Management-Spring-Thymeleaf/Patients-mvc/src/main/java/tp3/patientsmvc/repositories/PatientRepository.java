package tp3.patientsmvc.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tp3.patientsmvc.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

Page<Patient> findByNomContains(String kw, Pageable pageable);

}
