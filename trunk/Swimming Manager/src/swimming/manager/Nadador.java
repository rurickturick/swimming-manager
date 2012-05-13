package swimming.manager;

import java.util.ArrayList;
import java.util.Date;

public class Nadador {
    
	private String nombre;
	private Fecha fechaNacimiento;
        private boolean masculino;
	private ArrayList<Estilo> estilos = new ArrayList<Estilo>();
	private Pais pais;
	private ArrayList<Titulo> palmares = new ArrayList<Titulo>();
	private ArrayList <Marca> marcas = new ArrayList<Marca>();
        private Marca record;
        
	public Nadador(String nombre, Fecha fechaNacimiento, 
                ArrayList<Estilo> estilos, Pais pais, 
                ArrayList<Titulo> palmares, ArrayList<Marca> marcas, 
                boolean masculino) {
            this.nombre = nombre;
            this.fechaNacimiento = fechaNacimiento;
            this.masculino = masculino;
            this.estilos = estilos;
            this.pais = pais;
            this.palmares = palmares;
            this.marcas = marcas;
            this.record = null;
	}
	
	public String toString() {
            String s1 = this.nombre;
            String s2 = "";
            if (this.masculino)
                s2 = "Masculino";
            else
                s2 = "Femenino";
            String s3 = this.fechaNacimiento.toString();
            String s4 = this.pais.toString();
            String s5 = "";
            String s6 = "";
            String s7 = "";
         
            for (int i = 0; i < estilos.size(); i++) {
                s5 = s5 + "/n" + estilos.get(i).name();
            }
            
            for (int i = 0; i < marcas.size(); i++)
                s6 = s6 + "/n" + marcas.get(i).toString();            
            
            for (int i = 0; i < palmares.size(); i++)
                s7 = s7 + "/n" + palmares.get(i).toString();
         
            String resultado = s1 + "\n" + s2 + "\n" + s3 + "\n" +
                               s4 + "\n" + s5 + "\n" + s6 + "\n" + s7;
            
            return resultado;            
	
	}
        
        public String toStringEstilos(){
            String s="";
            for (int i=0; i < this.estilos.size();i++){
                s = s + this.estilos.get(i).name() + ", ";
            }
            return s;
        }
        
        public String toStringSexo(){
            if (this.masculino)  return "Masculino";
            else return "Femenino";
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
       //funcion que devuelve la edad de un nadador
        public int getEdad(){
           int edad;
           Date now= new Date();
           //calculo los años que han pasado desde el nacimiento, menos el actual
           edad=(now.getYear()+1900)- (this.getFecha().getAnyo())-1;
           //calculo si el mes de nacimiento ya ha pasado
           if((now.getMonth()+1)>this.getFecha().getMes())
               edad++;
           else{
              // calculo si el dia de nacimiento ya ha pasado
               if((now.getMonth()+1)==this.getFecha().getMes()){
                  if((now.getDate())>=this.getFecha().getDia())
                      edad++;
               }
           }
            return edad;
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
        
        public void setMarcas(ArrayList<Marca> marcas) throws DataException{
            
                this.marcas = marcas;
            
        }
        
        public void addMarca(Marca marca) throws DataException{
            if(marca!=null){
                this.marcas.add(marca);
                
                if (this.record == null) 
                 this.record = marca;
                
                else 
                    if (!this.record.getTiempo().compara(marca.getTiempo())) 
                        this.record = marca;
            }
            else throw new DataException("La marca introducida no es válida.");
        }
            
        
        public ArrayList<Marca> getMarcas(){
            return marcas;
        }
        


        public Marca getRecord(){        
            return this.record;
        }
        
        /*public Marca getRecord() throws DataException {
            if (this.record == null)
                throw new DataException("No existe récord");
            else
                return this.record;
        }*/
        
        
        public int getPosicionMarca(Marca m) throws DataException{
            boolean encontrado = false;
            // Devuelve -1 en caso de no encontrar la marca en el ArrayList
            int position = -1; 
            int i = 0;
            
            while (i < marcas.size() && !encontrado){
                if(marcas.get(i) == m){
                    position = i;
                    encontrado = true;
                }
                i++;
            }
            if(!encontrado) throw new DataException("No se ha encontrado la marca.");
            return position;
        }
        
        public String saveToString(){
            // los simbolos "/*/" son para separar las variables para hacer el
            // split cuando se carga el nadador.
            String NEWLINE= System.getProperty("line.separator");
            String s="/*nadador*/";
            s+=this.nombre+"/*/";
            String fecha=this.fechaNacimiento.toString();
            fecha.replaceAll("/", "-");
            s+=fecha+"/*/";
            s+=this.pais.getPais()+"/*/";
            s+=this.pais.getCiudad()+"/*/";
            s+=this.masculino;
            // ahora metemos todos las marcas (si hay)
            if(!this.marcas.isEmpty()){
                s+=NEWLINE;
                s+="/*marcas*/"+NEWLINE;
                for (int i=0; i < this.marcas.size();i++){
                    s+=this.nombre+"/*/";
                    s+=this.marcas.get(i).getTiempo().saveToString()+"/*/";
                    String fechaMarca=this.marcas.get(i).getFecha().toString();
                    fechaMarca.replaceAll("/", " ");
                    s+=fecha+"/*/";
                    s+=this.marcas.get(i).getDistancia()+"/*/";
                    s+=this.marcas.get(i).getEstilo()+NEWLINE;
                }
                s+="/*finmarcas*/";
            }
            s+="/*finnadador*/";
            return s;
        }
        
        
}