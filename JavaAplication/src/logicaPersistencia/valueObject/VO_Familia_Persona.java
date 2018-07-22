package logicaPersistencia.valueObject;

public class VO_Familia_Persona {
	
	private String ci_venezolana;
	private String vive_con;
	private String detalle;
	private int vino_con;
	private int cant_hijos;
	private int hijos_exterior;
	
	public VO_Familia_Persona(String ci_venezolana, String vive_con, String detalle, int vino_con, int cant_hijos,
			int hijos_exterior) {
		super();
		this.ci_venezolana = ci_venezolana;
		this.vive_con = vive_con;
		this.detalle = detalle;
		this.vino_con = vino_con;
		this.cant_hijos = cant_hijos;
		this.hijos_exterior = hijos_exterior;
	}
	
	public String getCi_venezolana() {
		return ci_venezolana;
	}
	public String getVive_con() {
		return vive_con;
	}
	public String getDetalle() {
		return detalle;
	}
	public int getVino_con() {
		return vino_con;
	}
	public int getCant_hijos() {
		return cant_hijos;
	}
	public int getHijos_exterior() {
		return hijos_exterior;
	}
	
	
}
