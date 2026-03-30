package sk.fmfi.model;

import lombok.*;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Fee {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String transactionId;

    @Column 
    private String iban;

    @Column
    private BigDecimal amount;

    @Column
    private LocalDateTime postingDate;
    
    // pridajte zvyšné atribúty:
    //   - iban typu String
    //   - amount typu BigDecimal
    //   - postingDate typu LocalDateTime 
  
}
