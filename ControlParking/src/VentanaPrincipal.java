import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPrincipal extends JFrame {

	//Componentes visuales
	private JPanel contentPane;
	private JTextField matriculaTxt;
	private JTextField horaEntradaTxt;
	private JTextField horaSalidaTxt;
	private JTextField precioPagarTxt;
	private Coche coche;
	private JTextField textID;
	private JComboBox<Coche> listadoCoches;
	private DB datos;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Control de Parking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		listadoCoches = new JComboBox<Coche>();
		listadoCoches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coche=listadoCoches.getItemAt(listadoCoches.getSelectedIndex());
				if(coche!=null)
				{
				
				matriculaTxt.setText(coche.getMatricula());
				horaEntradaTxt.setText(String.valueOf(coche.getHoraentrada()));
				horaSalidaTxt.setText(String.valueOf(coche.getHorasalida()));
				precioPagarTxt.setText(String.valueOf(coche.getPrecio()));
				//textID.setText(String.valueOf(coche.getid()));
				
				}
			}
		
		});
		listadoCoches.setBounds(10, 29, 414, 20);
		contentPane.add(listadoCoches);
		
		JLabel lblListadoDeCoches = new JLabel("Listado de coches");
		lblListadoDeCoches.setBounds(10, 4, 151, 14);
		contentPane.add(lblListadoDeCoches);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setBounds(10, 67, 89, 14);
		contentPane.add(lblMatrcula);
		
		JLabel lblHoraDeEntrada = new JLabel("Hora de entrada");
		lblHoraDeEntrada.setBounds(10, 100, 101, 14);
		contentPane.add(lblHoraDeEntrada);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de salida");
		lblHoraDeSalida.setBounds(10, 136, 101, 14);
		contentPane.add(lblHoraDeSalida);
		
		JLabel lblPrecioAPagar = new JLabel("Precio a pagar");
		lblPrecioAPagar.setBounds(10, 172, 101, 14);
		contentPane.add(lblPrecioAPagar);
		
		matriculaTxt = new JTextField();
		matriculaTxt.setBounds(119, 60, 86, 20);
		contentPane.add(matriculaTxt);
		matriculaTxt.setColumns(10);
		
		horaEntradaTxt = new JTextField();
		horaEntradaTxt.setText("(0-23)");
		horaEntradaTxt.setColumns(10);
		horaEntradaTxt.setBounds(119, 97, 86, 20);
		contentPane.add(horaEntradaTxt);
		
		horaSalidaTxt = new JTextField();
		horaSalidaTxt.setText("(0-23)");
		horaSalidaTxt.setColumns(10);
		horaSalidaTxt.setBounds(119, 133, 86, 20);
		contentPane.add(horaSalidaTxt);
		
		precioPagarTxt = new JTextField();
		precioPagarTxt.setEditable(false);
		precioPagarTxt.setColumns(10);
		precioPagarTxt.setBounds(119, 169, 86, 20);
		contentPane.add(precioPagarTxt);
		
		JButton btnNewButton = new JButton("A PAGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean correcto=true;
				if((matriculaTxt.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "Has introducido mal La Matricula");
				}
				 if((horaEntradaTxt.getText().equals(""))){
					// int horaentrada=0;
					// if(horaentrada>23)
					// (correcto = false);
					JOptionPane.showMessageDialog(null, "Has introducido mal la HoraEntrada");
					 
					 }
				 if((horaSalidaTxt.getText()).equals("")){
					JOptionPane.showMessageDialog(null, "Has introducido mal el HoraSalida");
				}
				
				else{
				//2.- Crearemos un nuevo objeto delincuente
				Coche c=new Coche();
				int ID=0;
				
				c.setHoraentrada(Integer.parseInt(horaEntradaTxt.getText()));
				c.setHorasalida(Integer.parseInt(horaSalidaTxt.getText()));
				c.setPrecio(Integer.parseInt(precioPagarTxt.getText()));
				c.setid(ID);
				listadoCoches.addItem(c);
				
				}
			}
		});
		btnNewButton.setBounds(230, 58, 194, 128);
		contentPane.add(btnNewButton);
		
		datos=new DB(listadoCoches);
		datos.leerCoche();
	}
}
