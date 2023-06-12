package se.kontek.backend.model.house;

import java.lang.invoke.StringConcatException;

public record HouseLoanDto(
        int loanAmount,
        int paybackTime,
        int frequency,
        double interest,
        String interestType
) {
}
