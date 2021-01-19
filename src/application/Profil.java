package application;

public enum Profil {
	Psy,Patient;
	
	private Profil() {}

	public String value() {
		return name();
	}
	
	public static Profil fromvalue(String v) {
		return valueOf(v);
	}

}
