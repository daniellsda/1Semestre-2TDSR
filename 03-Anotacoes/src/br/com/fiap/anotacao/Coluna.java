package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Determina at� quando a anota��o estar� presente
@Retention(RetentionPolicy.RUNTIME) //execu��o
//Determinar onde pode ser utilizada a anota��o
@Target(ElementType.FIELD) //atributos
public @interface Coluna {
	
	String nome();
	
	int tamanho() default 255;
	
	boolean obrigatorio() default false;
	
}