package swimming.manager;

public class Tiempo {
	
	
	
	private int minutos;
	
	private int segundos;
	
        private int milesimas;

	public Tiempo() {
           
            this.minutos=0;
            this.segundos=0;
            this.milesimas=0;
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
	public Tiempo( int minutos,int segudos, int milesimas) {
           
            this.minutos=minutos;
            this.segundos=segudos;
            this.milesimas=milesimas;
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
	public void setTiempo( int minutos, int intsegudos, int milesimas) {
          
            this.minutos=minutos;
            this.segundos=intsegudos;
           this.milesimas=milesimas;
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
        
       
        
        
         // devuelve true si a es menor que b
         //          false si b es menor o igual a a
        public boolean compara(Tiempo a){
            
            /*if (a.getMinutos() > this.getMinutos())
                return true;
            if (a.getSegundos() > this.getSegundos())
                return true;
            
            return false;*/
            if (a.minutos < this.minutos) return true;
            else if (a.minutos == this.minutos){
                if (a.segundos < this.segundos) return true;
                else if (a.segundos == this.segundos){
                    if (a.milesimas <= this.milesimas) return true;
                    else return false;
                }else return false;
            }else return false;
        }
        
        public String saveToString(){
            String s= this.minutos+":"+
                        this.segundos+":"+
                    this.milesimas;
            return s;
        }
        

         public String toString() {
            String s1= ""+this.minutos;
            String s2= ""+this.segundos;
            String s3=""+this.milesimas;       
            
            String resultado = s1 + ":" + s2 + ":" + s3;
            return resultado;
	}
}