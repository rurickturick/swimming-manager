package swimming.manager;

public class Tiempo {
	
	private int horas;
	
	private int minutos;
	
	private int segundos;
	
	private int decimas;
	
	private int centesimas;

	public Tiempo() {
            this.horas=0;
            this.minutos=0;
            this.segundos=0;
            this.decimas=0;
            this.centesimas=0;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param inthoras
	 * @param _int
	 * @param minutos
	 * @param intsegudos
	 * @param intdecimas
	 * @param intcentesimas
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Tiempo(int inthoras, int minutos,
			int intsegudos, int intdecimas, int intcentesimas) {
            this.horas=inthoras;
            this.minutos=minutos;
            this.segundos=intsegudos;
            this.decimas=intdecimas;
            this.centesimas=intcentesimas;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param inthoras
	 * @param _int
	 * @param minutos
	 * @param intsegudos
	 * @param intdecimas
	 * @param intcentesimas
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setTiempo(int inthoras, int minutos,
			int intsegudos, int intdecimas, int intcentesimas) {
            this.horas=inthoras;
            this.minutos=minutos;
            this.segundos=intsegudos;
            this.decimas=intdecimas;
            this.centesimas=intcentesimas;
	}
}