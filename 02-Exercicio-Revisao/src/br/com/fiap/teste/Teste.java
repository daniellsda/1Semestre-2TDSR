package br.com.fiap.teste;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Teste {

	public static void main(String[] args) {
		//Instanciar a conta corrente
		ContaCorrente cc = new ContaCorrente();
		
		cc.depositar(100);
		cc.setTipo(TipoConta.COMUM);
		
		try {
			cc.retirar(500);
			System.out.println("Saque efetuado!");
		}catch(Exception e) {
			System.err.print("Conta comum não pode ficar negativo");
		}
	}
	
}


