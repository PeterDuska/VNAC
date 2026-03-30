package sk.fmfi.service;

import sk.fmfi.model.Fee;
import java.math.BigDecimal;
import java.util.List;

public interface FeeService {

    Fee createFee(String transactionId, String iban, BigDecimal transactionAmount);

    // Pridajte predpis metódy getAllFees, ktorá bude bezparametrická a bude vracať List<Fee>
    List<Fee> getAllFees();

    // Pridajte predpis metódy getFeesForIban, ktorá bude obsahovať parameter iban typu String a bude vracať List<Fee>
    List<Fee> getFeesForIban(String iban);
}
