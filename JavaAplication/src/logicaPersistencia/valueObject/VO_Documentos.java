package logicaPersistencia.valueObject;

public class VO_Documentos {
	private String ci_venezolana;
	private String ci_uruguaya;
	private String pasaporte;
	private String fecha_carnet_salud;
	
	public VO_Documentos(String ci_uruguaya, String pasaporte, String fecha_carnet_salud, String ci_venezolana) {
		super();
		this.ci_uruguaya = ci_uruguaya;
		this.pasaporte = pasaporte;
		this.fecha_carnet_salud = fecha_carnet_salud;
		this.ci_venezolana=ci_venezolana;
	}
	
	public VO_Documentos (String ci_venezolana){
		this.ci_venezolana=ci_venezolana;
		this.ci_uruguaya = null;
		this.pasaporte = null;
		this.fecha_carnet_salud = null;
	}
	public String getCi_uruguaya() {
		return ci_uruguaya;
	}
	
	public String getPasaporte() {
		return pasaporte;
	}
	
	public String getFecha_carnet_salud() {
		return fecha_carnet_salud;
	}
	
	public String getCi_venezolana(){
		return ci_venezolana;
	}
}
