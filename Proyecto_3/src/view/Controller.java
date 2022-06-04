package view;
import Controller.Actividad;
import Controller.ManejadorProyectos;
import Controller.Participante;
import Controller.PersistenciaException;
import Controller.Proyecto;
import Controller.Cronometro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class 
import java.time.LocalTime; // import the LocalTime class

public class Controller {

	static ManejadorProyectos manejadorProyectos;
	static Participante usuarioActual;
	
	public static void cargarDatosM() throws PersistenciaException
	{
		String archivoProyectos = "datosProyectos";
		String archivoUsuarios = "datosUsuarios";
		manejadorProyectos = new ManejadorProyectos(usuarioActual, archivoProyectos, archivoUsuarios);
		cargarProyectos();
		cargarUsuarios();
	}
	
	public static ArrayList<Proyecto> cargarProyectos() throws PersistenciaException 
	{
		manejadorProyectos.cargarProyectos();
		return null;
	}
	
	public static ArrayList<Participante> cargarUsuarios() throws PersistenciaException 
	{
		manejadorProyectos.cargarUsuarios(); 
		return null;
	}
	
	
	
	public static String getCurrentDate() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String strDate = date.format(myFormatObj);
		return strDate;
	}

}