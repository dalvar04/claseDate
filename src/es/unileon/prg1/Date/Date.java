package es.unileon.prg1.Date;

import java.util.Random;
import java.util.Scanner;

public class Date {

private static String[] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septimebre","Octubre","Noviembre","Diciembre"};
	
	public static void main(String[] args) {
		Scanner leeDia=new Scanner(System.in);
		Scanner leeMes=new Scanner(System.in);
		Scanner leeAnio=new Scanner(System.in);
		Scanner leeOtroDia=new Scanner(System.in);
		Scanner leeOtroMes=new Scanner(System.in);
		Scanner leeOtroAnio=new Scanner(System.in);
		System.out.println("Dia: ");
		int dia=leeDia.nextInt();
		System.out.println("Mes: ");
		int mes=leeMes.nextInt();
		System.out.println("Año: ");
		int anio=leeAnio.nextInt();
		while(dia<1 || dia>31){
			System.out.println("Dia mal introducido,introduzca bien el dia: ");
			dia=leeDia.nextInt();
		}

		while(mes<1 || mes>12){
			System.out.println("Mes mal introducido,introduzca bien el mes: ");
			mes=leeMes.nextInt();
		}
		
		System.out.println("Otro Dia: ");
		int otroDia=leeDia.nextInt();
		System.out.println("Otro Mes: ");
		int otroMes=leeMes.nextInt();
		System.out.println("Año: ");
		int otroAnio=leeAnio.nextInt();
		while(otroDia<1 || otroDia>31){
			System.out.println("Dia auxiliar mal introducido,introduzca bien el dia: ");
			otroDia=leeOtroDia.nextInt();
		}

		while(mes<1 || mes>12){
			System.out.println("Mes auxiliar mal introducido,introduzca bien el mes: ");
			otroMes=leeOtroMes.nextInt();
		}

		imprimeMes(mes);
		compruebaDia(dia,mes,anio);
		estacion(dia,mes);
		cuantoFaltaFinAnio(dia,mes);
		imprimeUnDia();
		imprimeDiasFinMes(dia,mes,anio);
		imprimeMismosDias(dia,mes);
		cuentaDiasDesdeInicio(dia,mes);
		fechaAleatoriaWhile(dia,mes);
		fechaAleatoriaDoWhile(dia,mes);
		diaDeLaSemana(dia,mes);
		isSameYear(anio, otroAnio);
		isSameMonth(mes, otroMes);
		isSameDay(dia,otroDia);
		isSame(dia,mes,anio,otroDia,otroMes,otroAnio);

	}


	private static boolean isSame(int dia, int mes, int anio, int otroDia, int otroMes, int otroAnio) {
		boolean t=true;
		if(dia!=otroDia || mes!=otroMes || anio!=otroAnio)t=false;
		System.out.println("Misma fecha: "+t);
		System.out.println("--------------------------");
		return t;
	}


	private static boolean isSameDay(int dia, int otroDia) {
		boolean d=true;
		if(dia!=otroDia)d=false;
		System.out.println("Mismo dia: "+d);
		System.out.println("--------------------------");
		return d;

	}


	private static boolean isSameMonth(int mes,int otroMes) {
		boolean m=true;
		if(mes!=otroMes)m=false;
		System.out.println("Mismo mes: "+m);
		System.out.println("--------------------------");
		return m;

	}


	private static boolean isSameYear(int anio,int otroAnio) {
		boolean a=true;
		if(anio!=otroAnio)a=false;
		System.out.println("Mismo año: "+a);
		System.out.println("--------------------------");
		return a;

	}


	private static void diaDeLaSemana(int dia, int mes) {
		boolean correcto=false;
		String[] dias={"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
		int[] diasAux = new int [7];
		int pos=0;
		int cantidad=cuentaDiasDesdeInicio(dia, mes);
		Scanner lectura = new Scanner(System.in);
		System.out.println("Introduce el dia del 1 de enero: ");
		String diaS = lectura.next();
		diaS=diaS.toLowerCase();
		for (int i = 0; i < dias.length; i++) {
			if(diaS.equals(dias[i])){
				pos=i;
				correcto=true;
			}
		}
		
		for (int i = 0; i < diasAux.length; i++) {
			diasAux[i]=(pos+i)%7;
		}
		cantidad=cantidad%7;
		if(correcto==true)System.out.println("El dia "+dia+" de "+meses[mes-1]+" cae en "+dias[cantidad-1]);
		else System.out.println("El dia no es correcto");
		System.out.println("--------------------------");

	}

	private static void fechaAleatoriaDoWhile(int dia, int mes) {
		Random aleatorio = new Random();
		int diaRandom=aleatorio.nextInt(31)+1;
		int mesRandom=aleatorio.nextInt(12)+1;
		int contador=0;
		do{
			diaRandom=aleatorio.nextInt(31)+1;
			mesRandom=aleatorio.nextInt(12)+1;
			contador++;
		}while(diaRandom!=dia || mesRandom!=mes);
		System.out.println(contador+ " intentos para conseguir el dia "+dia+ " de "+meses[mes-1]);
		System.out.println("--------------------------");

	}

	private static void fechaAleatoriaWhile(int dia, int mes) {
		Random aleatorio = new Random();
		int diaRandom=aleatorio.nextInt(31)+1;
		int mesRandom=aleatorio.nextInt(12)+1;
		int contador=0;
		while(diaRandom!=dia || mesRandom!=mes){
			diaRandom=aleatorio.nextInt(31)+1;
			mesRandom=aleatorio.nextInt(12)+1;
			contador++;
		}
		System.out.println(contador+ " intentos para conseguir el dia "+dia+ " de "+meses[mes-1]);
		System.out.println("--------------------------");
	}

	private static int cuentaDiasDesdeInicio(int dia, int mes) {
		int[] diasMes={31,28,31,30,31,30,31,31,30,31,30,31};
		int suma=0;
		for (int i = 0; i < mes-1; i++) {
			suma+=diasMes[i];	
		}
		suma=suma+dia;
		System.out.println(suma+" días desde el 1 de enero");
		System.out.println("--------------------------");
		return suma;
	}

	private static void imprimeMismosDias(int dia, int mes) {
		int[] diasMes={31,28,31,30,31,30,31,31,30,31,30,31};
		for (int i = 0; i < meses.length; i++) {
			if(diasMes[i]==diasMes[mes-1] && i!=mes-1)
				System.out.println(meses[i]);
		}
		System.out.println("--------------------------");
	}

	private static void imprimeUnDia() {
		Random aleatorio=new Random();
		int dia = aleatorio.nextInt(31)+1;
		int mes= aleatorio.nextInt(12)+1;
		boolean correcto=compruebaDia(dia, mes, 2014);
		if(correcto==false)imprimeUnDia();
		System.out.println(dia+" de "+meses[mes-1]);
		System.out.println("--------------------------");

	}

	private static void imprimeDiasFinMes(int dia, int mes, int anio) {
		int[] diasMes={31,28,31,30,31,30,31,31,30,31,30,31};
		if(anio%4==0)diasMes[1]=29;
		for (int i = dia; i <= diasMes[mes-1]; i++) {
			System.out.println(i + " de "+meses[mes-1]);
		}
		System.out.println("--------------------------");
	}

	private static void cuantoFaltaFinAnio(int dia, int mes) {
		System.out.println("Hasta fin de año quedan "+(12-mes)+" meses completos");
		System.out.println("--------------------------");

	}

	private static void estacion(int dia, int mes) {
		if(mes==1 || mes==2)System.out.println("Invierno");
		if(mes==4 || mes==5)System.out.println("Primavera");
		if(mes==7 || mes==8)System.out.println("Verano");
		if(mes==10 || mes==11)System.out.println("Otoño");
		if(mes==3 && dia<21)System.out.println("Invierno");
		if(mes==3 && dia>20)System.out.println("Primavera");
		if(mes==6 && dia<21)System.out.println("Primavera");
		if(mes==6 && dia>20)System.out.println("Verano");
		if(mes==9 && dia<21)System.out.println("Verano");
		if(mes==9 && dia>20)System.out.println("Otoño");
		if(mes==12 && dia<21)System.out.println("Otoño");
		if(mes==12 && dia>20)System.out.println("Invierno");
		System.out.println("--------------------------");
	}


	private static boolean compruebaDia(int dia, int mes, int anio) {
		boolean correcto=true;
		if((mes==2 && dia>30) || (mes==2 && dia>29 && anio%4!=0)){
			correcto=false;
		}
		if((mes==4 || mes==6 || mes==9 || mes==11)&& dia>30)correcto=false; 
		if(correcto==false)System.out.println("El dia esta mal introducido");
		else System.out.println("El dia es correcto");
		System.out.println("--------------------------");
		return correcto;
	}

	private static void imprimeMes(int mes) {
		System.out.println("Mes: "+meses[mes-1]);
		System.out.println("--------------------------");
	}


}
