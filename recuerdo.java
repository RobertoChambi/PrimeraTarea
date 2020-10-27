package Ejercicios;

public class recuerdo {

	public static void main(String[] args) {
		String CI="13312528";
		String dia="Jueves";
		String ultimo = CI.substring(CI.length()-1);
		System.out.println(ultimo);
		String res ="NO";
		switch (dia) {
		case "Lunes":
			if(ultimo == "1" || ultimo == "2")
				res = "SI";
			break;
		case "Martes":
			if(ultimo == "3" || ultimo == "4")
				res = "SI";
			break;
		case "Miercoles":
			if(ultimo == "5" || ultimo == "6")
				res = "SI";
			break;
		case "Jueves":
			if(ultimo.equals("7") || ultimo.equals("8"))
				res = "SI";
			break;
		case "Viernes":
			if(ultimo == "9" || ultimo == "9")
				res = "SI";
			break;
        default:
        	res = "NO";
            break;
		}
		System.out.println(res);
	}

}
