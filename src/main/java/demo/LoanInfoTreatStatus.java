package demo;

public enum LoanInfoTreatStatus {
    TODO("NOMAL"), DONE("DONE");
    public String value;

    private LoanInfoTreatStatus(String value) {
        this.value = value;
    }

    public LoanInfoStatus valueof(String value) {
        for (LoanInfoStatus status : LoanInfoStatus.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        return null;
    }
}