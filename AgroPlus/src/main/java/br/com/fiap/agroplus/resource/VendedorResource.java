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

import br.com.fiap.agroplus.Service.VendedorService;
import br.com.fiap.agroplus.dto.VendedorDTO;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorResource {

	@Autowired
	private VendedorService vendedorService;

	@GetMapping()
	public List<VendedorDTO> findAll() {
		return vendedorService.getAll();
	}

	@GetMapping("/{id}")
	public VendedorDTO findById(@PathVariable long id) {
		return vendedorService.getById(id);
	}

	@PostMapping()
	public ResponseEntity<VendedorDTO> criarVendedor(@RequestBody VendedorDTO vendedor) {
		VendedorDTO novoVendedor = vendedorService.criarVendedor(vendedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoVendedor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirVendedor(@PathVariable Long id) {
		boolean vendedorDeletado = vendedorService.deleteVendedor(id);
		if (vendedorDeletado) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<VendedorDTO> atualizarVendedor(@PathVariable Long id, @RequestBody VendedorDTO vendedor) {
		VendedorDTO vendedorAtualizado = vendedorService.updateVendedor(id, vendedor);

		if (vendedorAtualizado != null) {
			return ResponseEntity.ok(vendedorAtualizado);
		}

		return ResponseEntity.notFound().build();
	}

}
