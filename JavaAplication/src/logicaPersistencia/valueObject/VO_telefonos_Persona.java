package logicaPersistencia.valueObject;

public class VO_telefonos_Persona {
	private String ci_venezolana;
	private String tel1;

	public VO_telefonos_Persona(String ci_venezolana, String tel1) {
		this.ci_venezolana = ci_venezolana;
		this.tel1 = tel1;
	
	}

	public String getCi_venezolana() {
		return ci_venezolana;
	}

	public String getTel1() {
		return tel1;
	}

	
	
	
	
}
