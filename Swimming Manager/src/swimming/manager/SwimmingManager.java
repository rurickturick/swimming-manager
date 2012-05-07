package swimming.manager;

/**
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SwimmingManager {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ArrayList<Nadador> nadadores;
        
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
        private Nadador buscarNadador(String nombre){
            Iterator<Nadador> it=this.nadadores.iterator();
            while(it.hasNext()){
                Nadador n=it.next();
                if (n.getNombre().equalsIgnoreCase(nombre)){
                    return n;
                }
            }
            return null;
        }
        
        // devuelve 0 si se ha añadido bien
        //          1 si el nadador no existe
        //          2 si el formato de la marca no es correcto
        //          3 si el formato de la fecha no es correcto
	public int anadirMarcaNadador(String nombre, String marca, String fecha,
                                      int distancia, Estilo estilo){
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
            Nadador nadador=buscarNadador(nombre);
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

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void eliminarMarcaNadador() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void verInformacionNadador(Nadador n) {
            
            
            
		
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void buscarNadadores() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void compararMarcas() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
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
        
            
}