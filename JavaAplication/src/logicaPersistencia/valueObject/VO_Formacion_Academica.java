package logicaPersistencia.valueObject;

public class VO_Formacion_Academica {
	
	private String nivel;
	private int completado;
	private String ci_venezolana;
	
	public VO_Formacion_Academica(String nivel, int completado, String ci_venezolana) {
		super();
		this.nivel = nivel;
		this.completado = completado;
		this.ci_venezolana=ci_venezolana;
	}
	
	public VO_Formacion_Academica(String ci_venezolana){
		this.ci_venezolana=ci_venezolana;
		this.nivel=null;
		this.completado=-1;
	}

	public String getNivel() {
		return nivel;
	}

	public int getCompletado() {
		return completado;
	}
	public String getCi_venezolana(){
		return ci_venezolana;
	}
	
	
	
}
