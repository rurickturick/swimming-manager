package swimming.manager;

/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Titulo {
	
	private String descripcion;
	
	private Medalla medalla;
	
	private Marca marca;


	public Titulo() {
		this.descripcion = "";
                this.medalla=null;
                this.marca=new Marca();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param descripcion
	 * @param medalla
	 * @param marca
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Titulo(String descripcion, Medalla medalla, Marca marca) {
		this.descripcion = descripcion;
                this.medalla=medalla;
                this.marca = marca;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param descripcion
	 * @param medalla
	 * @param marca
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setTitulo(String descripcion, Medalla medalla, Marca marca) {
		this.descripcion = descripcion;
                this.medalla=medalla;
                this.marca = marca;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String toString() {
		String s="";
                s = descripcion + medalla.name() + marca.toString();
		return s;
		// end-user-code
	}
        
        public String getDescripcion(){
            return this.descripcion;
        }
        
        public void setDescripcion(String desc){
            descripcion=desc;
        }
        
        public Medalla getMedalla(){
            return this.medalla;
        }
        
        public void setMedalla(Medalla medalla){
            this.medalla=medalla;
        }
        
        public Marca getMarca(){
            return this.marca;
        }
        
        public void setMarca(Marca marca){
            this.marca = marca;
        }
}