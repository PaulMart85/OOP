package Seminar5_java;

public enum WhsMv {
    RED_SIDE("redSide"),
    BLUE_SIDE("blueSide");

    private String message;

	private WhsMv(String message) {
		this.message = message;
	}

	public String getWhsMv() {
		return message;
	}
}
