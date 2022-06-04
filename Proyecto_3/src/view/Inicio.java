package view;

import java.awt.EventQueue;


import javax.swing.JFrame;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.SwingConstants;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import Controller.Actividad;
import Controller.ManejadorProyectos;
import Controller.Participante;
import Controller.PersistenciaException;
import Controller.Proyecto;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;

import java.awt.SystemColor;

import java.time.LocalTime; // import the LocalTime class

import java.util.Date;
import view.Controller;
import javax.swing.ImageIcon;
import java.awt.Dimension;
 
public class Inicio {
	
	static ManejadorProyectos manejadorProyectos;
	static Participante usuarioActual;
	static XYChart grafica;
	static int graficaAltura;
	static int graficaAnchura;
	private JFrame frame;
	private JTextField textField;
	
	private JTextField txtDdmmyyyy;


	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 * @throws PersistenciaException 
	 */
	public static void main(String[] args) throws PersistenciaException 
	{
		Controller.cargarDatosM();
		manejadorProyectos = Controller.manejadorProyectos;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1053, 703);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel principal = new JPanel();
		frame.getContentPane().add(principal, BorderLayout.CENTER);
		principal.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(102, 153, 204));
		principal.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new MigLayout("", "[][100px,grow,fill][leading][100px:n]", "[]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1, "cell 0 0");
		
		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		panel_2.add(lblNewLabel_2, "cell 2 0,alignx trailing,growy");
		
		JLabel lblNewLabel = new JLabel("Project Manager");
		lblNewLabel.setLabelFor(panel_2);
		
		JLabel lblNewLabel_5 = new JLabel(darFechaddMM());
		panel_2.add(lblNewLabel_5, "cell 3 0");
		
		
		crearPanelInicioSesion(principal);
		//crearPanelNuevoProyecto(principal);
		//crearPanelProyecto(principal);
		//crearPanelModificarActividad(principal);
		
		
			
	}
	
	
	public void crearPanelInicioSesion(JPanel panel_1)

	{
		JPanel panelInicioSesion = new JPanel();
		panelInicioSesion.setForeground(new Color(255, 255, 255));
		panelInicioSesion.setBackground(Color.DARK_GRAY);
		panel_1.add(panelInicioSesion, BorderLayout.CENTER);
		panelInicioSesion.setLayout(new MigLayout("", "[grow][][grow]", "[grow]"));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(Color.DARK_GRAY);
		panelInicioSesion.add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[grow]", "[grow,center][grow,center][grow,center][grow,center]"));
		
		JLabel lblNewLabel_4 = new JLabel("Inicia tu sesi\u00F3n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(Color.DARK_GRAY);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4, "cell 0 0,growx");
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(new Color(255, 255, 255));
		panel_5.setBackground(Color.DARK_GRAY);
		panel.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ingrese su nombre de usuario:");
		lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(0, 39, 451, 13);
		panel_5.add(lblNewLabel_4_1);
		
		JTextField textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(155, 77, 142, 20);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setForeground(new Color(255, 255, 255));
		panel_6.setBackground(Color.DARK_GRAY);
		panel.add(panel_6, "cell 0 2,grow");
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(new Color(255, 255, 255));
		panel_7.setBackground(Color.DARK_GRAY);
		panel.add(panel_7, "cell 0 3,grow");
		
		JLabel lblNewLabel_7 = new JLabel("No existe un usuario con ese nombre");
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(109, 10, 230, 32);
		lblNewLabel_7.setVisible(false);
		panel_6.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(textField_1.getText().equals("")))
				{
					String nombre = textField_1.getText();
					boolean aux = false;
					for (Participante p: manejadorProyectos.usuarios)
					{
						if (nombre.equals(p.getNombre()))
						{
							aux = true;
							usuarioActual = p;
							manejadorProyectos.usuarioActual = p;
						}
					}
					if (aux)
					{
						Controller consola = new Controller();
						panelInicioSesion.setVisible(false);
						panel_1.remove(panelInicioSesion);
						crearPanelNuevoProyecto(panel_1);
					}
					else
					{
						lblNewLabel_7.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(102, 153, 255));
		btnNewButton.setBounds(159, 62, 125, 21);
		panel_6.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("\u00D3");
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(Color.DARK_GRAY);
		panelInicioSesion.add(lblNewLabel_3, "flowx,cell 1 0");
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(255, 255, 255));
		panel_4.setBackground(Color.DARK_GRAY);
		panelInicioSesion.add(panel_4, "cell 2 0,grow");
		panel_4.setLayout(new MigLayout("", "[grow]", "[grow,center][grow,center][grow,center][grow,center]"));
		
		JLabel lblNewLabel_4_2 = new JLabel("Crea un usuario nuevo");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_4_2, "cell 0 0,alignx center");
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setForeground(new Color(255, 255, 255));
		panel_5_1.setBackground(Color.DARK_GRAY);
		panel_5_1.setLayout(null);
		panel_4.add(panel_5_1, "cell 0 1,grow");
		
		JTextField textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(Color.DARK_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(177, 77, 142, 20);
		panel_5_1.add(textField_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Ingrese su nombre de usuario:");
		lblNewLabel_4_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setBounds(10, 37, 480, 13);
		panel_5_1.add(lblNewLabel_4_1_1);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setForeground(new Color(255, 255, 255));
		panel_5_2.setBackground(Color.DARK_GRAY);
		panel_5_2.setLayout(null);
		panel_4.add(panel_5_2, "cell 0 2,grow");
		
		JTextField textField_3 = new JTextField();
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setBackground(Color.DARK_GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(175, 64, 142, 20);
		panel_5_2.add(textField_3);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Ingrese su correo:");
		lblNewLabel_4_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_2.setBounds(0, 25, 480, 13);
		panel_5_2.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_6 = new JLabel("Ya existe un usuario con ese nombre o ese correo");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setBounds(96, 111, 307, 20);
		lblNewLabel_6.setVisible(false);
		panel_5_2.add(lblNewLabel_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.DARK_GRAY);
		panel_4.add(panel_8, "cell 0 3,grow");
		panel_8.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(textField_2.getText().equals("")) && !(textField_3.getText().equals("")))
				{
					String nombre = textField_2.getText();
					String correo = textField_3.getText(); 
					boolean aux = false;
					for (Participante p: manejadorProyectos.usuarios)
					{
						if (nombre.equals(p.getNombre()) || correo.equals(p.getCorreo()))
						{
							aux = true;
						}
					}
					if (!aux)
					{
						Controller consola = new Controller();
						usuarioActual = new Participante(nombre, correo);
						manejadorProyectos.usuarioActual = usuarioActual;
						manejadorProyectos.usuarios.add(usuarioActual);
						try {
							manejadorProyectos.salvarDatos();
						} catch (PersistenciaException e1) {
							//Auto-generated catch block
							e1.printStackTrace();
						}
						panelInicioSesion.setVisible(false);
						panel_1.remove(panelInicioSesion);
						crearPanelNuevoProyecto(panel_1);
					}
					else
					{
						lblNewLabel_6.setVisible(true);
					}
				}
			}
		});
		btnNewButton_1.setBackground(new Color(102, 153, 255));
		btnNewButton_1.setBounds(182, 10, 125, 21);
		panel_8.add(btnNewButton_1);
	}

	public void crearPanelNuevoProyecto(JPanel principal)
	{
		JPanel panelCrearProyecto = new JPanel();
		panelCrearProyecto.setForeground(new Color(255, 255, 255));
		panelCrearProyecto.setBackground(Color.DARK_GRAY);
		principal.add(panelCrearProyecto, BorderLayout.CENTER);
		panelCrearProyecto.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(7, 7, 190, 622);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(Color.DARK_GRAY);
		panelCrearProyecto.add(panel);
		panel.setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][::130,grow]"));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(211, 7, 821, 622);
		panel_4.setForeground(new Color(255, 255, 255));
		panel_4.setBackground(Color.DARK_GRAY);
		panelCrearProyecto.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBounds(16, 63, 789, 265);
		panel_5_1.setForeground(new Color(255, 255, 255));
		panel_5_1.setBackground(Color.DARK_GRAY);
		panel_5_1.setLayout(null);
		panel_4.add(panel_5_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(Color.DARK_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(386, 33, 289, 25);
		panel_5_1.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		JList list = new JList();
		ArrayList<String> nombres = new ArrayList();
		for (Proyecto proyecto: manejadorProyectos.proyectosCargados) 
		{
			nombres.add(proyecto.getNombre());
		}
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setModel(new AbstractListModel() {
			String[] values = nombres.toArray(new String[nombres.size()]);
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        String selectedItem = list.getSelectedValue().toString();
		        for (Proyecto proyecto: manejadorProyectos.proyectosCargados)
		        {
		        	if (proyecto.getNombre().equals(selectedItem))
		        	{
		        		manejadorProyectos.setProyectoActual(proyecto);
		        	}
		        }
		        panelCrearProyecto.setVisible(false);
				principal.remove(panelCrearProyecto);
		        crearPanelProyecto(principal);
		    }
		};
		list.addMouseListener(mouseListener);
		scrollPane.setViewportView(list);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel.add(panel_3, "cell 0 1,grow");
		panel_3.setLayout(null);
		
		JButton lblNewLabel_8 = new JButton("Cambiar usuario");
		lblNewLabel_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCrearProyecto.setVisible(false);
				principal.remove(panelCrearProyecto);
				crearPanelInicioSesion(principal);
			}
		});
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(10, 32, 144, 66);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Nombre del Proyecto:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setBounds(6, 25, 331, 30);
		panel_5_1.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1_1.setBounds(6, 115, 331, 30);
		panel_5_1.add(lblNewLabel_4_1_1_1);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(386, 65, 289, 137);
		panel_5_1.add(textField);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Fecha estimada de finalizaci\u00F3n:");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1_1_1.setBounds(6, 205, 331, 35);
		panel_5_1.add(lblNewLabel_4_1_1_1_1);
		
		JTextField txtDdmmyyyy = new JTextField();
		txtDdmmyyyy.setText("DD/MM/YYYY");
		txtDdmmyyyy.setForeground(Color.WHITE);
		txtDdmmyyyy.setColumns(10);
		txtDdmmyyyy.setBackground(Color.DARK_GRAY);
		txtDdmmyyyy.setBounds(386, 214, 289, 25);
		panel_5_1.add(txtDdmmyyyy);
		
		JButton btnNewButton_2 = new JButton("Listo");
		
		btnNewButton_2.setIcon(null);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!(textField_2.getText().equals("")) && !(textField.getText().equals(""))) && !(txtDdmmyyyy.getText().equals("")))
				{
					String nombre = textField_2.getText();
					String descripcion = textField.getText();
					String fechaEstimada = txtDdmmyyyy.getText();
					
					String fechaInicio = darFechaddMM();

					Proyecto proyectoActual = new Proyecto(nombre, descripcion, fechaInicio, fechaEstimada, usuarioActual);
				
					manejadorProyectos.proyectosCargados.add(proyectoActual);
				
					manejadorProyectos.proyectoActual = proyectoActual;
					
					try {
						manejadorProyectos.salvarDatos();
					} catch (PersistenciaException e1) {
						//Auto-generated catch block
						e1.printStackTrace();
					}

					
					panelCrearProyecto.setVisible(false);
					principal.remove(panelCrearProyecto);
					crearPanelProyecto(principal);
					
				}
				
			}
			});
		btnNewButton_2.setBounds(695, 210, 70, 30);
		panel_5_1.add(btnNewButton_2);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBounds(0, 328, 821, 56);
		panel_5_2.setToolTipText("Reporte");
		panel_5_2.setForeground(new Color(255, 255, 255));
		panel_5_2.setBackground(new Color(102, 153, 204));
		panel_5_2.setLayout(null);
		panel_4.add(panel_5_2);
		
		JLabel lblNewLabel_7 = new JLabel("Reporte");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setBounds(331, 6, 104, 33);
		panel_5_2.add(lblNewLabel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(16, 388, 789, 218);
		panel_8.setBackground(Color.DARK_GRAY);
		panel_4.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_81 = new JLabel("");
		lblNewLabel_81.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Border borde = BorderFactory.createLineBorder(Color.WHITE, 1);
		lblNewLabel_81.setBorder(borde);
		lblNewLabel_81.setForeground(new Color(255, 255, 255));
		lblNewLabel_81.setBounds(390, 117, 377, 59);
		panel_8.add(lblNewLabel_81);
		
		JButton btnNewButton_2_1 = new JButton("Listo");
		btnNewButton_2_1.setBounds(697, 32, 70, 30);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(textField_5.getText().equals("")))
				{
					String nombre = textField_5.getText();
					boolean aux = false;
					
					for (Participante o: manejadorProyectos.usuarios)
					{
						if (nombre.equals(o.getNombre()))
						{
							aux = true;
							lblNewLabel_81.setText("<html>El usuario " + o.getNombre() + " ha trabajado un tiempo total de " + o.getTiempoTotal() + "<br>y ha invertido en promedio"
									+ " por actividad un tiempo de " + o.getTiempoProm() + "</html>");
						}
					}
					if (!aux)
					{
						lblNewLabel_81.setText("No existe un usuario con ese nombre para generar el reporte.");
					}
					
					
				}
				
			}
			});
		panel_8.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Nombre de usuario:");
		lblNewLabel_4_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1_1_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1_2.setBounds(24, 28, 331, 30);
		panel_8.add(lblNewLabel_4_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.WHITE);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.DARK_GRAY);
		textField_5.setBounds(390, 33, 289, 25);
		panel_8.add(textField_5);
		
		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Reporte:");
		lblNewLabel_4_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1_1_1_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1_1_2.setBounds(24, 117, 331, 30);
		panel_8.add(lblNewLabel_4_1_1_1_2);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 153, 255));
		panel_1.setBounds(0, 6, 821, 55);
		panel_4.add(panel_1);
		
		JLabel lblNewLabel_6 = new JLabel("Crear Proyecto");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_1.add(lblNewLabel_6);
		panelCrearProyecto.setVisible(true);
	}
	
	public void crearPanelModificarActividad(JPanel principal)
	{
		JPanel panelModificarActividad = new JPanel();
		panelModificarActividad.setForeground(new Color(255, 255, 255));
		panelModificarActividad.setBackground(Color.DARK_GRAY);
		principal.add(panelModificarActividad, BorderLayout.CENTER);
		panelModificarActividad.setLayout(null);
		
		
		//panel.setText(actividadActual.getTipo)
		JPanel panel = new JPanel();
		panel.setBounds(7, 7, 190, 622);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(Color.DARK_GRAY);
		panelModificarActividad.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		JList list = new JList();
		ArrayList<String> nombres = new ArrayList();
		for (Actividad actividad: manejadorProyectos.proyectoActual.getActividades()) 
		{
			nombres.add(actividad.getNombre());
		}
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setModel(new AbstractListModel() {
			String[] values = nombres.toArray(new String[nombres.size()]);
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        String selectedItem = list.getSelectedValue().toString();
		        for (Actividad actividad: manejadorProyectos.proyectoActual.getActividades())
		        {
		        	if (actividad.getNombre().equals(selectedItem))
		        	{
		        		manejadorProyectos.setActividadActual(actividad);
		        	}
		        }
		        panelModificarActividad.setVisible(false);
				principal.remove(panelModificarActividad);
		        crearPanelModificarActividad(principal);
		    }
		};
		list.addMouseListener(mouseListener);
		scrollPane.setViewportView(list);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(211, 7, 821, 622);
		panel_4.setForeground(new Color(255, 255, 255));
		panel_4.setBackground(Color.DARK_GRAY);
		panelModificarActividad.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBounds(16, 63, 789, 553);
		panel_5_1.setForeground(new Color(255, 255, 255));
		panel_5_1.setBackground(Color.DARK_GRAY);
		panel_5_1.setLayout(null);
		panel_4.add(panel_5_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setText(Controller.manejadorProyectos.actividadActual.getTipo());
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(Color.DARK_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(386, 33, 289, 25);
		textField_2.setText(manejadorProyectos.actividadActual.getTipo());
		panel_5_1.add(textField_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Tipo");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setBounds(6, 25, 331, 30);
		panel_5_1.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1_1.setBounds(6, 115, 331, 30);
		panel_5_1.add(lblNewLabel_4_1_1_1);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(386, 65, 289, 137);
		textField.setText(manejadorProyectos.actividadActual.getDescripcion());
		panel_5_1.add(textField);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Fecha de realización");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1_1_1.setBounds(6, 205, 331, 35);
		panel_5_1.add(lblNewLabel_4_1_1_1_1);
		
		txtDdmmyyyy = new JTextField();
		txtDdmmyyyy.setText("DD/MM/YYYY");
		txtDdmmyyyy.setForeground(Color.WHITE);
		txtDdmmyyyy.setColumns(10);
		txtDdmmyyyy.setBackground(Color.DARK_GRAY);
		txtDdmmyyyy.setBounds(386, 214, 289, 25);
		txtDdmmyyyy.setText(manejadorProyectos.actividadActual.getFecha());
		panel_5_1.add(txtDdmmyyyy);
		
		JButton btnNewButton_2 = new JButton("Listo");
		btnNewButton_2.setIcon(null);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!(textField_2.getText().equals("")) && !(textField.getText().equals(""))) && !(txtDdmmyyyy.getText().equals("")))
				{
					manejadorProyectos.actividadActual.setDescripcion(textField.getText());
					manejadorProyectos.actividadActual.setTipo(textField_2.getText());
					manejadorProyectos.actividadActual.setFecha(txtDdmmyyyy.getText());
					manejadorProyectos.actividadActual.setHoraInicio(textField_4.getText());
					manejadorProyectos.actividadActual.setHoraFinal(textField_5.getText());
					
					try {
						manejadorProyectos.salvarDatos();
					} catch (PersistenciaException e1) {
						//Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					panelModificarActividad.setVisible(false);
					principal.remove(panelModificarActividad);
			        crearPanelProyecto(principal);
				}
				
			}
			});
		btnNewButton_2.setBounds(343, 414, 70, 30);
		panel_5_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Hora de Inicio");
		lblNewLabel_4_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1_1_1_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1_1_1_1.setBounds(6, 268, 331, 35);
		panel_5_1.add(lblNewLabel_4_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Hora de Finalización");
		lblNewLabel_4_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1_1_1_1_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_4_1_1_1_1_1_1.setBounds(6, 338, 331, 35);
		panel_5_1.add(lblNewLabel_4_1_1_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.DARK_GRAY);
		textField_4.setBounds(386, 274, 289, 25);
		textField_4.setText(manejadorProyectos.actividadActual.getHoraInicio());
		panel_5_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.WHITE);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.DARK_GRAY);
		textField_5.setBounds(386, 344, 289, 25);
		textField_5.setText(manejadorProyectos.actividadActual.getHoraFinal());
		panel_5_1.add(textField_5);
		Border borde = BorderFactory.createLineBorder(Color.WHITE, 1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 153, 255));
		panel_1.setBounds(0, 6, 821, 55);
		panel_4.add(panel_1);
		
		JLabel lblNewLabel_6 = new JLabel("Modificar Actividad");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_1.add(lblNewLabel_6);
		panelModificarActividad.setVisible(true);
	}

	public void cargarGraficaProyectoActual() {
		 
	    // Create Chart
		graficaAnchura = 741;
		graficaAltura = 302;
	    XYChart chart = new XYChartBuilder().width(graficaAnchura).height(graficaAltura).title(getClass().getSimpleName()).xAxisTitle("X").yAxisTitle("Y").build();
	 
	    // Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
	    chart.getStyler().setAxisTitlesVisible(false);
	    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
	 
	    // Series
	    List<Date> xData = new ArrayList<Date>();
	    List<Double> yData = new ArrayList<Double>();
	 
	    DateFormat sdf = new SimpleDateFormat("MM/yyyy");
	    Date date = null;
	    
	    
	    for (Participante p: manejadorProyectos.usuarios)
	    {
	    	xData = new ArrayList<Date>();
	    	yData = new ArrayList<Double>();
	    	for (int i = 1; i <= 12; i++) 
	    	{
	    		try {
			  	       date = sdf.parse(i + 1 + "/2022");
			  		} 
	    		catch (ParseException e) 
	    			{
			  	        e.printStackTrace();
			  	    }
			  	xData.add(date);
			    yData.add((double) p.getActividadesMesParticipante(p, manejadorProyectos.proyectoActual, i ));
		    	    
		    }
	    	chart.addSeries(p.getNombre(), xData, yData);
	    	
	    }
	    
	    grafica = chart;
	    
	 
	    
	  }
	public void crearPanelProyecto(JPanel principal)
	{
		cargarGraficaProyectoActual();
		try {
			BitmapEncoder.saveBitmap(grafica, "src/view/graficaProyectoActual", BitmapFormat.PNG);
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
	
		
		JPanel panelCrearProyecto = new JPanel();
		panelCrearProyecto.setForeground(new Color(255, 255, 255));
		panelCrearProyecto.setBackground(Color.DARK_GRAY);
		principal.add(panelCrearProyecto, BorderLayout.CENTER);
		panelCrearProyecto.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(7, 7, 190, 622);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(Color.DARK_GRAY);
		panelCrearProyecto.add(panel);
		panel.setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][::130,grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		JList list = new JList();
		ArrayList<String> nombres = new ArrayList();
		for (Actividad actividad: manejadorProyectos.proyectoActual.getActividades()) 
		{
			nombres.add(actividad.getNombre());
		}
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setModel(new AbstractListModel() {
			String[] values = nombres.toArray(new String[nombres.size()]);
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        String selectedItem = list.getSelectedValue().toString();
		        for (Actividad actividad: manejadorProyectos.proyectoActual.getActividades())
		        {
		        	if (actividad.getNombre().equals(selectedItem))
		        	{
		        		manejadorProyectos.setActividadActual(actividad);
		        	}
		        }
		        panelCrearProyecto.setVisible(false);
				principal.remove(panelCrearProyecto);
		        crearPanelModificarActividad(principal);
		    }
		};
		list.addMouseListener(mouseListener);
		scrollPane.setViewportView(list);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel.add(panel_3, "cell 0 1,grow");
		panel_3.setLayout(null);
		
		JButton lblNewLabel_8 = new JButton("Volver");
		lblNewLabel_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCrearProyecto.setVisible(false);
				principal.remove(panelCrearProyecto);
				crearPanelNuevoProyecto(principal);
			}
		});
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(10, 32, 144, 66);
		panel_3.add(lblNewLabel_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(218, 7, 821, 622);
		panel_4.setForeground(new Color(255, 255, 255));
		panel_4.setBackground(Color.DARK_GRAY);
		panelCrearProyecto.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Informaci\u00F3n del proyecto");
		lblNewLabel_9.setBackground(new Color(153, 204, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setBounds(0, 0, 821, 23);
		panel_4.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Subir actividad");
		lblNewLabel_9_1.setOpaque(true);
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9_1.setBackground(new Color(153, 204, 255));
		lblNewLabel_9_1.setBounds(0, 414, 821, 23);
		panel_4.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10 = new JLabel("Nombre del proyecto: " + manejadorProyectos.proyectoActual.nombre);
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(10, 33, 400, 13);
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Fecha de inicio (dd/mm/aaaa): " + manejadorProyectos.proyectoActual.fechaInicio);
		lblNewLabel_10_1.setForeground(Color.WHITE);
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10_1.setBounds(10, 56, 400, 13);
		panel_4.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_2 = new JLabel("Due\u00F1o del proyecto: " + manejadorProyectos.proyectoActual.duenio.getNombre());
		lblNewLabel_10_2.setForeground(Color.WHITE);
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10_2.setBounds(411, 35, 400, 13);
		panel_4.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10_3 = new JLabel("Fecha estimada  (dd/mm/aaaa): " + manejadorProyectos.proyectoActual.fechaEstimada);
		lblNewLabel_10_3.setForeground(Color.WHITE);
		lblNewLabel_10_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10_3.setBounds(411, 58, 400, 13);
		panel_4.add(lblNewLabel_10_3);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setOpaque(true);
		ImageIcon graficaPNG;
		try {
			String currentPath = new File(".").getCanonicalPath();
			graficaPNG = new ImageIcon(ImageIO.read(new File(currentPath + "\\src\\view\\graficaProyectoActual.png")));
			lblNewLabel_11.setIcon(graficaPNG);
			lblNewLabel_11.revalidate();
			lblNewLabel_11.repaint();
			
			lblNewLabel_11.setLocation(32, 102);
			lblNewLabel_11.setSize(new Dimension(741, 302));

			panel_4.add(lblNewLabel_11);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		
		JLabel lblNewLabel_10_4 = new JLabel("Nombre del Participante:");
		lblNewLabel_10_4.setForeground(Color.WHITE);
		lblNewLabel_10_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10_4.setBounds(10, 447, 400, 13);
		panel_4.add(lblNewLabel_10_4);
		
		textField = new JTextField();
		textField.setBounds(269, 446, 352, 19);
		panel_4.add(textField);
		textField.setColumns(10);
		textField.setText(manejadorProyectos.usuarioActual.getNombre());
		
		JLabel lblNewLabel_10_4_1 = new JLabel("Nombre de la actividad:");
		lblNewLabel_10_4_1.setForeground(Color.WHITE);
		lblNewLabel_10_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10_4_1.setBounds(10, 471, 400, 13);
		panel_4.add(lblNewLabel_10_4_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(269, 470, 352, 19);
		panel_4.add(textField_4);
		
		JLabel lblNewLabel_10_4_2 = new JLabel("Fecha:");
		lblNewLabel_10_4_2.setForeground(Color.WHITE);
		lblNewLabel_10_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10_4_2.setBounds(10, 495, 400, 13);
		panel_4.add(lblNewLabel_10_4_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(269, 494, 352, 19);
		textField_5.setText(darFechaddMM());
		panel_4.add(textField_5);
		
		JLabel lblNewLabel_10_4_3 = new JLabel("Tipo de la actividad:");
		lblNewLabel_10_4_3.setForeground(Color.WHITE);
		lblNewLabel_10_4_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10_4_3.setBounds(10, 519, 400, 13);
		panel_4.add(lblNewLabel_10_4_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(269, 518, 352, 19);
		panel_4.add(textField_6);
		
		JLabel lblNewLabel_10_4_4 = new JLabel("Descripci\u00F3n: ");
		lblNewLabel_10_4_4.setForeground(Color.WHITE);
		lblNewLabel_10_4_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10_4_4.setBounds(10, 543, 400, 13);
		panel_4.add(lblNewLabel_10_4_4);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(269, 542, 352, 43);
		panel_4.add(textField_7);
		
		JButton lblNewLabel_8_1 = new JButton("Subir");
		lblNewLabel_8_1.setOpaque(true);
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8_1.setBackground(Color.WHITE);
		lblNewLabel_8_1.setBounds(650, 471, 144, 66);
		lblNewLabel_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!(textField.getText().equals("")) && !(textField_4.getText().equals(""))) && (!(textField_5.getText().equals("")) && !(textField_6.getText().equals(""))))
				{
					String autor = textField.getText();
					String nombre = textField_4.getText();
					String fecha = textField_5.getText();
					String tipo = textField_6.getText();
					String descripcion = textField_7.getText();
					String horaInicio = getCurrentHour();
					Participante usuario = null;
					boolean aux = false;
					for (Participante o: manejadorProyectos.usuarios)
					{
						if (autor.equals(o.getNombre()))
						{
							aux = true;
							usuario = o;
							Actividad actividadActual = new Actividad(nombre, tipo, fecha, horaInicio,
									  descripcion, usuario,manejadorProyectos.proyectoActual);
							actividadActual.setHoraFinal(horaInicio);
							manejadorProyectos.proyectoActual.actividades.add(actividadActual);
							usuario.actividadesParticipante.add(actividadActual);
						
							manejadorProyectos.actividadActual = actividadActual;
							
							try {
								manejadorProyectos.salvarDatos();
							} catch (PersistenciaException e1) {
								//Auto-generated catch block
								e1.printStackTrace();
							}
							panelCrearProyecto.setVisible(false);
							principal.remove(panelCrearProyecto);
							String currentPath = null;
							try {
								currentPath = new File(".").getCanonicalPath();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
							File imagen = new File(currentPath + "\\src\\view\\graficaProyectoActual.png");
							imagen.delete();
							cargarGraficaProyectoActual();
					        crearPanelProyecto(principal);
					        
					        
							
						}
					}
					
					
					
					
				}
				
			}
			});
		panel_4.add(lblNewLabel_8_1);
		Border borde = BorderFactory.createLineBorder(Color.WHITE, 1);
		panelCrearProyecto.setVisible(true);
		
	}
	
	public static String darFechaddMM() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String strDate = date.format(myFormatObj);
		return strDate;
	}
	
	public static String getCurrentHour() 
	{
		LocalTime horaActual = LocalTime.now();
		DateTimeFormatter horaAct = DateTimeFormatter.ofPattern("HH:mm:ss");
		String fHour = horaActual.format(horaAct);
		return fHour;
	}
}
