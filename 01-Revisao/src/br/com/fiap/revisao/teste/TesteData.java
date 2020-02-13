package br.com.fiap.revisao.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteData {

	public static void main(String[] args) {
		//Obter um objeto Calendar com a data atual
		Calendar hoje = Calendar.getInstance();
		Calendar carnaval = new GregorianCalendar(2020,Calendar.FEBRUARY,23);
		
		//Formatador de data
		SimpleDateFormat formatador = new
				SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		//Exibir a data
		System.out.println(formatador.format(hoje.getTime()));
		System.out.println(formatador.format(carnaval.getTime()));
	}
	
}
