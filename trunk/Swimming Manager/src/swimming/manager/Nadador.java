package swimming.manager;

/**
 * 
 */

import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Nadador {
	
	private String nombre;
	
	private Fecha fechaNacimiento;
	
	private Estilo[] estilos = new Estilo[20];
	
	private Pais pais;
	
	private Titulo[] palmares = new Titulo[50];
	
	private Marca[] marcas = new Marca[10];
        
	public Nadador() {
		// begin-user-code
		// TODO Ap�ndice de constructor generado autom�ticamente
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param nombre
	 * @param fechaNacimiento
	 * @param estilos
	 * @param pais
	 * @param palmares
	 * @param marcas
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Nadador(String nombre, Fecha fechaNacimiento, Set<Estilo> estilos,
			Pais pais, Set<Titulo> palmares, Marca... marcas) {
		// begin-user-code
		// TODO Ap�ndice de constructor generado autom�ticamente
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Nadador getNadador() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param nombre
	 * @param marcas
	 * @param fechaNacimiento
	 * @param estilos
	 * @param pais
	 * @param palmares
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNadador(String nombre, Set<Marca> marcas,
			Fecha fechaNacimiento, Set<Estilo> estilos, Pais pais,
			Titulo... palmares) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String toString() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}
}