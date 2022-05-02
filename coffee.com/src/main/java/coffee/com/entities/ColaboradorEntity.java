package coffee.com.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import coffee.com.dtos.ColaboradorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="COLABORADOR")
public class ColaboradorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;	
	//__________________________________________ Conversão da ColaboradorEntity para ColaboradorDTO
	public ColaboradorDTO toDto() {
		ModelMapper mapper = new ModelMapper();
		ColaboradorDTO dto = mapper.map(this, ColaboradorDTO.class);
		return dto;
	}
	//__________________________________________Relacionamento de classes SnackEntity E ColaboradorEntity
	@JsonIgnore
	@OneToMany(mappedBy = "colaborador")
	private List<SnackEntity> snack;
}
