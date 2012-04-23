package swimming.manager;

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
	
       
	public Nadador(String nombre, Fecha fechaNacimiento, Estilo[] estilos,
			Pais pais, Titulo[] palmares, Marca[] marcas) {
            
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
            for(int i=0; i<this.estilos.length; i++) {
                s4= s4+ estilos[i].name();
            }
            
            for(int i=0; i<this.marcas.length; i++){
                s6= s6+ marcas[i].toString();
            }
            
            for(int i=0; i<this.palmares.length; i++){
                s7=s7 + palmares[i].toString();
            }
            
            String resultado = s1 + "\n" + s2 + "\n" + s3 + "\n" +
                               s4 + "\n" + s5 + "\n" + s6 + "\n" + s7;
            
            return resultado;            
	
	}
}