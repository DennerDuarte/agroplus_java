package br.com.fiap.agroplus.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.agroplus.dto.TipoCultivoDTO;
import br.com.fiap.agroplus.entity.Cliente;
import br.com.fiap.agroplus.entity.TipoCultivo;
import br.com.fiap.agroplus.factory.TipoCultivoFactory;
import br.com.fiap.agroplus.repository.ClienteRepository;
import br.com.fiap.agroplus.repository.TipoCultivoRepository;
import jakarta.transaction.Transactional;

@Service
public class TipoCultivoService {
	
	@Autowired
	private TipoCultivoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private TipoCultivoFactory factory = new TipoCultivoFactory();
	
	public List<TipoCultivoDTO> buscaTiposCultivos() {
		return factory.toDto( (List<TipoCultivo>) repository.findAll());
	}
	
	public TipoCultivoDTO salvaTipoCultivo(TipoCultivoDTO tipoCultivo) {
		return factory.toDto( repository.save(factory.toEntity(tipoCultivo)));
	}
	
	public List<TipoCultivoDTO> buscaTiposCultivosPorCliente(Long clienteId) {
		return factory.toDto( (List<TipoCultivo>) repository.findByClienteId(clienteId));
	}
	
	@Transactional
	public List<TipoCultivoDTO> salvaTiposCultivosPorCliente(Long cultivoId, Long clienteId) {
	    TipoCultivo tipoCultivo = repository.findById(cultivoId)
	            .orElseThrow(() -> new RuntimeException("Tipo de Cultivo não encontrado"));
	    
	    Cliente cliente = clienteRepository.findById(clienteId)
	            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
	    
	    tipoCultivo.getClientes().add(cliente);
	    repository.save(tipoCultivo);
	    
	    cliente.getTipoCultivos().add(tipoCultivo);
	    clienteRepository.save(cliente);
	    
	    return factory.toDto(repository.findByClienteId(clienteId));
	}
	
	@Transactional
	public List<TipoCultivoDTO> removeTipoCultivoDeCliente(Long cultivoId, Long clienteId) {
	    TipoCultivo tipoCultivo = repository.findById(cultivoId)
	            .orElseThrow(() -> new RuntimeException("Tipo de Cultivo não encontrado"));
	    
	    Cliente cliente = clienteRepository.findById(clienteId)
	            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
	    
	    if (tipoCultivo.getClientes().contains(cliente)) {
	        tipoCultivo.getClientes().remove(cliente);
	        repository.save(tipoCultivo);
	        
	        cliente.getTipoCultivos().remove(tipoCultivo);
	        clienteRepository.save(cliente);
	    } else {
	        throw new RuntimeException("O Cliente não está associado a este Tipo de Cultivo.");
	    }
	    
	    return factory.toDto(repository.findByClienteId(clienteId));
	}


}
