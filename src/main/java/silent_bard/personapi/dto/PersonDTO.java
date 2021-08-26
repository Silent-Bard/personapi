package silent_bard.personapi.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String firstname;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastname;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;
    
    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;
    
}
