package logicaPersistencia.valueObject;

public class VO_Persona_Idioma {
	private String idioma;
	private String nivel;
	private String ci_venezolana;
	public VO_Persona_Idioma(String idioma, String nivel,String ci_venezolana){
		this.nivel = nivel;
		this.idioma = idioma;
		this.ci_venezolana = ci_venezolana;
		
	}
	public String getIdioma() {
		return idioma;
	}
	public String getNivel() {
		return nivel;
	}
	public String getCi_venezolana() {
		return ci_venezolana;
	}
	
}
