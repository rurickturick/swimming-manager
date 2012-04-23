package swimming.manager;
public class Marca {
	
	private Fecha fecha;
	private Tiempo tiempo;
	private int distancia;
        private Estilo estilo;


	public Marca(Fecha fecha, Tiempo tiempo, int distancia, Estilo estilo) {
            this.fecha = fecha;
            this.tiempo = tiempo;
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
            
            String resultado = s1 + " " + s2 + " " + s3 + " " + s4;
            return resultado;
	}
                
         
}