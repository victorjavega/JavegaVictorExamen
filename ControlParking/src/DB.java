import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;


import com.mysql.jdbc.Statement;

public class DB {
	private VentanaPrincipal ventana;
	Connection conexion = null; //maneja la conexión
	Statement instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados
	private JComboBox<Coche> listadoCoches;



	public DB(JComboBox listadoCoches) {
		// TODO Auto-generated constructor stub
		crearconexion();
		this.listadoCoches=listadoCoches;
	}

	public void crearconexion (){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/parking","root","tonphp");

		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}
		// fin de catch
	}

	public void leerCoche (){
		try{
		// crea objeto Statement para consultar la base de datos
					instruccion = (Statement) conexion.createStatement();
					// consulta la base de datos
					conjuntoResultados = instruccion.executeQuery("SELECT * FROM controlcoches");
					//Mostrar por pantalla
					while (conjuntoResultados.next())
					{
					   System.out.println("id="+conjuntoResultados.getObject("ID")+
					      ", matricula="+conjuntoResultados.getObject("matricula"));
					   Coche c=new Coche((String)conjuntoResultados.getObject("matricula"),
							   							(Integer)conjuntoResultados.getObject("horaentrada"),
							   							(Integer)conjuntoResultados.getObject("horasalida"),
							   							(String)conjuntoResultados.getObject("observaciones"),
							   							(Integer)conjuntoResultados.getObject("precio"),
							   							(Integer)conjuntoResultados.getObject("ID"));


					   listadoCoches.addItem(c);
					}
					conjuntoResultados.close();	

			}
		catch( SQLException excepcionSql ){
		excepcionSql.printStackTrace();}
		}
}