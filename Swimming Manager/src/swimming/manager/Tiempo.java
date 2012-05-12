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
            this.segundos=00;
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
        
        public int getHoras(){
            return this.horas;
        }
        
        public void setHoras(int horas){
            this.horas = horas;
        }
        
        public int getMinutos(){
            return this.minutos;
        }
        
        public void setMinutos(int minutos){
            this.minutos = minutos;
        }
        
        public int getSegundos(){
            return this.segundos;
        }
        
        public void setSegundos(int segundos){
            this.segundos = segundos;
        }
        
        public int getDecimas(){
            return this.decimas;
        }
        
        public void setDecimas(int decimas){
            this.decimas = decimas;
        }
        
        public int getCentesimas(){
            return this.centesimas;
        }
        
        public void setCentesimas(int centesimas){
            this.centesimas = centesimas;
        }
        
        
         // devuelve true si a es mayor que b
         //          false si b es mayor o igual a a
        public boolean compara(Tiempo a){
            if (a.getHoras() > this.getHoras())
                return true;
            if (a.getMinutos() > this.getMinutos())
                return true;
            if (a.getSegundos() > this.getSegundos())
                return true;
            if (a.getDecimas() > this.getDecimas())
                return true;
            if (a.getCentesimas() > this.getCentesimas())
                return true;
            return false;
        }
        
        public String saveToString(){
            String s=""+this.horas+" "+
                        this.minutos+" "+
                        this.segundos+" "+
                        this.decimas+" "+
                        this.centesimas;
            return s;
        }
        

         public String toString() {
            String s1= ""+this.horas;
            String s2= ""+this.minutos;
            String s3= ""+this.segundos;
            String s4= ""+this.decimas;
            String s5= ""+this.centesimas;
            
            String resultado = s1 + ":" + s2 + ":" + s3 + ":" + s4 + ":" + s5;
            return resultado;
	}
}