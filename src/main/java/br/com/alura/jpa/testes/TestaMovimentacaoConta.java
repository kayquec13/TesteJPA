package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao mov = em.find(Movimentacao.class, 2L);
		
		Conta conta = mov.getConta();
		int quantidade = conta.getMovimentacao().size();
		
		System.out.println("Quantidade de movimentacao: " + quantidade);
		System.out.println("Titular da conta: " + conta.getTitular());

	}

}
