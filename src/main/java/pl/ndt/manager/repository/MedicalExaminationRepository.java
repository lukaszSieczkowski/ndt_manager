package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ndt.manager.model.MedicalExamination;
@Repository
public interface MedicalExaminationRepository extends CrudRepository<MedicalExamination, Long>{

}
