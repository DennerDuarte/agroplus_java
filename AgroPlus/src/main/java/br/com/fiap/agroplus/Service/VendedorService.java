package br.com.fiap.agroplus.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.agroplus.dto.VendedorDTO;
import br.com.fiap.agroplus.entity.Vendedor;
import br.com.fiap.agroplus.factory.VendedorFactory;
import br.com.fiap.agroplus.repository.VendedorRepository;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;
    
    private VendedorFactory factory = new VendedorFactory();

    public List<VendedorDTO> getAll(){
    	return factory.toDto((List<Vendedor>) vendedorRepository.findAll());
    }
    
    public VendedorDTO getById(Long id) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        return vendedorOptional.map(factory::toDto).orElse(null);
    }

    public VendedorDTO criarVendedor(VendedorDTO vendedor){
    	Vendedor novoVendedor = vendedorRepository.save(factory.toEntity(vendedor));
        return factory.toDto(novoVendedor);
    }

    public VendedorDTO updateVendedor(Long id, VendedorDTO vendedor){
        Vendedor vendedorExistente = vendedorRepository.findById(id).orElse(null);
        
        if(vendedorExistente != null){
        	Vendedor desatualizado = factory.toEntity(vendedor);
        	desatualizado.setId(id);
        	
        	Vendedor atualizado = vendedorRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
        	return factory.toDto(vendedorExistente);
        }
    }

    public boolean deleteVendedor(Long id) {
        if (vendedorRepository.existsById(id)) {
            vendedorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
