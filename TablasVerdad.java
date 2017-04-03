import java.util.Scanner;

/**
*@author: Rodriguez Garcia Dulce Coral Prebe 9
*@author: Quiñones Rivera Josué Emanuel Prebe 3
*Clase que calcula las tablas de verdad correspondientes a una proposicion logica
**/
public class TablasVerdad{

	/**
	*Metodo main, aqui se recibe la proposicion logica
	**/
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Ingresa tu proposicion logica:");
		operacion(sc.nextLine());
}
	/**
	*@param args recibe la cadena de main
	*En este metodo se calculan las tablas de verdad necesaria para la proposicion recibida
	**/
	public static void operacion(String args){

		int abre = 0;
		int cierra = 0;

		for(int i = 0; i < args.length()-1; i++){
			//args.charAt(i);
			switch(args.charAt(i)){
				case 'v':
					if(abre == 0 && cierra == 0)
					disyuncion(args.substring(i-1,i),args.substring(i+1));
					else{
						disyuncion(args.substring(abre+1,cierra),args.substring(i+1));
					}
					System.out.println(i);
					System.out.println(abre);
					System.out.println(cierra);
				break;
				case '^':
					if(abre == cierra)
					conjuncion(args.substring(i-1,i),args.substring(i+1));
					else{
						conjuncion(args.substring(abre+1,cierra),args.substring(i+1));
					}
				break;
				case '7':
					if(abre == cierra)
					negacion(args.substring(i+1));
					else{
						negacion(args.substring(abre+1,cierra));
					}
				break;
				case '>':
					if(abre == cierra)
					implicacion(args.substring(i-2),args.substring(i+1));
					else{
						implicacion(args.substring(abre+1,cierra),args.substring(i+1));
					}
				break;
				case '<':
					if(abre == cierra){
					dobleImplicacion(args.substring(i-1),args.substring(i+3));
					i++;
					i++;
				}else{
					dobleImplicacion(args.substring(abre+1,cierra),args.substring(i+3));
					i++;
					i++;
				}
				break;
				case '(':
				boolean aux = false;
				int k;
				for(k = i; k < args.length(); k++){
					if(args.charAt(k) == ')')
						break;
				}
				for(int j = i; j < args.length(); j++){
					switch(args.charAt(j)){
						case 'v':
						disyuncion(args.substring(i+1,j),args.substring(j+1,k));
						aux = true;
						System.out.println(i + " " + j + " " + k);
						break;
						case '^':
						conjuncion(args.substring(i+1,j),args.substring(j+1,k));
						aux = true;
						break;
						case '7':
						negacion(args.substring(j+1,j+2));
						aux = true;
						break;
						case '>':
						implicacion(args.substring(i+1,j-1),args.substring(j+1,k));
						aux = true;
						break;
						case '<':
						dobleImplicacion(args.substring(i+1,j),args.substring(j+3,k));
						aux = true;
						j++;
						j++;
						break;
					}
					if(aux){
					abre = i;
					i = k;
					cierra = k;
					break;
					}
					}
				break;
				default:
				break;
			}
		}
	}

	/**
	*@param a es una cadena que contiene a la primer parte de la proposicion
	*@param b es una cadena que contiene a la segunda parte de la proposicion
	*Este metodo imprime la tabla para cuando es una disyuncion
	**/
	public static void disyuncion(String a, String b){
		System.out.println("-------------------");
		System.out.println("|  " + a + "  v  " + b + "  |");
		System.out.println("|------------------");
		System.out.println("|  T  v  T  |  T  |");
		System.out.println("|  T  v  F  |  T  |");
		System.out.println("|  F  v  T  |  T  |");
		System.out.println("|  F  v  F  |  F  |");
		System.out.println("-------------------");

	/**
	*@param a es una cadena que contiene a la primer parte de la proposicion
	*@param b es una cadena que contiene a la segunda parte de la proposicion
	*Este metodo imprime la tabla para cuando es una conjuncion
	**/
	}
	public static void conjuncion(String a, String b){
		System.out.println("-------------------");
		System.out.println("|  " + a + "  ^  " + b + "  |");
		System.out.println("|------------------");
		System.out.println("|  T  ^  T  |  T  |");
		System.out.println("|  T  ^  F  |  F  |");
		System.out.println("|  F  ^  T  |  F  |");
		System.out.println("|  F  ^  F  |  F  |");
		System.out.println("-------------------");
	}

	/**
	*@param a es una cadena que contiene al operando de la negacion
	*Este metodo imprime la tabla para cuando es una negacion
	**/
	public static void negacion(String a){
		System.out.println("---------------");
		System.out.println("|  7 " + a + "        |");
		System.out.println("|--------------");
		System.out.println("|  7 T  |  F  |");
		System.out.println("|  7 F  |  T  |");
		System.out.println("---------------");

	}

	/**
	*@param a es una cadena que contiene a la primer parte de la proposicion
	*@param b es una cadena que contiene a la segunda parte de la proposicion
	*Este metodo imprime la tabla para cuando es una implicacion
	**/
	public static void implicacion(String a, String b){
		System.out.println("--------------------");
		System.out.println("|  " + a + "  ->  " + b + "  |");
		System.out.println("|-------------------");
		System.out.println("|  T  ->  T  |  T  |");
		System.out.println("|  T  ->  F  |  F  |");
		System.out.println("|  F  ->  T  |  T  |");
		System.out.println("|  F  ->  F  |  T  |");
		System.out.println("--------------------");

	}

	/**
	*@param a es una cadena que contiene a la primer parte de la proposicion
	*@param b es una cadena que contiene a la segunda parte de la proposicion
	*Este metodo imprime la tabla para cuando es una doble implicacion
	**/
	public static void dobleImplicacion(String a, String b){
		System.out.println("---------------------");
		System.out.println("|  " + a + "  <->  " + b + "  |");
		System.out.println("|--------------------");
		System.out.println("|  T  <->  T  |  T  |");
		System.out.println("|  T  <->  F  |  F  |");
		System.out.println("|  F  <->  T  |  F  |");
		System.out.println("|  F  <->  F  |  T  |");
		System.out.println("---------------------");

	}

}