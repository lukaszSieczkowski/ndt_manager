package pl.ndt.manager.dto;

import org.springframework.web.multipart.MultipartFile;

import pl.ndt.manager.model.enums.CorerctlyEyeCondition;
import pl.ndt.manager.model.enums.DocumentIsValid;

public class JaegerTestDTO extends DocumentDTO {

	private CorerctlyEyeCondition corerctlyEyeCondition;

	public JaegerTestDTO() {
		super();
	}

	public JaegerTestDTO(String issueDate, String expirationDate, String issuedBy, MultipartFile file,
			String fileDirectory, String email, String ownersNameAndSurname, DocumentIsValid documentIsValid,
			CorerctlyEyeCondition corerctlyEyeCondition) {
		super(issueDate, expirationDate, issuedBy, file, fileDirectory, email, ownersNameAndSurname, documentIsValid);

		this.corerctlyEyeCondition = corerctlyEyeCondition;
	}

	public CorerctlyEyeCondition getCorerctlyEyeCondition() {
		return corerctlyEyeCondition;
	}

	public void setCorerctlyEyeCondition(CorerctlyEyeCondition corerctlyEyeCondition) {
		this.corerctlyEyeCondition = corerctlyEyeCondition;
	}

	@Override
	public String toString() {
		return "JaegerTestDTO [corerctlyEyeCondition=" + corerctlyEyeCondition + ", issueDate=" + issueDate
				+ ", expirationDate=" + expirationDate + ", issuedBy=" + issuedBy + ", file=" + file
				+ ", fileDirectory=" + fileDirectory + ", email=" + email + ", ownersNameAndSurname="
				+ ownersNameAndSurname + ", documentIsValid=" + documentIsValid + "]";
	}

	
}
