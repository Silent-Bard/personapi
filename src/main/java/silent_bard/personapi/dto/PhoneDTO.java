package silent_bard.personapi.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import silent_bard.personapi.enums.PhoneType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    
    Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;
    
    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
