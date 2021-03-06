package pl.ndt.manager.exampleData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import pl.ndt.manager.model.Address;
import pl.ndt.manager.model.Chemical;
import pl.ndt.manager.model.Customer;

import pl.ndt.manager.model.Employee;
import pl.ndt.manager.model.Verification;
import pl.ndt.manager.model.JaegerTest;
import pl.ndt.manager.model.Location;
import pl.ndt.manager.model.MeasuringEquipment;
import pl.ndt.manager.model.MedicalExamination;
import pl.ndt.manager.model.NdtCertificate;
import pl.ndt.manager.model.PersonalDocument;
import pl.ndt.manager.model.Probe;
import pl.ndt.manager.model.Report;
import pl.ndt.manager.model.ResultsOfExamination;
import pl.ndt.manager.model.TechnicalDocument;
import pl.ndt.manager.model.User;
import pl.ndt.manager.model.VTReport;
import pl.ndt.manager.model.VcaCertificate;
import pl.ndt.manager.model.enums.ChemicalType;
import pl.ndt.manager.model.enums.CorerctlyEyeCondition;
import pl.ndt.manager.model.enums.EmployeePositon;
import pl.ndt.manager.model.enums.ExaminationResult;
import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.QualityLevel;
import pl.ndt.manager.model.enums.Sector;
import pl.ndt.manager.model.enums.TypeOfControl;
import pl.ndt.manager.model.enums.TypeOfTesting;
import pl.ndt.manager.model.enums.UserRole;
import pl.ndt.manager.repository.ChemicalsRepository;
import pl.ndt.manager.repository.CustomerRepository;

import pl.ndt.manager.repository.EmployeeRepository;

import pl.ndt.manager.repository.JaegerTestRepository;
import pl.ndt.manager.repository.LocationRepository;
import pl.ndt.manager.repository.MeasuringEquipmentRepository;
import pl.ndt.manager.repository.MedicalExaminationRepository;
import pl.ndt.manager.repository.NdtCertificateRepository;
import pl.ndt.manager.repository.ProbeRepository;
import pl.ndt.manager.repository.ResultOfExaminationRepository;
import pl.ndt.manager.repository.TechnicalDocumentRepository;
import pl.ndt.manager.repository.UserRepository;
import pl.ndt.manager.repository.VTReportRepository;
import pl.ndt.manager.repository.VcaCertificateRepository;
import pl.ndt.manager.repository.VerificationRepository;

@Service

public class ExampleDataBase {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private NdtCertificateRepository ndtCertificateRepository;
	@Autowired
	private JaegerTestRepository jaegerTestRepository;
	@Autowired
	private VcaCertificateRepository vcaCertificateRepository;
	@Autowired
	private MedicalExaminationRepository medicalExaminationRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private TechnicalDocumentRepository technicalDocumentRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private MeasuringEquipmentRepository measuringEquipmentRepository;
	@Autowired
	private ProbeRepository probeRepository;
	@Autowired
	private VTReportRepository vtReportRepository;
	@Autowired
	private ResultOfExaminationRepository resultOfExaminationRepository;
	@Autowired
	private VerificationRepository verificationRepository;
	@Autowired
	private ChemicalsRepository chemicalsRepository;
	

	public void prepareDataBase() {
		List<PersonalDocument> documentsList1 = new ArrayList<>();
		List<PersonalDocument> documentsList2 = new ArrayList<>();
		List<PersonalDocument> documentsList3 = new ArrayList<>();
		List<PersonalDocument> documentsList4 = new ArrayList<>();
		List<PersonalDocument> documentsList5 = new ArrayList<>();

		Address address1 = new Address();
		Location location1 = new Location();
		address1.setStreet("Przemys�owa");
		address1.setHouseNumber(12);
		address1.setLocalNumber(0);
		address1.setCity("Katowice");
		address1.setZipCode("41-000");

		location1.setInstitutionName("Business Unit No.1");
		address1.setLocaton(location1);
		location1.setAddress(address1);

		Address address2 = new Address();
		Location location2 = new Location();
		address2.setStreet("Industrialna");
		address2.setHouseNumber(3);
		address2.setLocalNumber(12);
		address2.setCity("Gliwice");
		address2.setZipCode("41-100");

		location2.setInstitutionName("Business Unit No.2");
		address2.setLocaton(location2);
		location2.setAddress(address2);

		locationRepository.save(location1);
		locationRepository.save(location2);

		Address address3 = new Address();
		Customer customer1 = new Customer();
		address3.setStreet("Budyniowa");
		address3.setHouseNumber(20);
		address3.setLocalNumber(0);
		address3.setCity("Katowice");
		address3.setZipCode("41-000");

		customer1.setCustomerName("Company No.1");
		customer1.setCustomerNumber(1L);
		address3.setCustomer(customer1);
		customer1.setAddress(address3);

		Address address4 = new Address();
		Customer customer2 = new Customer();
		address4.setStreet("Zakorkowana");
		address4.setHouseNumber(22);
		address4.setLocalNumber(8);
		address4.setCity("Gliwice");
		address4.setZipCode("43-200");

		customer2.setCustomerName("Company No.2");
		customer2.setCustomerNumber(2L);
		address4.setCustomer(customer2);
		customer2.setAddress(address4);

		Address address5 = new Address();
		Customer customer3 = new Customer();
		address5.setStreet("Le�na");
		address5.setHouseNumber(45);
		address5.setLocalNumber(0);
		address5.setCity("Myslowice");
		address5.setZipCode("41-400");

		customer3.setCustomerName("Company No.3");
		customer3.setCustomerNumber(3L);
		address5.setCustomer(customer3);
		customer3.setAddress(address5);

		Address address6 = new Address();
		Customer customer4 = new Customer();
		address6.setStreet("Kopaniana");
		address6.setHouseNumber(123);
		address6.setLocalNumber(0);
		address6.setCity("Zabrze");
		address6.setZipCode("45-200");

		customer4.setCustomerName("Company No.4");
		customer4.setCustomerNumber(4L);
		address6.setCustomer(customer4);
		customer4.setAddress(address6);

		Address address7 = new Address();
		Customer customer5 = new Customer();
		address7.setStreet("Brukowana");
		address7.setHouseNumber(67);
		address7.setLocalNumber(5);
		address7.setCity("Sosnowiec");
		address7.setZipCode("41-200");

		customer5.setCustomerName("Company No.5");
		customer5.setCustomerNumber(5L);
		address7.setCustomer(customer5);
		customer5.setAddress(address7);

		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);
		customerRepository.save(customer4);
		customerRepository.save(customer5);

		Employee employee1 = new Employee();
		User user1 = new User();
		employee1.setFirstName("Tadeusz");
		employee1.setLastName("Nowak");
		employee1.setEmployeePosition(EmployeePositon.NDT_MANAGER);
		employee1.setDocumentsList(documentsList1);
		employee1.setUser(user1);
		employee1.setLocation(location1);
		user1.setEmail("tadeusz.nowak@frm.pl");
		String decryptedPassword = DigestUtils.sha256Hex("qwerty");
		user1.setPassword(decryptedPassword);
		user1.setRole(UserRole.ADMIN);
		user1.setEmployee(employee1);
		employee1.setUser(user1);

		Employee employee2 = new Employee();
		User user2 = new User();
		employee2.setFirstName("Bonifacy");
		employee2.setLastName("Plomba");
		employee2.setEmployeePosition(EmployeePositon.NDT_INSPECTOR);
		employee2.setDocumentsList(documentsList2);
		employee2.setUser(user2);
		employee2.setLocation(location2);
		user2.setEmail("bonifacy.bomba@frm.pl");
		user2.setPassword(decryptedPassword);
		user2.setRole(UserRole.USER);
		user2.setEmployee(employee2);
		employee2.setUser(user2);

		Employee employee3 = new Employee();
		User user3 = new User();
		employee3.setFirstName("Teodor");
		employee3.setLastName("Wierci�ta");
		employee3.setEmployeePosition(EmployeePositon.NDT_INSPECTOR);
		employee3.setDocumentsList(documentsList3);
		employee3.setUser(user3);
		employee3.setLocation(location1);
		user3.setEmail("teodor.wiercipieta@frm.pl");
		user3.setPassword(decryptedPassword);
		user3.setRole(UserRole.USER);
		user3.setEmployee(employee3);
		employee3.setUser(user3);

		Employee employee4 = new Employee();
		User user4 = new User();
		employee4.setFirstName("Janusz");
		employee4.setLastName("Polak");
		employee4.setEmployeePosition(EmployeePositon.NDT_INSPECTOR);
		employee4.setDocumentsList(documentsList4);
		employee4.setUser(user4);
		employee4.setLocation(location2);
		user4.setEmail("janusz.polak@frm.pl");
		user4.setPassword(decryptedPassword);
		user4.setRole(UserRole.USER);
		user4.setEmployee(employee4);
		employee4.setUser(user4);

		Employee employee5 = new Employee();
		User user5 = new User();
		employee5.setFirstName("Pankracy");
		employee5.setLastName("Ma�lak");
		employee5.setEmployeePosition(EmployeePositon.NDT_INSPECTOR);
		employee5.setDocumentsList(documentsList5);
		employee5.setUser(user5);
		employee5.setLocation(location1);
		user5.setEmail("panracy.maslak@frm.pl");
		user5.setPassword(decryptedPassword);
		user5.setRole(UserRole.USER);
		user5.setEmployee(employee5);
		employee5.setUser(user5);

		NdtCertificate ndtCert1 = new NdtCertificate();
		ndtCert1.setIssueDate(LocalDateTime.of(2015, 10, 3, 0, 0));
		ndtCert1.setExpirationDate(LocalDateTime.of(2015, 10, 3, 0, 0).plusYears(5));
		ndtCert1.setIssuedBy("UDT-Cert");
		ndtCert1.setFileName("aa");
		ndtCert1.setEmployee(employee1);
		ndtCert1.setDocumentNumber("Doc-1");
		ndtCert1.setSector(Sector.METL_PRE_AND_IN_SERVICE);
		ndtCert1.setNdtMethod(NdtMethod.MT_2);

		NdtCertificate ndtCert2 = new NdtCertificate();
		ndtCert2.setIssueDate(LocalDateTime.of(2016, 3, 3, 0, 0));
		ndtCert2.setExpirationDate(LocalDateTime.of(2016, 3, 3, 0, 0).plusYears(5));
		ndtCert2.setIssuedBy("UDT-Cert");
		ndtCert2.setFileName("bb");
		ndtCert2.setEmployee(employee1);
		ndtCert2.setDocumentNumber("Doc-2");
		ndtCert2.setSector(Sector.METL_PRE_AND_IN_SERVICE);
		ndtCert2.setNdtMethod(NdtMethod.UT_2);

		NdtCertificate ndtCert3 = new NdtCertificate();
		ndtCert3.setIssueDate(LocalDateTime.of(2017, 4, 3, 0, 0));
		ndtCert3.setExpirationDate(LocalDateTime.of(2017, 4, 3, 0, 0).plusYears(5));
		ndtCert3.setIssuedBy("UDT-Cert");
		ndtCert3.setFileName("cc");
		ndtCert3.setEmployee(employee2);
		ndtCert3.setDocumentNumber("Doc-3");
		ndtCert3.setSector(Sector.METL_PRE_AND_IN_SERVICE);
		ndtCert3.setNdtMethod(NdtMethod.PT_2);

		NdtCertificate ndtCert4 = new NdtCertificate();
		ndtCert4.setIssueDate(LocalDateTime.of(2015, 3, 3, 0, 0));
		ndtCert4.setExpirationDate(LocalDateTime.of(2015, 3, 3, 0, 0).plusYears(5));
		ndtCert4.setIssuedBy("UDT-Cert");
		ndtCert4.setFileName("dd");
		ndtCert4.setEmployee(employee2);
		ndtCert4.setDocumentNumber("Doc-4");
		ndtCert4.setSector(Sector.METL_PRE_AND_IN_SERVICE);
		ndtCert4.setNdtMethod(NdtMethod.RT_2);

		NdtCertificate ndtCert5 = new NdtCertificate();
		ndtCert5.setIssueDate(LocalDateTime.of(2016, 10, 3, 0, 0));
		ndtCert5.setExpirationDate(LocalDateTime.of(2016, 10, 3, 0, 0).plusYears(5));
		ndtCert5.setIssuedBy("UDT-Cert");
		ndtCert5.setFileName("ee");
		ndtCert5.setEmployee(employee3);
		ndtCert5.setDocumentNumber("Doc-5");
		ndtCert5.setSector(Sector.AREOSPACE);
		ndtCert5.setNdtMethod(NdtMethod.RT_2);

		NdtCertificate ndtCert6 = new NdtCertificate();
		ndtCert6.setIssueDate(LocalDateTime.of(2017, 1, 3, 0, 0));
		ndtCert6.setExpirationDate(LocalDateTime.of(2017, 1, 3, 0, 0).plusYears(5));
		ndtCert6.setIssuedBy("UDT-Cert");
		ndtCert6.setFileName("ff");
		ndtCert6.setEmployee(employee3);
		ndtCert6.setDocumentNumber("Doc-6");
		ndtCert6.setSector(Sector.AREOSPACE);
		ndtCert6.setNdtMethod(NdtMethod.UT_2);

		NdtCertificate ndtCert7 = new NdtCertificate();
		ndtCert7.setIssueDate(LocalDateTime.of(2012, 1, 3, 0, 0));
		ndtCert7.setExpirationDate(LocalDateTime.of(2012, 1, 3, 0, 0).plusYears(5));
		ndtCert7.setIssuedBy("TUV");
		ndtCert7.setFileName("gg");
		ndtCert7.setEmployee(employee4);
		ndtCert7.setDocumentNumber("Doc-7");
		ndtCert7.setSector(Sector.RAILWAY);
		ndtCert7.setNdtMethod(NdtMethod.RT_2);

		NdtCertificate ndtCert8 = new NdtCertificate();
		ndtCert8.setIssueDate(LocalDateTime.of(2011, 10, 3, 0, 0));
		ndtCert8.setExpirationDate(LocalDateTime.of(2011, 10, 3, 0, 0).plusYears(5));
		ndtCert8.setIssuedBy("UDT-Cert");
		ndtCert8.setFileName("hh");
		ndtCert8.setEmployee(employee4);
		ndtCert8.setDocumentNumber("Doc-8");
		ndtCert8.setSector(Sector.RAILWAY);
		ndtCert8.setNdtMethod(NdtMethod.MT_2);

		NdtCertificate ndtCert9 = new NdtCertificate();
		ndtCert9.setIssueDate(LocalDateTime.of(2010, 10, 3, 0, 0));
		ndtCert9.setExpirationDate(LocalDateTime.of(2010, 10, 3, 0, 0).plusYears(5));
		ndtCert9.setIssuedBy("UDT-Cert");
		ndtCert9.setFileName("ii");
		ndtCert9.setEmployee(employee5);
		ndtCert9.setDocumentNumber("Doc-9");
		ndtCert9.setSector(Sector.METAL_MANUFACTURING);
		ndtCert9.setNdtMethod(NdtMethod.RT_2);

		NdtCertificate ndtCert10 = new NdtCertificate();
		ndtCert10.setIssueDate(LocalDateTime.of(2010, 10, 3, 0, 0));
		ndtCert10.setExpirationDate(LocalDateTime.of(2010, 10, 3, 0, 0).plusYears(5));
		ndtCert10.setIssuedBy("UDT-Cert");
		ndtCert10.setFileName("jj");
		ndtCert10.setEmployee(employee5);
		ndtCert10.setDocumentNumber("Doc-10");
		ndtCert10.setSector(Sector.METAL_MANUFACTURING);
		ndtCert10.setNdtMethod(NdtMethod.TOFD_2);

		JaegerTest jaegerTest1 = new JaegerTest();
		jaegerTest1.setIssueDate(LocalDateTime.of(2016, 3, 3, 0, 0));
		jaegerTest1.setExpirationDate(LocalDateTime.of(2017, 3, 3, 0, 0));
		jaegerTest1.setEmployee(employee1);
		jaegerTest1.setIssuedBy("Doctor");
		jaegerTest1.setFileName("aaa");
		jaegerTest1.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);

		JaegerTest jaegerTest2 = new JaegerTest();
		jaegerTest2.setIssueDate(LocalDateTime.of(2017, 3, 3, 0, 0));
		jaegerTest2.setExpirationDate(LocalDateTime.of(2018, 3, 3, 0, 0));
		jaegerTest2.setEmployee(employee2);
		jaegerTest2.setIssuedBy("Doctor");
		jaegerTest2.setFileName("bbb");
		jaegerTest2.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);

		JaegerTest jaegerTest3 = new JaegerTest();
		jaegerTest3.setIssueDate(LocalDateTime.of(2016, 4, 3, 0, 0));
		jaegerTest3.setExpirationDate(LocalDateTime.of(2017, 4, 3, 0, 0));
		jaegerTest3.setEmployee(employee3);
		jaegerTest3.setIssuedBy("Doctor");
		jaegerTest3.setFileName("ccc");
		jaegerTest3.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);

		JaegerTest jaegerTest4 = new JaegerTest();
		jaegerTest4.setIssueDate(LocalDateTime.of(2016, 8, 3, 0, 0));
		jaegerTest4.setExpirationDate(LocalDateTime.of(2017, 8, 3, 0, 0));
		jaegerTest4.setEmployee(employee4);
		jaegerTest4.setIssuedBy("Doctor");
		jaegerTest4.setFileName("ddd");
		jaegerTest4.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);

		JaegerTest jaegerTest5 = new JaegerTest();
		jaegerTest5.setIssueDate(LocalDateTime.of(2016, 10, 3, 0, 0));
		jaegerTest5.setExpirationDate(LocalDateTime.of(2017, 10, 3, 0, 0));
		jaegerTest5.setEmployee(employee5);
		jaegerTest5.setIssuedBy("Doctor");
		jaegerTest5.setFileName("eee");
		jaegerTest5.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);

		VcaCertificate vcaCertificate1 = new VcaCertificate();
		vcaCertificate1.setIssueDate(LocalDateTime.of(2010, 10, 3, 0, 0));
		vcaCertificate1.setExpirationDate(LocalDateTime.of(2010, 10, 3, 0, 0).plusYears(10));
		vcaCertificate1.setIssuedBy("Het");
		vcaCertificate1.setEmployee(employee1);
		vcaCertificate1.setDocumentNumber("Doc-1");
		vcaCertificate1.setFileName("aaaa");

		VcaCertificate vcaCertificate2 = new VcaCertificate();
		vcaCertificate2.setIssueDate(LocalDateTime.of(2005, 10, 3, 0, 0));
		vcaCertificate2.setExpirationDate(LocalDateTime.of(2005, 10, 3, 0, 0).plusYears(10));
		vcaCertificate2.setIssuedBy("Het");
		vcaCertificate2.setEmployee(employee2);
		vcaCertificate2.setDocumentNumber("Doc-2");
		vcaCertificate2.setFileName("bbbb");

		VcaCertificate vcaCertificate3 = new VcaCertificate();
		vcaCertificate3.setIssueDate(LocalDateTime.of(2007, 10, 3, 0, 0));
		vcaCertificate3.setExpirationDate(LocalDateTime.of(2007, 10, 3, 0, 0).plusYears(10));
		vcaCertificate3.setIssuedBy("Het");
		vcaCertificate3.setEmployee(employee3);
		vcaCertificate3.setDocumentNumber("Doc-3");
		vcaCertificate3.setFileName("cccc");

		VcaCertificate vcaCertificate4 = new VcaCertificate();
		vcaCertificate4.setIssueDate(LocalDateTime.of(2010, 10, 3, 0, 0));
		vcaCertificate4.setExpirationDate(LocalDateTime.of(2010, 10, 3, 0, 0).plusYears(10));
		vcaCertificate4.setIssuedBy("Het");
		vcaCertificate4.setEmployee(employee4);
		vcaCertificate4.setDocumentNumber("Doc-4");
		vcaCertificate4.setFileName("dddd");

		VcaCertificate vcaCertificate5 = new VcaCertificate();
		vcaCertificate5.setIssueDate(LocalDateTime.of(2008, 10, 3, 0, 0));
		vcaCertificate5.setExpirationDate(LocalDateTime.of(2008, 10, 3, 0, 0).plusYears(10));
		vcaCertificate5.setIssuedBy("Het");
		vcaCertificate5.setEmployee(employee5);
		vcaCertificate5.setDocumentNumber("Doc-5");
		vcaCertificate5.setFileName("eeee");

		MedicalExamination medicalExamination1 = new MedicalExamination();
		medicalExamination1.setIssueDate(LocalDateTime.of(2015, 10, 3, 0, 0));
		medicalExamination1.setExpirationDate(LocalDateTime.of(2015, 10, 3, 0, 0).plusYears(2));
		medicalExamination1.setIssuedBy("Med");
		medicalExamination1.setEmployee(employee1);
		medicalExamination1.setRequirementsDescription("Working at height");
		medicalExamination1.setRequirementsFullFilled("Working at height - positive");
		medicalExamination1.setFileName("aaaaa");

		MedicalExamination medicalExamination2 = new MedicalExamination();
		medicalExamination2.setIssueDate(LocalDateTime.of(2014, 3, 3, 0, 0));
		medicalExamination2.setExpirationDate(LocalDateTime.of(2014, 3, 3, 0, 0).plusYears(3));
		medicalExamination2.setIssuedBy("Med");
		medicalExamination2.setEmployee(employee2);
		medicalExamination2.setRequirementsDescription("Working at height");
		medicalExamination2.setRequirementsFullFilled("Working at height - positive");
		medicalExamination2.setFileName("bbbbb");

		MedicalExamination medicalExamination3 = new MedicalExamination();
		medicalExamination3.setIssueDate(LocalDateTime.of(2015, 3, 3, 0, 0));
		medicalExamination3.setExpirationDate(LocalDateTime.of(2015, 3, 3, 0, 0).plusYears(3));
		medicalExamination3.setIssuedBy("Med");
		medicalExamination3.setEmployee(employee3);
		medicalExamination3.setRequirementsDescription("Working at height");
		medicalExamination3.setRequirementsFullFilled("Working at height - positive");
		medicalExamination3.setFileName("ccccc");

		MedicalExamination medicalExamination4 = new MedicalExamination();
		medicalExamination4.setIssueDate(LocalDateTime.of(2017, 3, 3, 0, 0));
		medicalExamination4.setExpirationDate(LocalDateTime.of(2017, 3, 3, 0, 0).plusYears(1));
		medicalExamination4.setIssuedBy("Med");
		medicalExamination4.setEmployee(employee4);
		medicalExamination4.setRequirementsDescription("Working at height");
		medicalExamination4.setRequirementsFullFilled("Working at height - positive");
		medicalExamination4.setFileName("ddddd");

		MedicalExamination medicalExamination5 = new MedicalExamination();
		medicalExamination5.setIssueDate(LocalDateTime.of(2016, 3, 3, 0, 0));
		medicalExamination5.setExpirationDate(LocalDateTime.of(2016, 3, 3, 0, 0).plusYears(2));
		medicalExamination5.setIssuedBy("Med");
		medicalExamination5.setEmployee(employee4);
		medicalExamination5.setRequirementsDescription("Working at height");
		medicalExamination5.setRequirementsFullFilled("Working at height - positive");
		medicalExamination5.setFileName("eeeee");

		TechnicalDocument technicalDocument1 = new TechnicalDocument();

		technicalDocument1.setNumber("EN-10160:1999");
		technicalDocument1.setTitle(
				"Ultrasonic testing of steel flat product of thickness equal or greater than 6 mm (reflection method)");
		technicalDocument1.setIssuedBy("PKN");
		technicalDocument1.setIssueDate(LocalDateTime.of(1999, 7, 1, 0, 0));
		technicalDocument1.setTypeOfTesting(TypeOfTesting.UT);

		TechnicalDocument technicalDocument2 = new TechnicalDocument();

		technicalDocument2.setNumber("PN-EN ISO 11666:2011");
		technicalDocument2.setTitle("Non-destructive testing of welds - Ultrasonic testing - Acceptance levels");
		technicalDocument2.setIssuedBy("PKN");
		technicalDocument2.setIssueDate(LocalDateTime.of(2011, 3, 1, 0, 0));
		technicalDocument2.setTypeOfTesting(TypeOfTesting.UT);

		TechnicalDocument technicalDocument3 = new TechnicalDocument();

		technicalDocument3.setNumber("PN-EN-17640:2011");
		technicalDocument3.setTitle(
				"Non-destructive testing of welds - Ultrasonic testing - Acceptance levels - Techniques, testing levels and assessment");
		technicalDocument3.setIssuedBy("PKN");
		technicalDocument3.setIssueDate(LocalDateTime.of(2011, 3, 1, 0, 0));
		technicalDocument3.setTypeOfTesting(TypeOfTesting.UT);

		TechnicalDocument technicalDocument4 = new TechnicalDocument();

		technicalDocument4.setNumber("PN-EN ISO 23278:2010");
		technicalDocument4
				.setTitle("Non-destructive testing of welds - Magnetic particle testing of welds - Acceptance levels");
		technicalDocument4.setIssuedBy("PKN");
		technicalDocument4.setIssueDate(LocalDateTime.of(2010, 2, 1, 0, 0));
		technicalDocument4.setTypeOfTesting(TypeOfTesting.MT);

		TechnicalDocument technicalDocument5 = new TechnicalDocument();

		technicalDocument5.setNumber("PN-EN ISO 17636-1:2013");
		technicalDocument5.setTitle(
				"Non-destructive testing of welds - Radiographic testing - Part 1 - X-and gamma-ray techniques with film");
		technicalDocument5.setIssuedBy("PKN");
		technicalDocument5.setIssueDate(LocalDateTime.of(2013, 1, 1, 0, 0));
		technicalDocument5.setTypeOfTesting(TypeOfTesting.RT);

		TechnicalDocument technicalDocument6 = new TechnicalDocument();

		technicalDocument6.setNumber("ISO 5817:2003");
		technicalDocument6.setTitle(
				"Welding � Fusion-welded joints in steel, nickel, titanium and their alloys (beam welding excluded) � Quality levels for imperfections");
		technicalDocument6.setIssuedBy("PKN");
		technicalDocument6.setIssueDate(LocalDateTime.of(2014, 1, 1, 0, 0));
		technicalDocument6.setTypeOfTesting(TypeOfTesting.VT);

		TechnicalDocument technicalDocument7 = new TechnicalDocument();

		technicalDocument7.setNumber("ISO 17637:2016");
		technicalDocument7.setTitle("Non-destructive testing of welds � Visual testing of fusion-welded joints");
		technicalDocument7.setIssuedBy("PKN");
		technicalDocument7.setIssueDate(LocalDateTime.of(2016, 1, 1, 0, 0));
		technicalDocument7.setTypeOfTesting(TypeOfTesting.VT);

		MeasuringEquipment measuringEquipment1 = new MeasuringEquipment();
		measuringEquipment1.setId(1L);
		measuringEquipment1.setLocation(location1);
		measuringEquipment1.setModel("Epoch 600");
		measuringEquipment1.setName("Flaw Detector");
		measuringEquipment1.setProducer("Olympus");
		measuringEquipment1.setProductionYear(2010);
		measuringEquipment1.setSerialNumber("IOE-201");
		measuringEquipment1.setStartOfUse(LocalDateTime.of(2010, 1, 1, 0, 0));
		measuringEquipment1.setFerquencyOfVerification(1);
		measuringEquipment1.setDeviceCode("shds-67");
		measuringEquipment1.setTypeOfTesting(TypeOfTesting.UT);

		Verification equipmentVerification1 = new Verification();
		equipmentVerification1.setCertificateNumber("Cert-1");
		LocalDateTime dateOfVer1 = LocalDateTime.of(2010, 1, 1, 0, 0);
		LocalDateTime dateOfValid1 = dateOfVer1.plusYears(measuringEquipment1.getFerquencyOfVerification());
		equipmentVerification1.setDateOfVerification(dateOfVer1);
		equipmentVerification1.setFinalDateOfVerification(dateOfValid1);
		equipmentVerification1.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification1.setMeasuringEquipment(measuringEquipment1);
		equipmentVerification1.setDoneBy("Company");

		Verification equipmentVerification2 = new Verification();
		equipmentVerification2.setCertificateNumber("Cert-2");
		LocalDateTime dateOfVer2 = dateOfValid1;
		LocalDateTime dateOfValid2 = dateOfVer2.plusYears(measuringEquipment1.getFerquencyOfVerification());
		equipmentVerification2.setDateOfVerification(dateOfValid2);
		equipmentVerification2.setFinalDateOfVerification(dateOfValid2);
		equipmentVerification2.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification2.setMeasuringEquipment(measuringEquipment1);
		equipmentVerification2.setDoneBy("Company");

		Verification equipmentVerification3 = new Verification();
		equipmentVerification3.setCertificateNumber("Cert-2");
		LocalDateTime dateOfVer3 = dateOfValid2;
		LocalDateTime dateOfValid3 = dateOfVer3.plusYears(measuringEquipment1.getFerquencyOfVerification());
		equipmentVerification3.setDateOfVerification(dateOfValid3);
		equipmentVerification3.setFinalDateOfVerification(dateOfValid3);
		equipmentVerification3.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification3.setMeasuringEquipment(measuringEquipment1);
		equipmentVerification3.setDoneBy("Company");

		List<Verification> verificationList1 = new ArrayList<>();
		verificationList1.add(equipmentVerification1);
		verificationList1.add(equipmentVerification2);
		verificationList1.add(equipmentVerification3);
		measuringEquipment1.setEquipmentVerificationList(verificationList1);

		MeasuringEquipment measuringEquipment2 = new MeasuringEquipment();
		measuringEquipment2.setId(1L);
		measuringEquipment2.setLocation(location1);
		measuringEquipment2.setModel("Flux2");
		measuringEquipment2.setName("Yoke");
		measuringEquipment2.setProducer("Carrl_Dutsch");
		measuringEquipment2.setProductionYear(2012);
		measuringEquipment2.setSerialNumber("201/321/SE");
		measuringEquipment2.setStartOfUse(LocalDateTime.of(2013, 1, 1, 0, 0));
		measuringEquipment2.setFerquencyOfVerification(1);
		measuringEquipment2.setDeviceCode("shds-65");
		measuringEquipment2.setTypeOfTesting(TypeOfTesting.MT);

		Verification equipmentVerification4 = new Verification();
		equipmentVerification4.setCertificateNumber("Cert-1");
		dateOfVer1 = LocalDateTime.of(2013, 1, 1, 0, 0);
		dateOfValid1 = dateOfVer1.plusYears(measuringEquipment2.getFerquencyOfVerification());
		equipmentVerification4.setDateOfVerification(dateOfVer1);
		equipmentVerification4.setFinalDateOfVerification(dateOfValid1);
		equipmentVerification4.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification4.setMeasuringEquipment(measuringEquipment2);
		equipmentVerification4.setDoneBy("Company");

		Verification equipmentVerification5 = new Verification();
		equipmentVerification5.setCertificateNumber("Cert-2");
		dateOfVer2 = dateOfValid1;
		dateOfValid2 = dateOfVer2.plusYears(measuringEquipment1.getFerquencyOfVerification());
		equipmentVerification5.setDateOfVerification(dateOfValid2);
		equipmentVerification5.setFinalDateOfVerification(dateOfValid2);
		equipmentVerification5.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification5.setMeasuringEquipment(measuringEquipment2);
		equipmentVerification5.setDoneBy("Company");

		Verification equipmentVerification6 = new Verification();
		equipmentVerification6.setCertificateNumber("Cert-3");
		dateOfVer3 = dateOfValid2;
		dateOfValid3 = dateOfVer3.plusYears(measuringEquipment1.getFerquencyOfVerification());
		equipmentVerification6.setDateOfVerification(dateOfValid3);
		equipmentVerification6.setFinalDateOfVerification(dateOfValid3);
		equipmentVerification6.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification6.setMeasuringEquipment(measuringEquipment2);
		equipmentVerification6.setDoneBy("Company");

		MeasuringEquipment measuringEquipment3 = new MeasuringEquipment();
		measuringEquipment3.setId(3L);
		measuringEquipment3.setLocation(location2);
		measuringEquipment3.setModel("USM-25");
		measuringEquipment3.setName("Flaw Detector");
		measuringEquipment3.setProducer("Krautkramer");
		measuringEquipment3.setProductionYear(2013);
		measuringEquipment3.setSerialNumber("A-345-54");
		measuringEquipment3.setStartOfUse(LocalDateTime.of(2014, 1, 1, 0, 0));
		measuringEquipment3.setFerquencyOfVerification(1);
		measuringEquipment3.setDeviceCode("shds-65");
		measuringEquipment3.setTypeOfTesting(TypeOfTesting.UT);

		Verification equipmentVerification7 = new Verification();
		equipmentVerification7.setCertificateNumber("Cert-1");
		dateOfVer1 = LocalDateTime.of(2014, 1, 1, 0, 0);
		dateOfValid1 = dateOfVer1.plusYears(measuringEquipment2.getFerquencyOfVerification());
		equipmentVerification7.setDateOfVerification(dateOfVer1);
		equipmentVerification7.setFinalDateOfVerification(dateOfValid1);
		equipmentVerification7.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification7.setMeasuringEquipment(measuringEquipment3);
		equipmentVerification7.setDoneBy("Company");

		Verification equipmentVerification8 = new Verification();
		equipmentVerification8.setCertificateNumber("Cert-2");
		dateOfVer2 = dateOfValid1;
		dateOfValid2 = dateOfVer2.plusYears(measuringEquipment1.getFerquencyOfVerification());
		equipmentVerification8.setDateOfVerification(dateOfValid2);
		equipmentVerification8.setFinalDateOfVerification(dateOfValid2);
		equipmentVerification8.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification8.setMeasuringEquipment(measuringEquipment3);
		equipmentVerification8.setDoneBy("Company");

		Verification equipmentVerification9 = new Verification();
		equipmentVerification9.setCertificateNumber("Cert-3");
		dateOfVer3 = dateOfValid2;
		dateOfValid3 = dateOfVer3.plusYears(measuringEquipment1.getFerquencyOfVerification());
		equipmentVerification9.setDateOfVerification(dateOfValid3);
		equipmentVerification9.setFinalDateOfVerification(dateOfValid3);
		equipmentVerification9.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification9.setMeasuringEquipment(measuringEquipment3);
		equipmentVerification9.setDoneBy("Company");

		MeasuringEquipment measuringEquipment4 = new MeasuringEquipment();

		measuringEquipment4.setLocation(location1);
		measuringEquipment4.setModel("XYZ 399");
		measuringEquipment4.setName("Ruller");
		measuringEquipment4.setProducer("Micosic");
		measuringEquipment4.setProductionYear(2014);
		measuringEquipment4.setSerialNumber("BDI-300");
		measuringEquipment4.setStartOfUse(LocalDateTime.of(2014, 8, 3, 0, 0));
		measuringEquipment4.setFerquencyOfVerification(5);
		measuringEquipment4.setDeviceCode("code-54");
		measuringEquipment4.setTypeOfTesting(TypeOfTesting.VT);

		Verification equipmentVerification10 = new Verification();
		equipmentVerification10.setCertificateNumber("Cert-1");
		dateOfVer3 = dateOfValid2;
		dateOfValid3 = dateOfVer3.plusYears(measuringEquipment4.getFerquencyOfVerification());
		equipmentVerification10.setDateOfVerification(dateOfValid3);
		equipmentVerification10.setFinalDateOfVerification(dateOfValid3);
		equipmentVerification10.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification10.setMeasuringEquipment(measuringEquipment4);
		equipmentVerification10.setDoneBy("Company");

		MeasuringEquipment measuringEquipment5 = new MeasuringEquipment();

		measuringEquipment5.setLocation(location1);
		measuringEquipment5.setModel("300XC");
		measuringEquipment5.setName("Gauge");
		measuringEquipment5.setProducer("Tech-lab");
		measuringEquipment5.setProductionYear(2013);
		measuringEquipment5.setSerialNumber("BDI-301");
		measuringEquipment5.setStartOfUse(LocalDateTime.of(2014, 5, 1, 0, 0));
		measuringEquipment5.setFerquencyOfVerification(5);
		measuringEquipment5.setDeviceCode("code-55");
		measuringEquipment5.setTypeOfTesting(TypeOfTesting.VT);

		Verification equipmentVerification11 = new Verification();
		equipmentVerification11.setCertificateNumber("Cert-2");
		dateOfVer3 = dateOfValid2;
		dateOfValid3 = dateOfVer3.plusYears(measuringEquipment5.getFerquencyOfVerification());
		equipmentVerification11.setDateOfVerification(dateOfValid3);
		equipmentVerification11.setFinalDateOfVerification(dateOfValid3);
		equipmentVerification11.setTypeOfControl(TypeOfControl.CHECK);
		equipmentVerification11.setMeasuringEquipment(measuringEquipment5);
		equipmentVerification11.setDoneBy("Company");

		List<Verification> verificationList2 = new ArrayList<>();
		verificationList2.add(equipmentVerification4);
		verificationList2.add(equipmentVerification5);
		verificationList2.add(equipmentVerification6);
		measuringEquipment2.setEquipmentVerificationList(verificationList2);

		List<Verification> verificationList3 = new ArrayList<>();
		verificationList3.add(equipmentVerification7);
		verificationList3.add(equipmentVerification8);
		verificationList3.add(equipmentVerification9);
		measuringEquipment3.setEquipmentVerificationList(verificationList3);

		List<Verification> verificationList4 = new ArrayList<>();
		verificationList4.add(equipmentVerification10);
		measuringEquipment4.setEquipmentVerificationList(verificationList4);

		List<Verification> verificationList5 = new ArrayList<>();
		verificationList5.add(equipmentVerification11);
		measuringEquipment5.setEquipmentVerificationList(verificationList5);

		Probe probe1 = new Probe();
		probe1.setName("Probe");
		probe1.setAngle(45);
		probe1.setFrequency(4.0);
		probe1.setLocation(location1);
		probe1.setModel("Model-45-4");
		probe1.setProducer("Olympus");
		probe1.setProductionYear(2011);
		probe1.setSerialNumber("234-43-21");
		probe1.setStartOfUse(LocalDateTime.of(2012, 1, 1, 0, 0));
		probe1.setTypeOfTesting(TypeOfTesting.UT);

		Probe probe2 = new Probe();
		probe2.setName("Probe");
		probe2.setAngle(60);
		probe2.setFrequency(2.0);
		probe2.setLocation(location1);
		probe2.setModel("Model-60-2");
		probe2.setProducer("Olympus");
		probe2.setProductionYear(2013);
		probe2.setSerialNumber("234-43-01");
		probe2.setStartOfUse(LocalDateTime.of(2014, 1, 1, 0, 0));
		probe2.setTypeOfTesting(TypeOfTesting.UT);

		Probe probe3 = new Probe();
		probe3.setName("Probe");
		probe3.setAngle(70);
		probe3.setFrequency(4.0);
		probe3.setLocation(location2);
		probe3.setModel("Model-70-4");
		probe3.setProducer("Krautkramer");
		probe3.setProductionYear(2011);
		probe3.setSerialNumber("124-46-21");
		probe3.setStartOfUse(LocalDateTime.of(2012, 1, 1, 0, 0));
		probe3.setTypeOfTesting(TypeOfTesting.UT);

		Probe probe4 = new Probe();
		probe4.setName("Probe");
		probe4.setAngle(0);
		probe4.setFrequency(4.0);
		probe4.setLocation(location2);
		probe4.setModel("Model-0-4");
		probe4.setProducer("Olympus");
		probe4.setProductionYear(2011);
		probe4.setSerialNumber("256-12-23");
		probe4.setStartOfUse(LocalDateTime.of(2012, 1, 1, 0, 0));
		probe4.setTypeOfTesting(TypeOfTesting.UT);

		Probe probe5 = new Probe();
		probe5.setName("Probe");
		probe5.setAngle(0);
		probe5.setFrequency(2.0);
		probe5.setLocation(location1);
		probe5.setModel("Model-0-2");
		probe5.setProducer("Olympus");
		probe5.setProductionYear(2014);
		probe5.setSerialNumber("564-42-11");
		probe5.setStartOfUse(LocalDateTime.of(2015, 1, 1, 0, 0));
		probe5.setTypeOfTesting(TypeOfTesting.UT);

		VTReport vtReport1 = new VTReport();

		vtReport1.setIssueDate(LocalDateTime.now());
		vtReport1.setIssuedBy("Company");
		vtReport1.setFileName("file_name");
		vtReport1.setCustomer(customer1);
		vtReport1.setReportNumber("34/NDT/17/1");
		vtReport1.setPlace("Construction Site");
		vtReport1.setOrderNumber("Order no.1");
		vtReport1.setExaminatedObject("Weldet Construction");
		vtReport1.setExaminationDate(LocalDateTime.now().minusDays(1));
		vtReport1.setAprover(employee1);
		vtReport1.setPerformer(employee2);
		vtReport1.setLighting(1200);
		vtReport1.setMeasuringEquipment(measuringEquipment5);
		vtReport1.setTechnicalDocument(technicalDocument7);
		vtReport1.setQualityLevel(QualityLevel.B);
		vtReport1.setTypeOfTesting(TypeOfTesting.VT);

		ResultsOfExamination resultsOfExamination1 = new ResultsOfExamination();
		resultsOfExamination1.setElementNumber("S1");
		resultsOfExamination1.setDistanceFromReferencePoint("-");
		resultsOfExamination1.setIndicationLength("-");
		resultsOfExamination1.setImperfectionSymbol("-");
		resultsOfExamination1.setResult(ExaminationResult.OK);
		resultsOfExamination1.setRemarks("-");
		resultsOfExamination1.setReport(vtReport1);

		ResultsOfExamination resultsOfExamination2 = new ResultsOfExamination();
		resultsOfExamination2.setElementNumber("S1");
		resultsOfExamination2.setDistanceFromReferencePoint("-");
		resultsOfExamination2.setIndicationLength("-");
		resultsOfExamination2.setImperfectionSymbol("-");
		resultsOfExamination2.setResult(ExaminationResult.OK);
		resultsOfExamination2.setRemarks("-");
		resultsOfExamination2.setReport(vtReport1);

		ResultsOfExamination resultsOfExamination3 = new ResultsOfExamination();
		resultsOfExamination3.setElementNumber("S3");
		resultsOfExamination3.setDistanceFromReferencePoint("20");
		resultsOfExamination3.setIndicationLength("1-");
		resultsOfExamination3.setImperfectionSymbol("2011");
		resultsOfExamination3.setResult(ExaminationResult.NOK);
		resultsOfExamination3.setRemarks("-");
		resultsOfExamination3.setReport(vtReport1);

		List<ResultsOfExamination> resultsOfExaminationtsList = new ArrayList<>();
		resultsOfExaminationtsList.add(resultsOfExamination1);
		resultsOfExaminationtsList.add(resultsOfExamination2);
		resultsOfExaminationtsList.add(resultsOfExamination3);

		VTReport vtReport2 = new VTReport();

		vtReport2.setIssueDate(LocalDateTime.now().minusDays(6));
		vtReport2.setIssuedBy("Company");
		vtReport2.setFileName("file_name");
		vtReport2.setCustomer(customer2);
		vtReport2.setReportNumber("34/NDT/17/2");
		vtReport2.setPlace("Workshop");
		vtReport2.setOrderNumber("Order no.2");
		vtReport2.setExaminatedObject("Pipeline");
		vtReport2.setExaminationDate(LocalDateTime.now().minusDays(8));
		vtReport2.setAprover(employee2);
		vtReport2.setPerformer(employee3);
		vtReport2.setLighting(1000);
		vtReport2.setMeasuringEquipment(measuringEquipment4);
		vtReport2.setTechnicalDocument(technicalDocument6);

		vtReport2.setQualityLevel(QualityLevel.B);
		vtReport2.setTypeOfTesting(TypeOfTesting.VT);

		ResultsOfExamination resultsOfExamination4 = new ResultsOfExamination();
		resultsOfExamination4.setElementNumber("P1");
		resultsOfExamination4.setDistanceFromReferencePoint("-");
		resultsOfExamination4.setIndicationLength("-");
		resultsOfExamination4.setImperfectionSymbol("-");
		resultsOfExamination4.setResult(ExaminationResult.OK);
		resultsOfExamination4.setRemarks("-");
		resultsOfExamination4.setReport(vtReport2);

		ResultsOfExamination resultsOfExamination5 = new ResultsOfExamination();
		resultsOfExamination5.setElementNumber("P2");
		resultsOfExamination5.setDistanceFromReferencePoint("-");
		resultsOfExamination5.setIndicationLength("-");
		resultsOfExamination5.setImperfectionSymbol("-");
		resultsOfExamination5.setResult(ExaminationResult.OK);
		resultsOfExamination5.setRemarks("-");
		resultsOfExamination5.setReport(vtReport2);

		ResultsOfExamination resultsOfExamination6 = new ResultsOfExamination();
		resultsOfExamination6.setElementNumber("P3");
		resultsOfExamination6.setDistanceFromReferencePoint("20");
		resultsOfExamination6.setIndicationLength("10");
		resultsOfExamination6.setImperfectionSymbol("2011");
		resultsOfExamination6.setResult(ExaminationResult.NOK);
		resultsOfExamination6.setRemarks("-");
		resultsOfExamination6.setReport(vtReport2);

		List<ResultsOfExamination> resultsOfExaminationtsList2 = new ArrayList<>();
		resultsOfExaminationtsList2.add(resultsOfExamination4);
		resultsOfExaminationtsList2.add(resultsOfExamination5);
		resultsOfExaminationtsList2.add(resultsOfExamination6);
		
		Chemical chemical1 = new Chemical();
		chemical1.setName("MR-75");
		chemical1.setProducer("Producer1");
		chemical1.setBatch("2017/23/12");
		chemical1.setChemicalType(ChemicalType.BLACK_POWDER);
		chemical1.setTypeOfTesting(TypeOfTesting.MT);
		
		Chemical chemical2 = new Chemical();
		chemical2.setName("MR-76");
		chemical2.setProducer("Producer1");
		chemical2.setBatch("2016/23/12");
		chemical2.setChemicalType(ChemicalType.CLEANER);
		chemical2.setTypeOfTesting(TypeOfTesting.MT);
		
		Chemical chemical3 = new Chemical();
		chemical3.setName("MR-77");
		chemical3.setProducer("Producer1");
		chemical3.setBatch("2017/33/12");
		chemical3.setChemicalType(ChemicalType.WHITE_CONTRAST);
		chemical3.setTypeOfTesting(TypeOfTesting.MT);

		Chemical chemical4 = new Chemical();
		chemical4.setName("MR-78");
		chemical4.setProducer("Producer1");
		chemical4.setBatch("2017/23/01");
		chemical4.setChemicalType(ChemicalType.FLUORSCENT_POWDER);
		chemical4.setTypeOfTesting(TypeOfTesting.MT);

		Chemical chemical5 = new Chemical();
		chemical5.setName("MR-45");
		chemical5.setProducer("Producer1");
		chemical5.setBatch("2013/13/12");
		chemical5.setChemicalType(ChemicalType.CLEANER);
		chemical5.setTypeOfTesting(TypeOfTesting.PT);
		
		Chemical chemical6 = new Chemical();
		chemical6.setName("MR-46");
		chemical6.setProducer("Producer1");
		chemical6.setBatch("2017/53/22");
		chemical6.setChemicalType(ChemicalType.COLOR_FLUOROSCENT_PENETRANT);
		chemical6.setTypeOfTesting(TypeOfTesting.PT);

		Chemical chemical7 = new Chemical();
		chemical7.setName("MR-47");
		chemical7.setProducer("Producer1");
		chemical7.setBatch("2017/23/12");
		chemical7.setChemicalType(ChemicalType.COLOR_PENETRANT);
		chemical7.setTypeOfTesting(TypeOfTesting.PT);
		
		Chemical chemical8 = new Chemical();
		chemical8.setName("MR-49");
		chemical8.setProducer("Producer1");
		chemical8.setBatch("2016/23/12");
		chemical8.setChemicalType(ChemicalType.FLUROSCENT_PENETRANT);
		chemical8.setTypeOfTesting(TypeOfTesting.PT);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);

		ndtCertificateRepository.save(ndtCert1);
		ndtCertificateRepository.save(ndtCert2);
		ndtCertificateRepository.save(ndtCert3);
		ndtCertificateRepository.save(ndtCert4);
		ndtCertificateRepository.save(ndtCert5);
		ndtCertificateRepository.save(ndtCert6);
		ndtCertificateRepository.save(ndtCert7);
		ndtCertificateRepository.save(ndtCert8);
		ndtCertificateRepository.save(ndtCert9);
		ndtCertificateRepository.save(ndtCert10);

		jaegerTestRepository.save(jaegerTest1);
		jaegerTestRepository.save(jaegerTest2);
		jaegerTestRepository.save(jaegerTest3);
		jaegerTestRepository.save(jaegerTest4);
		jaegerTestRepository.save(jaegerTest5);

		vcaCertificateRepository.save(vcaCertificate1);
		vcaCertificateRepository.save(vcaCertificate2);
		vcaCertificateRepository.save(vcaCertificate3);
		vcaCertificateRepository.save(vcaCertificate4);
		vcaCertificateRepository.save(vcaCertificate5);

		medicalExaminationRepository.save(medicalExamination1);
		medicalExaminationRepository.save(medicalExamination2);
		medicalExaminationRepository.save(medicalExamination3);
		medicalExaminationRepository.save(medicalExamination4);
		medicalExaminationRepository.save(medicalExamination5);

		technicalDocumentRepository.save(technicalDocument1);
		technicalDocumentRepository.save(technicalDocument2);
		technicalDocumentRepository.save(technicalDocument3);
		technicalDocumentRepository.save(technicalDocument4);
		technicalDocumentRepository.save(technicalDocument5);
		
		measuringEquipmentRepository.save(measuringEquipment1);
		measuringEquipmentRepository.save(measuringEquipment2);
		measuringEquipmentRepository.save(measuringEquipment3);
		measuringEquipmentRepository.save(measuringEquipment4);
		measuringEquipmentRepository.save(measuringEquipment5);


		vtReportRepository.save(vtReport1);
		vtReportRepository.save(vtReport2);

		
		resultOfExaminationRepository.save(resultsOfExamination1);
		resultOfExaminationRepository.save(resultsOfExamination2);
		resultOfExaminationRepository.save(resultsOfExamination3);

		resultOfExaminationRepository.save(resultsOfExamination4);
		resultOfExaminationRepository.save(resultsOfExamination5);
		resultOfExaminationRepository.save(resultsOfExamination6);

		probeRepository.save(probe1);
		probeRepository.save(probe2);
		probeRepository.save(probe3);
		probeRepository.save(probe4);
		probeRepository.save(probe5);
		
		chemicalsRepository.save(chemical1);
		chemicalsRepository.save(chemical2);
		chemicalsRepository.save(chemical3);
		chemicalsRepository.save(chemical4);
		chemicalsRepository.save(chemical5);
		chemicalsRepository.save(chemical6);
		chemicalsRepository.save(chemical7);
		chemicalsRepository.save(chemical8);



	}
}
