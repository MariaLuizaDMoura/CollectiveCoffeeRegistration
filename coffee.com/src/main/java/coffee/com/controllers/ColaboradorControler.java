package coffee.com.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coffee.com.dtos.ColaboradorDTO;
import coffee.com.services.ColaboradorService;

@RestController
@RequestMapping("colaborador")
public class ColaboradorControler {
	@Autowired
	private ColaboradorService colaboradorService;
	
	//__________________________________________ Retorna todos os ITENS
	@GetMapping()
	public ResponseEntity<List<ColaboradorDTO>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.getAll());
	}
	//__________________________________________ Retornar apenas 01
	@GetMapping("{id}")
	public ResponseEntity<ColaboradorDTO> getOne (@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.getOne(id));
	}
	//__________________________________________ INSERIR um novo
	@PostMapping // @Valid validação dos campos no metodo POST
	public ResponseEntity<ColaboradorDTO> save (@Valid @RequestBody ColaboradorDTO colaborador){
		return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.save(colaborador.toEntity()));
	}
	//__________________________________________ Alterar item, buscando por ID
	@PatchMapping("{id}")
	public ResponseEntity<ColaboradorDTO> updade (@PathVariable int id, @RequestBody ColaboradorDTO colaborador){
		return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.update(id , colaborador.toEntity()));
	}
	//__________________________________________ Deletar item pelo ID
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		colaboradorService.delete(id);
	}
}




