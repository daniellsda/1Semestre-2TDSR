package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar uma conta corrente e uma conta poupança
		ContaCorrente cc = new ContaCorrente(1, 2,
			Calendar.getInstance(), 100, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(1, 12,
			new GregorianCalendar(2019, Calendar.JANUARY, 25), 200, 1);
		
		//Criar uma lista de conta
		List<Conta> contas = new ArrayList<Conta>();
		//Adicionar contas na lista
		contas.add(cp);
		contas.add(cc);
		contas.add(new ContaCorrente(1, 3, Calendar.getInstance(),
				1000, TipoConta.ESPECIAL));
		
		//Exibir o saldo das contas da lista
		for (Conta c : contas) {
			System.out.println(c.getSaldo());
		}
		
		
	}
	
}





