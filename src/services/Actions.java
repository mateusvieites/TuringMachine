package services;

public class Actions {
	public static int isInt(String i) {
		try{
            int aux = Integer.parseInt(i);
            return aux;
        }catch(Exception e){
            return -1;
        }
	}
}
