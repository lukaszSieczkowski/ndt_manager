package pl.ndt.manager.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.ndt.manager.dto.*;
import pl.ndt.manager.model.*;
import pl.ndt.manager.model.enums.DocumentIsValid;
import pl.ndt.manager.repository.*;

import pl.ndt.manager.utils.DateConverter;
import pl.ndt.manager.utils.FileTool;

@Service
public class DocumentService implements FileDirectory {

	@Autowired
	private NdtCertificateRepository ndtCertificateRepository;
	@Autowired
	private VcaCertificateRepository vcaCertificateRepository;
	@Autowired
	private MedicalExaminationRepository medicalExaminationRepository;
	@Autowired
	private JaegerTestRepository jaegerTestRepository;
	@Autowired
	private UserRepository userRepository;

	private DateConverter dateConverter;
	private List<DocumentDTO> documents;

	/**
	 * Creates list of all NDT Certificates
	 * 
	 * @return NDT Certificates list
	 */
	public List<DocumentDTO> getNdtCertificates() {

		documents = new ArrayList<>();
		dateConverter = new DateConverter();

		List<NdtCertificate> ndtCertificateList = (List<NdtCertificate>) ndtCertificateRepository.findAll();

		for (NdtCertificate ndtCert : ndtCertificateList) {
			NdtCertificateDTO ndtCertDto = new NdtCertificateDTO();
			ndtCertDto.setIssueDate(dateConverter.createDateToString(ndtCert.getIssueDate()));
			ndtCertDto.setExpirationDate(dateConverter.createDateToString(ndtCert.getExpirationDate()));
			ndtCertDto.setIssuedBy(ndtCert.getIssuedBy());
			String fileDirectory = UPLOAD_FOLDER + ndtCert.getFileName() + ".pdf";
			ndtCertDto.setFileDirectory(fileDirectory);
			ndtCertDto.setOwnersNameAndSurname(
					ndtCert.getEmployee().getFirstName() + " " + ndtCert.getEmployee().getLastName());
			ndtCertDto.setDocumentNumber(ndtCert.getDocumentNumber());
			ndtCertDto.setSector(ndtCert.getSector());
			ndtCertDto.setNdtMethod(ndtCert.getNdtMethod());
			ndtCertDto.setDocumentIsValid(checkDocumentExpiredDate(ndtCert.getExpirationDate()));
			documents.add(ndtCertDto);
		}
		return documents;
	}

	/**
	 * Creates list of all VCA Certificates
	 * 
	 * @return VCA Certificates list
	 */
	public List<DocumentDTO> getVcaCertificates() {
		documents = new ArrayList<>();
		dateConverter = new DateConverter();
		List<VcaCertificate> vcaCertificatelist = (List<VcaCertificate>) vcaCertificateRepository.findAll();

		for (VcaCertificate vcaCert : vcaCertificatelist) {
			VcaCertificateDTO vcaCertDto = new VcaCertificateDTO();
			vcaCertDto.setIssueDate(dateConverter.createDateToString(vcaCert.getIssueDate()));
			vcaCertDto.setExpirationDate(dateConverter.createDateToString(vcaCert.getExpirationDate()));
			vcaCertDto.setIssuedBy(vcaCert.getIssuedBy());

			vcaCertDto.setOwnersNameAndSurname(
					vcaCert.getEmployee().getFirstName() + " " + vcaCert.getEmployee().getLastName());
			vcaCertDto.setDocumentNumber(vcaCert.getDocumentNumber());
			vcaCertDto.setDocumentIsValid(checkDocumentExpiredDate(vcaCert.getExpirationDate()));
			documents.add(vcaCertDto);
		}
		return documents;
	}

	/**
	 * Creates list of all Medical certificates
	 * 
	 * @return Medical Certificates list
	 */
	public List<DocumentDTO> getMedicalExaminations() {
		documents = new ArrayList<>();
		dateConverter = new DateConverter();
		List<MedicalExamination> medicalCertificateList = (List<MedicalExamination>) medicalExaminationRepository
				.findAll();

		for (MedicalExamination medCert : medicalCertificateList) {
			MedicalExaminationDTO medCertDto = new MedicalExaminationDTO();
			medCertDto.setIssueDate(dateConverter.createDateToString(medCert.getIssueDate()));
			medCertDto.setExpirationDate(dateConverter.createDateToString(medCert.getExpirationDate()));
			medCertDto.setIssuedBy(medCert.getIssuedBy());

			medCertDto.setOwnersNameAndSurname(
					medCert.getEmployee().getFirstName() + " " + medCert.getEmployee().getLastName());

			medCertDto.setRequirementsDescription(medCert.getRequirementsDescription());
			medCertDto.setRequirementsFullFilled(medCert.getRequirementsFullFilled());
			medCertDto.setDocumentIsValid(checkDocumentExpiredDate(medCert.getExpirationDate()));

			documents.add(medCertDto);
		}
		return documents;
	}

	/**
	 * Creates list of all Jaeger Tests
	 * 
	 * @return Jaeger Tests list
	 */
	public List<DocumentDTO> getJaegerTests() {
		documents = new ArrayList<>();
		dateConverter = new DateConverter();
		List<JaegerTest> jaegerTests = (List<JaegerTest>) jaegerTestRepository.findAll();

		for (JaegerTest jaegerTest : jaegerTests) {
			JaegerTestDTO jaegerTestDto = new JaegerTestDTO();
			jaegerTestDto.setIssueDate(dateConverter.createDateToString(jaegerTest.getIssueDate()));
			jaegerTestDto.setExpirationDate(dateConverter.createDateToString(jaegerTest.getExpirationDate()));
			jaegerTestDto.setIssuedBy(jaegerTest.getIssuedBy());

			jaegerTestDto.setOwnersNameAndSurname(
					jaegerTest.getEmployee().getFirstName() + " " + jaegerTest.getEmployee().getLastName());
			jaegerTestDto.setCorerctlyEyeCondition(jaegerTest.getCorerctlyEyeCondition());
			jaegerTestDto.setDocumentIsValid(checkDocumentExpiredDate(jaegerTest.getExpirationDate()));
			documents.add(jaegerTestDto);
		}
		return documents;
	}

	/**
	 * Saves new NDT Certificate in System
	 * 
	 * @param ndtCertificateDTO
	 */
	public void saveNdtCertificate(NdtCertificateDTO ndtCertificateDTO) {

		dateConverter = new DateConverter();
		NdtCertificate ndtCertificate = new NdtCertificate();
		ndtCertificate.setIssueDate(dateConverter.createDateFromString(ndtCertificateDTO.getIssueDate(), 0, 0));
		ndtCertificate
				.setExpirationDate(dateConverter.createDateFromString(ndtCertificateDTO.getExpirationDate(), 0, 0));
		ndtCertificate.setIssuedBy(ndtCertificateDTO.getIssuedBy());
		ndtCertificate.setDocumentNumber(ndtCertificateDTO.getDocumentNumber());
		ndtCertificate.setSector(ndtCertificateDTO.getSector());
		ndtCertificate.setNdtMethod(ndtCertificateDTO.getNdtMethod());

		Employee employee = createEmployeeByEmail(ndtCertificateDTO.getEmail());
		ndtCertificate.setEmployee(employee);

		FileTool fileTool = new FileTool();
		String fileName = fileTool.saveFile(ndtCertificateDTO.getFile(), employee.getLastName());

		ndtCertificate.setFileName(fileName);
		ndtCertificateRepository.save(ndtCertificate);

	}

	/**
	 * Saves new Jaeger Test in System
	 * 
	 * @param ndtCertificateDTO
	 */
	public void saveJaegerTest(JaegerTestDTO jaegerTestDTO) {
		dateConverter = new DateConverter();
		JaegerTest jaegerTest = new JaegerTest();
		jaegerTest.setIssueDate(dateConverter.createDateFromString(jaegerTestDTO.getIssueDate(), 0, 0));
		jaegerTest.setExpirationDate(dateConverter.createDateFromString(jaegerTestDTO.getExpirationDate(), 0, 0));
		jaegerTest.setIssuedBy(jaegerTestDTO.getIssuedBy());

		Employee employee = createEmployeeByEmail(jaegerTestDTO.getEmail());
		jaegerTest.setEmployee(employee);

		jaegerTest.setCorerctlyEyeCondition(jaegerTestDTO.getCorerctlyEyeCondition());

		FileTool fileTool = new FileTool();
		String fileName = fileTool.saveFile(jaegerTestDTO.getFile(), employee.getLastName());
		jaegerTest.setFileName(fileName);

		jaegerTestRepository.save(jaegerTest);

	}

	/**
	 * Saves VCA Certifcate in System
	 * 
	 * @param vcaCertificateDTO
	 */
	public void saveVcaCertificate(VcaCertificateDTO vcaCertificateDTO) {
		dateConverter = new DateConverter();
		VcaCertificate vcaCertificate = new VcaCertificate();
		vcaCertificate.setIssueDate(dateConverter.createDateFromString(vcaCertificateDTO.getIssueDate(), 0, 0));
		vcaCertificate
				.setExpirationDate(dateConverter.createDateFromString(vcaCertificateDTO.getExpirationDate(), 0, 0));
		vcaCertificate.setDocumentNumber(vcaCertificateDTO.getDocumentNumber());
		vcaCertificate.setIssuedBy(vcaCertificateDTO.getIssuedBy());

		Employee employee = createEmployeeByEmail(vcaCertificateDTO.getEmail());
		vcaCertificate.setEmployee(employee);

		FileTool fileTool = new FileTool();
		String fileName = fileTool.saveFile(vcaCertificateDTO.getFile(), employee.getLastName());
		vcaCertificate.setFileName(fileName);

		vcaCertificateRepository.save(vcaCertificate);
	}

	/**
	 * Saves Medical Examination in system
	 * 
	 * @param medicalExaminationDTO
	 */

	public void saveMedicalExamination(MedicalExaminationDTO medicalExaminationDTO) {
		dateConverter = new DateConverter();

		MedicalExamination medicalExamination = new MedicalExamination();
		medicalExamination.setIssueDate(dateConverter.createDateFromString(medicalExaminationDTO.getIssueDate(), 0, 0));
		medicalExamination
				.setExpirationDate(dateConverter.createDateFromString(medicalExaminationDTO.getExpirationDate(), 0, 0));
		medicalExamination.setIssuedBy(medicalExaminationDTO.getIssuedBy());

		Employee employee = createEmployeeByEmail(medicalExaminationDTO.getEmail());
		medicalExamination.setEmployee(employee);

		medicalExamination.setRequirementsDescription(medicalExaminationDTO.getRequirementsDescription());
		medicalExamination.setRequirementsFullFilled(medicalExaminationDTO.getRequirementsFullFilled());

		FileTool fileTool = new FileTool();
		String fileName = fileTool.saveFile(medicalExaminationDTO.getFile(), employee.getLastName());
		medicalExamination.setFileName(fileName);

		medicalExaminationRepository.save(medicalExamination);

	}

	/**
	 * Checks if document is still valid
	 * 
	 * @param expiredDate
	 *            Document's expiration date
	 * @return VALID or EXPIRED value
	 */
	public DocumentIsValid checkDocumentExpiredDate(LocalDateTime expiredDate) {

		if (expiredDate.isAfter(LocalDateTime.now())) {
			return DocumentIsValid.VALID;
		} else {
			return DocumentIsValid.EXPIRED;
		}

	}

	/**
	 * Creates Employee by email
	 * 
	 * @param email
	 *            User's email
	 * @return employee
	 */

	public Employee createEmployeeByEmail(String email) {
		User user = userRepository.findByEmail(email);
		Employee employee = user.getEmployee();
		return employee;
	}

}
