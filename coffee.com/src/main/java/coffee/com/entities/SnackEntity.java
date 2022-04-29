package coffee.com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 																						
@AllArgsConstructor 																		
@NoArgsConstructor 																			
@Entity 																					
@Table(name="SNACK")
public class SnackEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String nomeSnack;
	
	//__________________________________________Relacionamento de classes SnackEntity E ColaboradorEntity
	@ManyToOne
	@JoinColumn(name = "COLABORADOR_ID")
	private ColaboradorEntity colaborador;
}






