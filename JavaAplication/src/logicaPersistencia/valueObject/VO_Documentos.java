package logicaPersistencia.valueObject;

public class VO_Documentos {
	private String ci_venezolana;
	private String ci_uruguaya;
	private String pasaporte;
	private String fecha_carnet_salud;
	private int id_persona;
	
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
	public VO_Documentos(int id_persona,String ci_uruguaya, String pasaporte, String fecha_carnet_salud, String ci_venezolana) {
		super();
		//cambios aqui
		this.ci_uruguaya = ci_uruguaya;
		this.pasaporte = pasaporte;
		this.fecha_carnet_salud = fecha_carnet_salud;
		this.ci_venezolana=ci_venezolana;
		this.id_persona = id_persona;
	}
	
	public VO_Documentos (int id_persona,String ci_venezolana){
		this.ci_venezolana=ci_venezolana;
		//cambios aqui
		this.ci_uruguaya = null;
		this.pasaporte = null;
		this.fecha_carnet_salud = null;
		this.id_persona = id_persona;
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
	public int get_Id_persona(){
		return id_persona;
	}
}
