package pl.ndt.manager.model.enums;

public enum EmployeePossiton {
	NDT_INSPECTOR("NDT Manager"), NDT_MANAGER("NDT Inspector");

	private String value;

	private EmployeePossiton(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
