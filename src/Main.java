import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner (System.in);
			boolean sonIguales=false;
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			System.out.print("Introduzca la password: ");
			byte[] pwdByte = sc.nextLine().getBytes();
			md.update(pwdByte);

			byte[] resumenPwd = md.digest(); //Aqui sacamos el resumen
			do {
				System.out.print("Repetir password: ");
				pwdByte = sc.nextLine().getBytes();
				md.reset();
				
				md.update(pwdByte); //Volvemos a meter la contraseña
				
				//6 - Calcula el resumen
				byte[] resumenPwdRepetir =  md.digest();
				
				sonIguales = Arrays.equals(resumenPwd,resumenPwdRepetir);
				if (!sonIguales) {
					System.out.println("Password incorrecta");
				}
			} while (!sonIguales);
			System.out.println("Fin del programa");
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}