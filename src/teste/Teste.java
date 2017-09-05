package teste;

import java.util.List;

import com.crud.entidade.Cliente;
import com.crud.repositorio.RepositorioCliente;

public class Teste {

	public static void main(String[] args) {
		RepositorioCliente repositorioCliente = new RepositorioCliente();
		Cliente cliente = new Cliente();
		cliente.setNome("fulano");
		cliente.setIdade(15);
		
		//repositorioCliente.salvar(cliente);
		
		List<Cliente> clientes = repositorioCliente.ListarTodos();
		
		for(Cliente cliente2 : clientes) {
			System.out.println(cliente2.getNome());
		}
		
		
	}
}	
