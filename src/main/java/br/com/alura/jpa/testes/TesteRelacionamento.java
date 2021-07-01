package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamento {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setAgencia(123451);
		conta.setNumero(5486213);
		conta.setSaldo(300.00);
		conta.setTitular("Marcos");
		
		Movimentacao mov = new Movimentacao();
		mov.setData(LocalDateTime.now());
		mov.setDescricao("IFood");
		mov.setValor(new BigDecimal(200.00));
		mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		mov.setConta(conta);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(mov);
		em.getTransaction().commit();
		
		em.close();
		
	}
}
