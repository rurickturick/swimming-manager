package swimming.manager;
public class Marca {
	
	private Fecha fecha;
	private Tiempo tiempo;
	private int distancia;
        private Estilo estilo;

        public Marca(){
            this.fecha = new Fecha();
            this.estilo = Estilo.Libre;
            tiempo=new Tiempo();
            distancia = 1000;
        }
        
	public Marca(int dia,int mes, int anyo, 
                    int minutos,int segundos ,int milesimas , int distancia, Estilo estilo) {
       
            Fecha f = new Fecha(dia, mes, anyo);
            Tiempo t= new Tiempo( minutos, segundos, milesimas);
            this.fecha = f;
            this.tiempo = t;
            this.distancia=distancia;
            this.estilo = estilo;
		
	}
        
        public void setFecha(Fecha fecha){
            this.fecha = fecha;
        }
        
        public Fecha getFecha() {
            return fecha;
        }
        
        public void setTiempo(Tiempo tiempo){
            this.tiempo = tiempo;
        }
        
        public Tiempo getTiempo() {
            return tiempo;
        }
        
        public void setDistancia(int distancia){
            this.distancia = distancia;
        }
        
        public int getDistancia() {
            return distancia;
        }
        
        public void setEstilo(Estilo estilo){
            this.estilo = estilo;
        }
        
        public Estilo getEstilo() {
            return estilo;
        }
        
        public String toString() {
            String s1= this.fecha.toString();
            String s2= this.tiempo.toString();
            String s3= ""+this.distancia;
            String s4= this.estilo.name();
            
            String resultado =" Fecha: " + s1 + " Tiempo: " + s2 + " Distancia: " + s3 + " Estilo: " + s4;
            return resultado;
	}
                
         
}