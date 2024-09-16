package br.com.fiap.agroplus.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.agroplus.Service.ClienteService;
import br.com.fiap.agroplus.dto.ClienteDTO;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping()
	public List<ClienteDTO> findAll() {
		return clienteService.getAll();
	}

	@GetMapping("/{id}")
	public ClienteDTO findById(@PathVariable long id) {
		return clienteService.getById(id);
	}

	@PostMapping()
	public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO cliente) {
		ClienteDTO novoCliente = clienteService.criarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
		boolean vlienteDeletado = clienteService.deleteCliente(id);
		if (vlienteDeletado) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO vliente) {
		ClienteDTO vlienteAtualizado = clienteService.updateCliente(id, vliente);

		if (vlienteAtualizado != null) {
			return ResponseEntity.ok(vlienteAtualizado);
		}

		return ResponseEntity.notFound().build();
	}

}
