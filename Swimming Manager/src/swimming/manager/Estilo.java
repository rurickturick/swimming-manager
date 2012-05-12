package swimming.manager;

public enum Estilo{
	Libre, Espalda, Mariposa, Braza;
    public static Estilo getEstilo(String s)throws DataException {
        if(s.equalsIgnoreCase("libre")) return Libre;
        if(s.equalsIgnoreCase("Espalda")) return Espalda;
        if(s.equalsIgnoreCase("Mariposa")) return Mariposa;
        if(s.equalsIgnoreCase("Braza")) return Braza;
        throw new DataException("Estilo erróneo");
    } 
}