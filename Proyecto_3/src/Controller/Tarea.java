package Controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Tarea implements Serializable{
	
	private String nombre;	
	private String descripcion;	
	private String tipo;
	private String tiempoEstimado;
	private String fechaEstimada;
	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	public void setFechaEstimada(String fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}
	public void setTerminada(Boolean terminada) {
		this.terminada = terminada;
	}

	private ArrayList<Participante> responsables;
	private ArrayList<Actividad> actividades;
	private Boolean terminada;
	
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public String getTiempoEstimado() {
		return tiempoEstimado;
	}
	public ArrayList<Participante> getResponsables() {
		return responsables;
	}
	
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}
	
	public Boolean getTerminada() {
		return terminada;
	}
	
	public int getTiempoReal() {
		int retorno = 0;
		
		for(Actividad actividad: actividades)
		{
			retorno += actividad.getTiempoUsado();
		}
		
		return retorno;
	}
	
	public Tarea(String nombre, String descripcion, String tipo, Actividad actividad)
	{
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.responsables = new ArrayList<Participante>();
		this.terminada = false;
		this.actividades = new ArrayList<Actividad>();
		actividades.add(actividad);
	}
	

}
