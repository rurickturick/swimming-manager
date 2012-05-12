package swimming.manager;

public class Pais {
	
	private String pais;
	
	private String ciudad;

	public Pais() {
		this.pais = "España";
                this.ciudad = "Madrid";
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param pais
	 * @param ciudad
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Pais(String pais, String ciudad) {
		this.pais = pais;
                this.ciudad = ciudad;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param pais
	 * @param ciudad
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setPais(String pais, String ciudad) {
		this.pais = pais;
                this.ciudad = ciudad;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String toString() {
		String s="";
                s=this.ciudad + ", " + this.pais;
		return s;
		// end-user-code
	}
        
        public String getPais (){
            return this.pais;
        }
        
        public void setPais(String pais){
            this.pais=pais;
        }
        
        public String getCiudad (){
            return this.ciudad;
        }
        
        public void setCiudad(String ciudad){
            this.ciudad=ciudad;
        }
}