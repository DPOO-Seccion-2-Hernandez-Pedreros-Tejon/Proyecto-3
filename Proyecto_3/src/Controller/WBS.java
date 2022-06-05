package Controller;

import java.io.Serializable;
import java.util.ArrayList;

public class WBS implements Serializable{
	
	private String nombre;	
	private String descripcion;
	private ArrayList<WBS> paquetes;
	private ArrayList<Tarea> tareas;
	private WBS wbs;
	
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public ArrayList<WBS> getPaquetes() {
		return paquetes;
	}
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public WBS(String nombre, String descripcion) 
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tareas = new ArrayList<Tarea>();
		this.paquetes = new ArrayList<WBS>();
		
	}	

	public void addWBS(WBS paquete)
	{
		paquetes.add(paquete);
	}
	
	public void addTarea(Tarea tarea)
	{
		tareas.add(tarea);
	}
}
