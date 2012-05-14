package swimming.manager;



import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SwimmingManager {
	
	private ArrayList<Nadador> nadadores;
        public static final String LINE_SEPARATOR = System.getProperty("line.separator");
        
        /** Metodo que se usa para generar un array list de estilos a partir de un String **/
        public SwimmingManager(){
            nadadores = new ArrayList<Nadador>();
        }
        
        private ArrayList<Estilo> parseEstilos(String[] estilo){
            ArrayList<Estilo> aux= new ArrayList<Estilo>();
            for (int i = 0 ; i < estilo.length;i++){
                if(estilo[i].equalsIgnoreCase("braza")) aux.add(Estilo.Braza);
                if(estilo[i].equalsIgnoreCase("espalda")) aux.add(Estilo.Espalda);
                if(estilo[i].equalsIgnoreCase("libre")) aux.add(Estilo.Libre);
                if(estilo[i].equalsIgnoreCase("mariposa")) aux.add(Estilo.Mariposa);
            }
            return aux;
        }
        
        private Estilo parseEstilos(String estilo){
           Estilo e = null;
                if(estilo.equalsIgnoreCase("braza")) e=Estilo.Braza;
                if(estilo.equalsIgnoreCase("espalda")) e=Estilo.Espalda;
                if(estilo.equalsIgnoreCase("libre")) e=Estilo.Libre;
                if(estilo.equalsIgnoreCase("mariposa")) e=Estilo.Mariposa;
            return e;
        }
       

	public void darDeAltaNadador(String nombre, String fechaNacimiento, String pais, boolean masculino){	
            String[] s = fechaNacimiento.split("-");
            Fecha fecha = new Fecha(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
            ArrayList<Estilo> estilos = new ArrayList<Estilo>();
            s = pais.split(" ");
            Pais p = new Pais(s[0], s[1]);
            ArrayList<Titulo> palmares = new ArrayList<Titulo>();
            ArrayList<Marca> marca = new ArrayList<Marca>();
            Nadador nadador = new Nadador(nombre, fecha, estilos, p, palmares, marca, masculino);
            this.nadadores.add(nadador);
        }

	public void darDeBajaNadador(String nombre)throws DataException{
            Iterator<Nadador> it = this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n = it.next();
                if (n.getNombre().equalsIgnoreCase(nombre)){
                    it.remove();
                    return;
                }
                else 
                    throw new DataException("El nadador introducido no existe.");
            }
	}
        
        public Nadador buscarNadadorPorNombre(String nombre) throws DataException{
            Nadador nad = null;
            boolean encontrado = false;
            int i = 0;
            while(!encontrado && i<this.nadadores.size()){
                if(this.nadadores.get(i).getNombre().equalsIgnoreCase(nombre)){
                    nad = this.nadadores.get(i); 
                    encontrado = true;
                }
                i++;                   
            }            
            if(nad == null) 
                throw new DataException("No hay correspondencia con el nombre introducido.");           
            return nad;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorEstilo(String e) throws DataException {
            Estilo estilo = parseEstilos(e);
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it = this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n = it.next();
                if (n.getEstilos().contains((Estilo) estilo)){
                    auxNadadores.add(n);
                }
            }            
            if(auxNadadores.isEmpty()) 
                throw new DataException("No se han encontrado nadadores asociados al estilo introducido.");         
            return auxNadadores;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorNombre(String nombre) throws DataException{
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it = this.nadadores.iterator();
            while(it.hasNext()) {
                Nadador n = it.next();
                if (n.getNombre().contains(nombre)){
                    auxNadadores.add(n);
                }
            }
            if(auxNadadores.isEmpty()) 
                throw new DataException("No se han encontrado nadadores asociados al nombre introducido.");    
            return auxNadadores;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorMarca(int distancia,String e) throws DataException{
            Estilo estilo=parseEstilos(e);
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n = it.next();
                Iterator<Marca> marc = n.getMarcas().iterator();
                while(marc.hasNext()){
                    Marca m = marc.next();
                    if ((m.getDistancia() == distancia) && (m.getEstilo() == estilo)){
                        auxNadadores.add(n);
                    }
                }
            }
            if(auxNadadores.isEmpty()) 
                throw new DataException("No se han encontrado nadadores asociados a la marca introducida.");
            return auxNadadores;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorPais(String pais) throws DataException{
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getPais().getPais().equalsIgnoreCase(pais)){
                    auxNadadores.add(n);
                }
            }
            if(auxNadadores.isEmpty()) throw new DataException("No se han encontrado nadadores asociados al país introducido.");
            return auxNadadores;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorEdad(int edad) throws DataException{
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();                   
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getEdad()==edad){
                    auxNadadores.add(n);
                }
             }
            if(auxNadadores.isEmpty()) throw new DataException("No se han encontrado nadadores asociados a la edad introducida.");
            return auxNadadores;
        }
        
        /*
         * devuelve 0 si se ha añadido bien
         *          1 si el nadador no existe
         *          2 si el formato de la marca no es correcto
         *          3 si el formato de la fecha no es correcto
         */
        public int anadirMarcaNadador(String nombre, String marca, String fecha,
                                      int distancia, Estilo estilo) throws DataException{
           try{
               Nadador nadador = buscarNadadorPorNombre(nombre);
               if (nadador == null) 
                   return 1;
                String[] auxMarca = marca.split(" ");
                if (auxMarca.length!=5) 
                    return 2;
                String[] auxfecha = fecha.split("-");
                if (auxfecha.length!=3) 
                    return 3;
                Marca m = new Marca(Integer.parseInt(auxfecha[0]),Integer.parseInt(auxfecha[1]),
                                Integer.parseInt(auxfecha[2]),Integer.parseInt(auxMarca[0]),
                                Integer.parseInt(auxMarca[1]),Integer.parseInt(auxMarca[2]),
                                Integer.parseInt(auxMarca[3]),Integer.parseInt(auxMarca[4]),
                                distancia, estilo);
                nadador.addMarca(m);
                // Añadir el estilo de la marca a los estilos el nadador si no está
                Iterator<Estilo> it = nadador.getEstilos().iterator();
                boolean encontrado = false;
                // Ver si esta el estilo ya añadido
                while(it.hasNext() && !encontrado){
                    if (it.next() == estilo) 
                        encontrado = true;
                }
                // Si no está añadido se añade
                if(!encontrado){
                    ArrayList<Estilo>estilosAux = nadador.getEstilos();
                    estilosAux.add(estilo);
                    nadador.setEstilo(estilosAux);
                 }
           }
           catch(DataException e){
               System.out.println(e.getMessage());
           }
           return 0;
        }
	
        
        
	public void eliminarMarcaNadador(Marca m, Nadador n) throws DataException{         
            if(n != null || m != null){
                if(hayNadador(n)){
                    ArrayList<Marca> marcasNadadores=n.getMarcas();
                    int pos = n.getPosicionMarca(m);
                    if(pos != -1){
                        marcasNadadores.remove(pos);
                        n.setMarcas(marcasNadadores);
                     }
                     else 
                        throw new DataException("No existe esa marca");
                 }
                else 
                    throw new DataException("No está el nadador");
            }
            else 
                throw new DataException("El nadador o la marca introducidos no son válidos");
       }


	public String verInformacionNadador(Nadador n) {
            String LabelNombre = "Nombre: ";
            String LabelFN = "Fecha de nacimiento: ";
            String LabelPais = "País: ";
            String LabelEstilos = "Estilos: ";
            String LabelMarcas = "Marcas: ";
            String LabelPalmares = "Títulos: ";
            
            String s1 = n.getNombre();
            String s2 = n.getFecha().toString();
            String s3 = n.getPais().toString();
            String s4 = "";
            String s6 = "";
            String s7 = "";
            String resultado = "";
            for(int i = 0; i < n.getEstilos().size(); i++) 
                s4 = s4 + n.getEstilos().get(i).name() + LINE_SEPARATOR;
            
            for(int i = 0; i < n.getMarcas().size(); i++)
                s6 = s6 + n.getMarcas().get(i).toString()+ LINE_SEPARATOR;            
            
            for(int i = 0; i < n.getPalmares().size(); i++)
                s7 = s7 + n.getPalmares().get(i).toString()+ LINE_SEPARATOR;
          
            resultado = LabelNombre + s1 + LINE_SEPARATOR + 
                    LabelFN + s2 + LINE_SEPARATOR + LabelPais + s3 + LINE_SEPARATOR +
                    LabelEstilos + s4 + LINE_SEPARATOR + LabelMarcas + s6 + LINE_SEPARATOR + 
                    LabelPalmares + s7 + LINE_SEPARATOR;
            
            return resultado;
            
        }
	
	public void compararMarcas(Marca marca, Marca marca2) throws DataException{
            if(marca != null && marca2 != null)
		System.out.println(marca.toString()+ marca2.toString());
            else 
                throw new DataException("Alguna de las marcas introducidas o ambas no son correctas.");
	}
        
        public ArrayList<Nadador> getNadadores(){
            return nadadores;
        }
        
        // Le entra al método un string con el nombre del archivo.
	public void saveToFile(String filename) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            File file = new File(filename);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("El fichero se ha creado correctamente");
                } else {
                    System.out.println("No ha podido ser creado el fichero");
                }
            }
            // La clave de activar o no la sobreescritura está en FileOutputStream(file, true) si le ponemos en true entonces agregas al final de la linea.
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
            Iterator<Nadador> it = this.nadadores.iterator(); 
            out.write("/*inif*/"+LINE_SEPARATOR);
            while(it.hasNext()){
                Nadador n = it.next();
                out.write(n.saveToString());
             }
             out.write("/*endf*/");
             out.close();
	}

	public void loadFromFile(String filename) throws DataException, FileNotFoundException, UnsupportedEncodingException, IOException {
            File f = new File(filename);
            this.nadadores.clear();
            InputStream file = new FileInputStream(f);
            BufferedReader reader = new BufferedReader(new InputStreamReader(file,"UTF-8"));
            String s = "";
            String tmp[];
            s=reader.readLine();
            if (!s.equalsIgnoreCase("/*inif*/"))
                throw new DataException("Error en el formato del archivo");
            s = reader.readLine();
            while(!s.equalsIgnoreCase("/*endf*/")){
                if (!s.equalsIgnoreCase("/*nadador*/")) 
                    throw new DataException("Error en el formato del archivo");
                s = reader.readLine();
                tmp = s.split("/*/");
                if (tmp.length!=5) 
                    throw new DataException("Error en el formato del archivo");
                this.darDeAltaNadador(tmp[0], tmp[1], tmp[2]+" "+tmp[3], Boolean.parseBoolean(tmp[4]));
                s = reader.readLine();
                if (s.equalsIgnoreCase("/*marcas*/")){
                    s = reader.readLine();
                    while (!s.equalsIgnoreCase("/*finmarcas*/")){
                        tmp = s.split("/*/");
                        if (tmp.length != 6) 
                            throw new DataException("Error en el formato del archivo");
                        this.anadirMarcaNadador(tmp[0], tmp[1], tmp[2],
                                Integer.parseInt(tmp[3]), this.parseEstilos(tmp[4]));
                        s = reader.readLine();
                    }
                }
                if (!s.equalsIgnoreCase("/*finnadador*/")) 
                    throw new DataException("Error en el formato del archivo");
            }	
	}

	public void verLista() {
		String s = "";
                for (int i = 0; i < this.nadadores.size(); i++){
                    s += this.nadadores.get(i).toString();
                }
               JOptionPane.showMessageDialog(null, s,"Lista" , 1, null);
	}
        
        public boolean hayNadador(Nadador nadador) throws DataException{
            boolean encontrado = false;
            int i=0;
            while(i < this.nadadores.size() && !encontrado){
                encontrado = this.nadadores.get(i) == nadador;
                i++;
            }
            if (!encontrado) 
                throw new DataException ("No existe el nadador.");
            return encontrado;
        }
        
}