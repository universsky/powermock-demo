/**
 * 
 */
package demo;

/**
 * @author chenguangjian
 *
 */
public enum LoanInfoStatus {
    UNINTEREST("UNINTEREST"), INTERESTDELAY("INTERESTDELAY"), PRINCIPALDELAY("PRINCIPALDELAY"), CURRENTDONE(
            "CURRENTDONE"), DONE("DONE");
    public String value;

    private LoanInfoStatus(String value) {
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
