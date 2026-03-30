package sk.fmfi.resource.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

// pridajte Lombok anotácie @Data, @Builder
@Data
@Builder
public class TransactionDTO {

    private String transactionId;

    private String iban;

    private BigDecimal amount;
    // pridajte zvyšné atribúty iban, amount (rovnaká definícia ako v entite Fee ale bez anotácie @Column)

}
