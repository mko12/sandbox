package utils;

public enum LoginStatus {
	UKNOWN_USER("Unknown user"), 
	SUCCESS("Succesful login"), 
	WRONG_PASSWORD("Wrong password"), 
	UNKNOWN("Unknown login status");

	private final String name;

	private LoginStatus(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}