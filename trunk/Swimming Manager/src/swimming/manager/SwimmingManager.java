package swimming.manager;

//import java.util.Date;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.*;

public class SwimmingManager {
	
	private ArrayList<Nadador> nadadores;
        public static final String LINE_SEPARATOR = System.getProperty("line.separator");
        
        /** Metodo que se usa para generar un array list de estilos a partir de un String **/
        
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

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void darDeAltaNadador(String Nombre,String fechaNacimiento,String estilos,
                                    String pais) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		// end-user-code
            String[] s= fechaNacimiento.split("-");
            Fecha fecha= new Fecha(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
            s=estilos.split(" ");
            ArrayList<Estilo> estilosParsed=this.parseEstilos(s);
            s=pais.split(" ");
            Pais p= new Pais(s[0], s[1]);
            ArrayList<Titulo> palmares=new ArrayList<Titulo>();
            ArrayList<Marca> marca= new ArrayList<Marca>();
            Nadador nadador=new Nadador(Nombre, fecha, estilosParsed, p, palmares, marca);
            this.nadadores.add(nadador);
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void darDeBajaNadador(String nombre) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getNombre().equalsIgnoreCase(nombre)){
                    it.remove();
                    return;
                }
            }
		// end-user-code
	}
        
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
        public Nadador buscarNadadorPorNombre(String nombre){
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getNombre().equalsIgnoreCase(nombre)){
                    return n;
                }
            }
            return null;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorEstilo(String e){
            Estilo estilo= parseEstilos(e);
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getEstilos().contains((Estilo) estilo)){
                    auxNadadores.add(n);
                }
            }
            return auxNadadores;
        }
        public ArrayList<Nadador> buscarNadadoresPorNombre(String nombre){
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getNombre().contains(nombre)){
                    auxNadadores.add(n);
                }
            }
            return auxNadadores;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorMarca(int distancia,String e){
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
            return auxNadadores;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorPais(String pais){
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getPais().getPais().equalsIgnoreCase(pais)){
                    auxNadadores.add(n);
                }
            }
            return auxNadadores;
        }
        
        public ArrayList<Nadador> buscarNadadoresPorEdad(int edad){
            ArrayList<Nadador> auxNadadores = new ArrayList<Nadador>();
            Iterator<Nadador> it=this.nadadores.iterator();
            Date now= new Date();
            int anyoActual = now.getYear()+1900;
            while(it.hasNext()){
                Nadador n=it.next();
                if (anyoActual-n.getFecha().getAnyo()==edad){
                    auxNadadores.add(n);
                }
            }
            return auxNadadores;
        }
        // devuelve 0 si se ha añadido bien
        //          1 si el nadador no existe
        //          2 si el formato de la marca no es correcto
        //          3 si el formato de la fecha no es correcto
	public int anadirMarcaNadador(String nombre, String marca, String fecha,
                                      int distancia, Estilo estilo){
	
            Nadador nadador=buscarNadadorPorNombre(nombre);
            if (nadador==null) return 1;
            String[] auxMarca = marca.split(" ");
            if (auxMarca.length!=5) return 2;
            String[] auxfecha = fecha.split("-");
            if (auxfecha.length!=3) return 3;
            Marca m = new Marca(Integer.parseInt(auxfecha[0]),Integer.parseInt(auxfecha[1]),
                                Integer.parseInt(auxfecha[2]),Integer.parseInt(auxMarca[0]),
                                Integer.parseInt(auxMarca[1]),Integer.parseInt(auxMarca[2]),
                                Integer.parseInt(auxMarca[3]),Integer.parseInt(auxMarca[4]),
                                distancia, estilo);
            nadador.addMarca(m);
            return 0;
		// end-user-code
	}
        
        
	public void eliminarMarcaNadador(Marca m, Nadador n) throws Exception{
         
            if(n!=null || m!=null){
                if(hayNadador(n)){
                       ArrayList<Marca> marcasNadadores=n.getMarcas();
                       int pos = n.getPosicionMarca(m);
                       if(pos!=-1){
                            marcasNadadores.remove(pos);
                            n.setMarcas(marcasNadadores);
                        }
                        else throw new Exception("No existe esa marca");
                  
                 }
                else throw new Exception("No está el nadador");
            }
            else throw new Exception("El nadador o la marca introducidos no son válidos");
                  
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
	
	public void compararMarcas(Marca marca, Marca marca2) {
		System.out.println(marca.toString()+ marca2.toString());
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void saveToFile() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void loadFromFile() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void verLista() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
        
        public boolean hayNadador(Nadador nadador) {
            boolean encontrado = false;
            int i=0;
            
            while(i<this.nadadores.size() && !encontrado){
                encontrado = this.nadadores.get(i)== nadador;
                i++;
            }
            return encontrado;
        }
        
            
}