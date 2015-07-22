/**
 * 
 */
package demo;

/**
 * @author chenguangjian
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(LoanInfoTreatStatus.TODO.value);
        System.out.println(LoanInfoTreatStatus.DONE.value);

        System.out.println(LoanInfoTreatStatus.valueOf("TODO"));
        System.out.println(LoanInfoTreatStatus.valueOf("DONE"));
    }

}
