
public class Coche {
	
	private int id;
	private String matricula;
	private int horaentrada;
	private int horasalida;
	private int precio;
	private String observaciones;

	public Coche() {
		id=0;
		matricula="";
		horaentrada=0;
		horasalida=0;
		precio=0;
		observaciones="";
	}
	
	public Coche (String matricula, int horaentrada, int horasalida, String observaciones,int precio,int ID){
		id=ID;
		this.matricula=matricula;
		this.horaentrada=horaentrada;
		this.horasalida=horasalida;
		this.precio=precio;
		this.observaciones=observaciones;
	}
		public void setid(int id){
			this.id=id;
		}
		//public void setliga(int liga){
		//	this.liga=liga;
		//}

		public void setMatricula(String matricula){
			this.matricula=matricula;
		}
		public void setHoraentrada(int horaentrada){
			this.horaentrada=horaentrada;
		}
	
		public void setHorasalida(int horasalida){
			this.horasalida=horasalida;
		}
	
		public void setPrecio(int precio){
			this.precio=precio;
}
		public void setObservaciones(String observaciones){
			this.observaciones=observaciones;
		}


		public int getid(){
			return id;
		}
		//public int getliga(){
		//	return liga;
		//}

		public String getMatricula(){
			return matricula;
		}
		public int getHoraentrada(){
			return horaentrada;
		}
		public int getHorasalida(){
			return horasalida;
		}
		public int getPrecio(){
			return precio;
		}
		public String getObservaciones(){
			return observaciones;
		}

		//Falta por crear
		//El método toString para que aparezca en el comboBox
		public String toString(){
			return this.matricula;
		}
	}

