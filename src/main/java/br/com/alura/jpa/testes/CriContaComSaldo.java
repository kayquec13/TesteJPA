package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriContaComSaldo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta ();
		conta.setTitular("Fernanda");
		conta.setNumero(1257);
		conta.setAgencia(4322);
		conta.setSaldo(12000.0);
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
	
		
		conta.setSaldo(5000.0);
		
	}
}
