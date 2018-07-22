package logicaPersistencia.valueObject;

public class VO_Tiene_Profesion {
	
	private int id_titulo;
	private int homologacion;
	private String ci_venezolana;
	
	public VO_Tiene_Profesion(int id_titulo, int homologacion, String ci_venezolana) {
		super();
		this.id_titulo = id_titulo;
		this.homologacion = homologacion;
		this.ci_venezolana= ci_venezolana;
	}

	public int getId_titulo() {
		return id_titulo;
	}

	public int getHomologacion() {
		return homologacion;
	}
	
	public String getCi_venezolana(){
		return ci_venezolana;
	}
	
}
