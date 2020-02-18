package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Determina até quando a anotação estará presente
@Retention(RetentionPolicy.RUNTIME) //execução
//Determinar onde pode ser utilizada a anotação
@Target(ElementType.FIELD) //atributos
public @interface Coluna {
	
	String nome();
	
	int tamanho() default 255;
	
	boolean obrigatorio() default false;
	
}