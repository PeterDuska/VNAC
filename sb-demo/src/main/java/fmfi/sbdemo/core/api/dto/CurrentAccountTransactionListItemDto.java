package fmfi.sbdemo.core.api.dto;

import fmfi.sbdemo.core.api.dictionary.*;

@lombok.Builder
public record CurrentAccountTransactionListItemDto(
        String transactionId,
        Money amount, //  Suma
        String partnerName, //  Názov partnera
        String variableSymbol, //  Variabilný symbol
        String description,//  Doplňujúce informácie
        Money accountBalance, //  Účtovný zostatok
        java.time.LocalDate effectiveDate, //  Dátum zaúčtovania
        TransactionStatus status, //  Stav platby
        TransactionDirection direction // Typ platby
) { }
