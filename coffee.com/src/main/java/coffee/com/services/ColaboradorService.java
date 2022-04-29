package coffee.com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coffee.com.dtos.ColaboradorDTO;
import coffee.com.entities.ColaboradorEntity;
import coffee.com.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	//__________________________________________ Mostrar Todos
	public List<ColaboradorDTO> getAll(){
		List<ColaboradorEntity> lista = colaboradorRepository.findAll();
		List<ColaboradorDTO> listaDto = new ArrayList<>();
		
		for (ColaboradorEntity colaboradorEntity : lista) {
			//ToDTO veio da conversao de ColaboradorDTO para ColaboradorEntity
			listaDto.add(colaboradorEntity.toDto());
		}
		return listaDto;
	}
	//__________________________________________ Mostrar apenas 01
	public ColaboradorDTO getOne (int id) {
		Optional<ColaboradorEntity> optional = colaboradorRepository.findById(id);
		ColaboradorEntity colaborador = optional.orElse(new ColaboradorEntity() );
		return colaborador.toDto();
	}
	//__________________________________________ INSERIR um novo
	public ColaboradorDTO save (ColaboradorEntity colaborador) {
		return colaboradorRepository.save(colaborador).toDto();
	}
	//__________________________________________ Atualizando os dados / UPDATE
	public ColaboradorDTO update (int id , ColaboradorEntity novocolaborador) {
		Optional<ColaboradorEntity> optional = colaboradorRepository.findById(id);
		if (optional.isPresent() == true) {
			ColaboradorEntity colaboradorBD = optional.get();
			colaboradorBD.setNome( novocolaborador.getNome());
			colaboradorBD.setCpf(novocolaborador.getCpf());
			
			return colaboradorRepository.save(colaboradorBD).toDto();
		}
		else {
			return new ColaboradorEntity().toDto();
		}
	}
	//__________________________________________ Deletar
	public void delete(int id) {
		colaboradorRepository.deleteById(id);
	}
}







