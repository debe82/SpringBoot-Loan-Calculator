package se.kontek.backend.model.house;

public record HouseLoanDto(
        int loanAmount,
        int paybackTime,
        double interest,
        int frequency
) {
}
