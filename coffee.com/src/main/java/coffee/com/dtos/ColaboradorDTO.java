package coffee.com.dtos;

import org.modelmapper.ModelMapper;

import coffee.com.entities.ColaboradorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDTO {
	
	private Integer id;
	private String nome;
	private String cpf;
	
	//__________________________________________ Conversão da ColaboradorDTO para ColaboradorEntity
	public ColaboradorEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ColaboradorEntity.class);
	}
}
