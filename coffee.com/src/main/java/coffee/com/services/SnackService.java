package coffee.com.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coffee.com.entities.ColaboradorEntity;
import coffee.com.entities.SnackEntity;
import coffee.com.repositories.ColaboradorRepository;
import coffee.com.repositories.SnackRepository;

@Service
public class SnackService {
	@Autowired
	private SnackRepository snackRepository;
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	//__________________________________________ Mostrar Todos
	public List<SnackEntity> getAll(){
		return snackRepository.findAll();
	}
	//__________________________________________ Mostrar apenas 01
	public SnackEntity getOne (int id) {
		return snackRepository.findById(id).orElse(new SnackEntity());
	}
	//__________________________________________ INSERIR um novo
	public SnackEntity save(SnackEntity snack) {
		SnackEntity snackSalvo = snackRepository.save(snack);
		ColaboradorEntity colaborador = snack.getColaborador();
		colaboradorRepository.save(colaborador);
		return snackSalvo;
		
//		List<ColaboradorEntity> listaColaborador = snack.getColaborador();
//		for(int i = 0; i < listaColaborador.size() ; i++) {
//			listaColaborador.get(i).setSnack(Arrays.asList(snackSalvo));
//		}
//		colaboradorRepository.saveAll(listaColaborador);
//		
//		return snackSalvo;
	}
	//__________________________________________ Atualizando os dados / UPDATE
	public SnackEntity update (int id , SnackEntity novoSnack) {
		Optional<SnackEntity> optional = snackRepository.findById(id);
		if (optional.isPresent() == true) {
			SnackEntity snack = optional.get();
			snack.setColaborador(novoSnack.getColaborador());
			snack.setNomeSnack(novoSnack.getNomeSnack());
			
			return snackRepository.save(snack);
		}
		else {
			return new SnackEntity();
		}
	}
	//__________________________________________ Deletar
	public void delete(int id) {
		snackRepository.deleteById(id);
	}
}
