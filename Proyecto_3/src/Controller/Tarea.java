package Controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Tarea implements Serializable{
	
	private String nombre;	
	private String descripcion;	
	private String tipo;
	private String tiempoEstimado;
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
