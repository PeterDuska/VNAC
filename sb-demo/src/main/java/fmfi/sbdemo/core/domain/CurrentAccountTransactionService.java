package fmfi.sbdemo.core.domain;

import fmfi.sbdemo.core.api.*;
import fmfi.sbdemo.core.api.dictionary.*;
import fmfi.sbdemo.core.api.dto.*;

@org.springframework.stereotype.Service // register this service as Spring bean
@lombok.RequiredArgsConstructor
public class CurrentAccountTransactionService implements GetLatestCurrentAccountTransactionsUseCase {

    @Override
    public CurrentAccountTransactionsDto getLatestCurrentAccountTransactions(String accountNumber) {
        return new CurrentAccountTransactionsDto(
                new CurrentAccountTransactionListItemDto(
                        /* transactionId */ "667bb620-04c6-45cb-8746-80cf932c7a01",
                        /* amount */ Money.eur(42),
                        /* partnerName */ "Acme corp.",
                        /* variableSymbol */ "123456",
                        /* description */ "Anvil",
                        /* accountBalance */ Money.eur(958),
                        /* effectiveDate */ java.time.LocalDate.of(2022, 9, 24),
                        /* status */ TransactionStatus.PROCESSED,
                        /* direction */ TransactionDirection.DEBIT
                ),
                new CurrentAccountTransactionListItemDto(
                        /* transactionId */ "1717c635-d19a-4399-b911-2d30578c065d",
                        /* amount */ Money.eur(10),
                        /* partnerName */ "Acme corp.",
                        /* variableSymbol */ null,
                        /* description */ "Cashback",
                        /* accountBalance */ Money.eur(970),
                        /* effectiveDate */ java.time.LocalDate.of(2022, 9, 25),
                        /* status */ TransactionStatus.PROCESSED,
                        /* direction */ TransactionDirection.CREDIT
                )
        );
    }
}
