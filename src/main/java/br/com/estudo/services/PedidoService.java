package br.com.estudo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.domain.Pedido;
import br.com.estudo.repositories.PedidoRepository;
import br.com.estudo.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
//		Pedido objPedido = repo.findById(id).get();
		Optional<Pedido> objPedido = repo.findById(id);

		return objPedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	};

}
