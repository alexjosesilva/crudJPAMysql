package com.crud.repositorio;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.crud.entidade.Cliente;

public class RepositorioCliente {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	
	
	public RepositorioCliente() {
		emf = Persistence.createEntityManagerFactory("mohr");
		em = emf.createEntityManager();
	}
	
	public void obterPorId(int id) {
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class,id);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void salvar(Cliente cliente) {
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Cliente cliente) {
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List <Cliente> ListarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select cliente from Cliente cliente");
		List<Cliente> clientes = consulta.getResultList();
		em.getTransaction().commit();	
		em.close();
		return clientes;
	}
}
