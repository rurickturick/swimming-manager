package swimming.manager;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SwimmingManager {
	
	private ArrayList<Nadador> nadadores;
        public static final String LINE_SEPARATOR = System.getProperty("line.separator");
        private File ficheroActual;
        public ArrayList<String> paises;
        
        /** Metodo que se usa para generar un array list de estilos a partir de un String **/
        
        public SwimmingManager(){
            nadadores = new ArrayList<Nadador>();
            paises = new ArrayList<String>();
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
       
       public boolean hayNadador(String nombre){
           int i=0;
           while (i < this.nadadores.size()){
               if (this.nadadores.get(i).getNombre().equalsIgnoreCase(nombre))
                   return true;
               i++;
           }
           return false;
       }
	//al añadir un nadador, debe comprobar si ese nadado ya ha sido añadido anteriormente.
       //Que devuelva una excepción DataException con el mensaje 
       public void darDeAltaNadador(String nombre, String fechaNacimiento, String pais, boolean masculino)throws DataException{
		
            String[] s= fechaNacimiento.split("-");
                //busca si hay otro nadador con ese nombre, se le pueden meter mas parametros, pero creo que asi valdria
                if (hayNadador(nombre)) throw new DataException("Ya existe el nadador.");
                else{
                    Fecha fecha= new Fecha(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
                    ArrayList<Estilo> estilos=new ArrayList<Estilo>();
                    Pais p= new Pais(pais);
                    ArrayList<Marca> marca= new ArrayList<Marca>();
                    Nadador nadador = new Nadador(nombre, fecha, estilos, p, marca, masculino);
                    this.nadadores.add(nadador);
                }                   
            //Aquí debe ir una estructura try-catch ya que si lo que se le pasa es un string y no un número lanza una excepción quue no está controlada.
                 
            //añadir la nacionalidad al arrayList de paises
                   Iterator<String>  it=paises.iterator();
                   boolean encontrado=false;
            //ver si esta el pais ya añadido
                   while(it.hasNext()&&!encontrado){
                        if (it.next().contentEquals(pais)) encontrado=true;

                      }
            //si no esta añadido se añade
                   if(!encontrado){
                    
                      paises.add(pais);
                      
                    }

                 
       }

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void darDeBajaNadador(String nombre){
            Iterator<Nadador> it=this.nadadores.iterator();
            boolean borrado=false;
            while(it.hasNext()&& !borrado){
                Nadador n=it.next();
                if (n.getNombre().equalsIgnoreCase(nombre))
                    it.remove();    
            }
		// end-user-code
	}
        
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
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
            
            if(nad == null) throw new DataException("No hay correspondencia con el nombre introducido.");
           
            return nad;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorEstilo(String e) throws DataException {
            Estilo estilo= parseEstilos(e);
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getEstilos().contains((Estilo) estilo)){
                    auxNadadores.add(n);
                }
                
            }
            
            if(auxNadadores.isEmpty()) throw new DataException("No se han encontrado nadadores asociados al estilo introducido.");
       
            
            return auxNadadores;
        }
        public ArrayList<Nadador> buscarNadadoresPorNombre(String nombre) throws DataException{
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getNombre().contains(nombre)){
                    auxNadadores.add(n);
                }
            }
            if(auxNadadores.isEmpty()) throw new DataException("No se han encontrado nadadores asociados al nombre introducido.");
            return auxNadadores;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorMarca(int distancia,String e) throws DataException{
            Estilo estilo=parseEstilos(e);
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                Iterator<Marca> marc=n.getMarcas().iterator();
                while(marc.hasNext()){
                    Marca m = marc.next();
                    if ((m.getDistancia()==distancia) && (m.getEstilo()==estilo)){
                        auxNadadores.add(n);
                    }
                }
            }
            if(auxNadadores.isEmpty()) throw new DataException("No se han encontrado nadadores asociados a la marca introducida.");
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
        
        public ArrayList<Nadador> buscarNadadoresPorSexo(String sexo)throws DataException{
        
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.toStringSexo().equalsIgnoreCase(sexo))
                    auxNadadores.add(n);
            }
            if (auxNadadores.isEmpty()) throw new DataException("No se han encontrado nadadores de ese sexo");
            return auxNadadores;
        }
        
        //Metodo de la version r129
        public ArrayList<Nadador> buscarNadadoresPorRecord(String m)throws DataException{
            ArrayList<Nadador> record = new ArrayList<Nadador>();
            Iterator<Nadador> it =  this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if(n.getRecord()!=null){
                if (n.getRecord().getTiempo().toString().equalsIgnoreCase(m)){
                    record.add(n);
                }
             }
            }    
            if (record.isEmpty()) throw new DataException("No se han encontrado nadadores de ese record");
            return record;
        }
        
        //Metodo de la version r128
        /*public ArrayList<Nadador> buscarNadadoresPorRecord(Marca m)throws DataException{
            ArrayList<Nadador> record = new ArrayList<Nadador>();
            Iterator<Nadador> it =  this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if ((n.getRecord().getTiempo().getMinutos() == m.getTiempo().getMinutos())
                    && (n.getRecord().getTiempo().getSegundos() == m.getTiempo().getSegundos())
                    &&(n.getRecord().getTiempo().getMilesimas() == m.getTiempo().getMilesimas())){
                    record.add(n);
                }
            }
            if (record.isEmpty()) throw new DataException("No se han encontrado nadadores de ese sexo");
            return record;
        }*/
        
        // devuelve 0 si se ha añadido bien
        //          1 si el nadador no existe
        //          2 si el formato de la marca no es correcto
        //          3 si el formato de la fecha no es correcto
	
          public int anadirMarcaNadador(String nombre, String marca, String fecha,
                                      int distancia, Estilo estilo) throws DataException{

           try{
               Nadador nadador=buscarNadadorPorNombre(nombre);
           
            //  if (nadador==null) return 1;
            String[] auxMarca = marca.split(":");
          //  if (auxMarca.length!=3) return 2;
            String[] auxfecha = fecha.split("-");
         //  if (auxfecha.length!=3) return 3;
            Marca m = new Marca(Integer.parseInt(auxfecha[0]),Integer.parseInt(auxfecha[1]),
                                Integer.parseInt(auxfecha[2]),Integer.parseInt(auxMarca[0]),
                                Integer.parseInt(auxMarca[1]),Integer.parseInt(auxMarca[2]),
                                distancia, estilo);
            nadador.addMarca(m);
            //añadir el estilo de la marca a los estilos el nadador si no esta
            
          
            Iterator<Estilo>  it=nadador.getEstilos().iterator();
            boolean encontrado=false;
            //ver si esta el estilo ya añadido
            while(it.hasNext()&&!encontrado){
                if (it.next()==estilo) encontrado=true;
               
             }
            //si no esta añadido se añade
            if(!encontrado){
                ArrayList<Estilo>estilosAux=nadador.getEstilos();
                estilosAux.add(estilo);
                nadador.setEstilo(estilosAux);
            }
            
           }
           
           catch(DataException e){
               System.out.println(e.getMessage());
           }
           
                return 0;
        }       // end-user-code
        
        
        
	public void eliminarMarcaNadador(Marca m, Nadador n) throws DataException{
         
            if(n!=null || m!=null){
                if(hayNadador(n)){
                       ArrayList<Marca> marcasNadadores=n.getMarcas();
                       int pos = n.getPosicionMarca(m);
                       if(pos!=-1){
                            marcasNadadores.remove(pos);
                            n.setMarcas(marcasNadadores);
                            //ahora hay que actualizar el record
                            if (n.getMarcas().isEmpty()) n.setRecord(null);
                            else n.actualizaMarca(n);
                            //ahora se actualiza el estilo
                           Iterator<Marca>  it=n.getMarcas().iterator();
                           boolean encontrado=false;
                           //buscar si hay otras marcas con ese estilo
                           while(it.hasNext()&&!encontrado){
                               if(it.next().getEstilo()== m.getEstilo())
                                  encontrado=true; 
                           }
                           //si no las hay borrar el estilo de la lista de estilos
                           if(!encontrado){
                                ArrayList<Estilo>estilosAux=n.getEstilos();
                               for(int i=0;i<estilosAux.size();i++){
                                   if(estilosAux.get(i)==m.getEstilo())
                                       estilosAux.remove(i);
                               }
                               n.setEstilo(estilosAux); 
                           }
                        }
                        else throw new DataException("No existe esa marca");
                  
                 }
                else throw new DataException("No está el nadador");
            }
            else throw new DataException("El nadador o la marca introducidos no son válidos");
                  
       }


	public String verInformacionNadador(Nadador n) {
            String labelNombre = "Nombre: ";
            String labelFN = "Fecha de nacimiento: ";
            String labelPais = "País: ";
            String labelEstilos = "Estilos: ";
            String labelMarcas = "Marcas: ";
            String labelPalmares = "Títulos: ";
            
            String s1 = n.getNombre();
            String s2 = n.getFecha().toString();
            String s3 = n.getPais().toString();
            String s4 = "";
            String s6 = "";
            String s7 = "";
            String resultado ;
            for(int i = 0; i < n.getEstilos().size(); i++) 
                s4 = s4 + n.getEstilos().get(i).name() + LINE_SEPARATOR;
            
            for(int i = 0; i < n.getMarcas().size(); i++)
                s6 = s6 + n.getMarcas().get(i).toString()+ LINE_SEPARATOR;            
            
            resultado = labelNombre + s1 + LINE_SEPARATOR + 
                    labelFN + s2 + LINE_SEPARATOR + labelPais + s3 + LINE_SEPARATOR +
                    labelEstilos + s4 + LINE_SEPARATOR + labelMarcas + s6 + LINE_SEPARATOR + 
                    labelPalmares + s7 + LINE_SEPARATOR;
            
            return resultado;
            
        }
	
	public void compararMarcas(Marca marca, Marca marca2) throws DataException{
            if(marca != null && marca2!=null)
		System.out.println(marca.toString()+ marca2.toString());
            else throw new DataException("Alguna de las marcas introducidas o ambas no son correctas.");
	}
        
        public ArrayList<Nadador> getNadadores(){
            return nadadores;
        }

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
        
        public void saveToFile() throws IOException{
            saveToFile(ficheroActual);  // Solo llamado en el boton Guardar.
        }
        
        //-- Le entra al método un string con el nombre del archivo
	public void saveToFile(File file) throws IOException {
          
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("El fichero se ha creado correctamente");
                } 
                else {
                    System.out.println("No ha podido ser creado el fichero");
                }
            }


            /*la clave de activar o no la sobreescritura esta en FileOutputStream(file, true) si le ponemos en true entonces agregas al final de la linea */
            
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            Iterator<Nadador> it=this.nadadores.iterator(); 
            out.write("/*inif*/"+LINE_SEPARATOR);
            while(it.hasNext()){
                Nadador n=it.next();
                out.write(n.saveToString());
            }
            out.write("/*endf*/");
            out.close();
	}


	public void loadFromFile(File f) throws DataException, FileNotFoundException, UnsupportedEncodingException, IOException {
		// begin-user-code
		// TODO Ap?ndice de m?todo generado autom?ticamente
            this.nadadores.clear();
            BufferedReader reader = new BufferedReader(new FileReader(f));
            this.ficheroActual = f;
            String s;
            String tmp[];
            s=reader.readLine();
            if (!s.equalsIgnoreCase("/*inif*/"))throw new DataException("Error en el formato del archivo");
            s=reader.readLine();
            while(!s.equalsIgnoreCase("/*endf*/")){
                if (!s.equalsIgnoreCase("/*nadador*/")) throw new DataException("Error en el formato del archivo");
                s=reader.readLine();
                tmp=s.split("%");
                if (tmp.length!=4) throw new DataException("Error en el formato del archivo");
                this.darDeAltaNadador(tmp[0], tmp[1], tmp[2], Boolean.parseBoolean(tmp[3]));
                s=reader.readLine();
                if (s.equalsIgnoreCase("/*marcas*/")){
                    s=reader.readLine();
                    while (!s.equalsIgnoreCase("/*finmarcas*/")){
                        tmp=s.split("%");
                        if (tmp.length!=5) throw new DataException("Error en el formato del archivo");
                        this.anadirMarcaNadador(tmp[0], tmp[1], tmp[2],
                                Integer.parseInt(tmp[3]), this.parseEstilos(tmp[4]));
                        s=reader.readLine();
                    }
                }
                if(!s.equalsIgnoreCase("/*finnadador*/")){
                s=reader.readLine();
                if(!s.equalsIgnoreCase("/*endf*/")){
                  if (!s.equalsIgnoreCase("/*finnadador*/")) throw new DataException("Error en el formato del archivo");
                  s=reader.readLine();
                }  
            }
                else  s=reader.readLine();
            }    
            // end-user-code
	}
        
        //Metodo que reune los datos de un nadador
        public ArrayList<String> datosNadador(Nadador n){
            ArrayList<String> datos = new ArrayList<String>();
            //Nombre
            datos.add("Nombre: " + n.getNombre());
            //Sexo
            datos.add("Sexo: "+n.toStringSexo());
            //Fecha de Nacimiento
            datos.add("Fecha de nacimiento: " + n.getFecha().toString());
            //Edad
            datos.add("Edad :" + n.getEdad() + "años.");
            //Pais
            datos.add("País" + n.getPais());
            //Estilos
            datos.add("Estilos" + n.toStringEstilos());
            //Record
            if(n.getRecord()!=null){
                datos.add("Mejor marca: " + n.getRecord().toString());
                //Marcas que no sean el record
                ArrayList<Marca> auxMarcas = n.getMarcas();
                Iterator<Marca> it=auxMarcas.iterator();
                String s="";
                while(it.hasNext()){
                    Marca m=it.next();
                    if (n.getRecord()==m){
                        s+=m.toString();
                    }
                }
                datos.add(s);
            }
            else{
                datos.add("Mejor marca: No tiene marcas.");
            }
            return datos;
        }
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
        
        public boolean hayNadador(Nadador nadador) throws DataException{
            boolean encontrado = false;
            int i=0;
            
            while(i<this.nadadores.size() && !encontrado){
                encontrado = this.nadadores.get(i)== nadador;
                i++;
            }
            
            if (!encontrado) throw new DataException ("No existe el nadador.");
            return encontrado;
        }
        
            
}