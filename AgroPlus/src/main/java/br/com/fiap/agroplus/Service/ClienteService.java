package br.com.fiap.agroplus.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.agroplus.dto.ClienteDTO;
import br.com.fiap.agroplus.entity.Cliente;
import br.com.fiap.agroplus.factory.ClienteFactory;
import br.com.fiap.agroplus.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
    private ClienteRepository clienteRepository;
    
    private ClienteFactory factory = new ClienteFactory();

    public List<ClienteDTO> getAll(){
    	return factory.toDto((List<Cliente>) clienteRepository.findAll());
    }
    
    public ClienteDTO getById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.map(factory::toDto).orElse(null);
    }

    public ClienteDTO criarCliente(ClienteDTO Cliente){
    	Cliente novoCliente = clienteRepository.save(factory.toEntity(Cliente));
        return factory.toDto(novoCliente);
    }

    public ClienteDTO updateCliente(Long id, ClienteDTO Cliente){
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
        
        if(clienteExistente != null){
        	Cliente desatualizado = factory.toEntity(Cliente);
        	desatualizado.setId(id);
        	
        	Cliente atualizado = clienteRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
        	return factory.toDto(clienteExistente);
        }
    }

    public boolean deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
        	clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
