package swimming.manager;

import java.util.ArrayList;

public class Nadador {
    
	private String nombre;
	private Fecha fechaNacimiento;
	private ArrayList<Estilo> estilos = new ArrayList<Estilo>();
	private Pais pais;
	private ArrayList<Titulo> palmares = new ArrayList<Titulo>();
	private ArrayList <Marca> marcas = new ArrayList<Marca>();
	
        public Nadador(){
            this.nombre="";
            this.fechaNacimiento=new Fecha();
            this.estilos=new ArrayList<Estilo>();
            this.pais=new Pais();
            this.palmares=new ArrayList<Titulo>();
            this.marcas=new ArrayList<Marca>();
        }
        
	public Nadador(String nombre, Fecha fechaNacimiento, ArrayList<Estilo> estilos,
			Pais pais, ArrayList<Titulo> palmares, ArrayList<Marca> marcas) {
            
            this.nombre = nombre;
            this.fechaNacimiento=fechaNacimiento;
            this.estilos = estilos;
            this.pais=pais;
            this.palmares=palmares;
            this.marcas = marcas;		
	}
	
	public String toString() {
            
            String s1 = this.nombre;
            String s2= this.fechaNacimiento.toString();
            String s3= this.pais.toString();
            String s4= "";
            String s5= this.pais.toString();
            String s6="";
            String s7="";
            for(int i=0; i<estilos.size(); i++) {
                s4= s4+ estilos.get(i).name();
            }
            
            for(int i=0; i<marcas.size(); i++){
                s6= s6+ marcas.get(i).toString();
            }
            
            for(int i=0; i<palmares.size(); i++){
                s7=s7 + palmares.get(i).toString();
            }
            
            String resultado = s1 + "\n" + s2 + "\n" + s3 + "\n" +
                               s4 + "\n" + s5 + "\n" + s6 + "\n" + s7;
            
            return resultado;            
	
	}
        
        public void setNombre(String nombre){
            this.nombre = nombre;
        }
        
        public String getNombre(){
            return nombre;
        }
        
        public void setFecha(Fecha fecha){
            this.fechaNacimiento = fecha;
        }
        
        public Fecha getFecha(){
            return fechaNacimiento;
        }
        
        public void setEstilo(ArrayList<Estilo> estilo){
            this.estilos = estilo;
        }
        
        public ArrayList<Estilo> getEstilos(){
            return estilos;
        }
        
        public void setPalmares (ArrayList<Titulo> titulos){
            this.palmares = titulos;
        }
        
        public ArrayList<Titulo> getPalmares() {
            return palmares;
        }
        
        public void setPais(Pais pais){
            this.pais = pais;
        }
        
        public Pais getPais() {
            return pais;
        }
        
        public void setMarcas(ArrayList<Marca> marcas){
            this.marcas = marcas;
        }
        
        public ArrayList<Marca> getMarcas(){
            return marcas;
        }
        
        
}