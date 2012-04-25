package swimming.manager;

public class Fecha {
	private int dia;
	private int mes;
	private int anyo;
	
        public Fecha(){
            dia=1;
            mes=1;
            anyo = 1990;
        }
        
        public Fecha(int x, int y, int z){
		dia = x;
		mes = y;
		anyo = z;
	}
	public int getDia(){
		return dia;
	}
	public void setDia(int x){
		dia = x;
	}
    @Override
	public String toString(){
		return "La fecha es "+dia+"/"+mes+"/"+anyo;
	}
	
	public void sumarDias(int x){
		int [] meses = new int[12];
		meses[0]=31;
		meses[1]=28;
		meses[2]=31;
		meses[3]=30;
		meses[4]=31;
		meses[5]=30;
		meses[6]=31;
		meses[7]=31;
		meses[8]=30;
		meses[9]=31;
		meses[10]=30;
		meses[11]=31;
		
		for(int i=0;i<x;i++){
			if( dia<meses[mes-1] || ((mes==2)&&esBisiesto())&&(dia<29) ) dia++;
			else{
				dia = 1;
				if(mes==12){
					mes=1;
					anyo++;
				}
				else mes++;
			}
		}
	}
	
	public boolean esBisiesto(){
		return ((anyo%4==0)&&(!(anyo%100==0) || (anyo%400==0)));
	}
        
        public int getMes(){
		return mes;
	}
        
        public int getAnyo(){
            return anyo;
        }
        
        
}