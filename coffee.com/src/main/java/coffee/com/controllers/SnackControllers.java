package coffee.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coffee.com.entities.SnackEntity;
import coffee.com.services.SnackService;

@RestController
@RequestMapping("snack")
public class SnackControllers {
	@Autowired
	SnackService snackService;
	//____________________________________________ Retorna todos os itens__________________________________________
	// Retorno de todos os itens através do metodo Get
	@GetMapping
	public List<SnackEntity> getAll() {
		return this.snackService.getAll();
	}

//____________________________________________ Retorna apenas 01, buscando pelo ID______________________________
	// Retorno apenas 01 Produto, identificado pelo ID, através do metodo Get
	@GetMapping("{id}")
	public SnackEntity getOne(@PathVariable int id) {
		return snackService.getOne(id);
	}

//____________________________________________ Insere um novo item _____________________________________________
	// inclui um novo Produto através do metodo POST
	@PostMapping
	public SnackEntity save(@RequestBody SnackEntity venda) {
		return snackService.save(venda);
	}

//____________________________________________ Altera um item, buscando pelo ID _________________________________
	// Recebe um Id, verifica se existe e faz alteração através do metodo PATCH
	@PatchMapping("{id}")
	public SnackEntity update(@PathVariable int id, @RequestBody SnackEntity venda) {
		return snackService.update(id, venda);
	}

//____________________________________________ Exclui um item, buscando pelo ID ___________________________________
	// Localiza o professor pelo ID, e faz a exclusão do objeto, através do metodo
	// DELETE
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		snackService.delete(id);
	}
	
}
