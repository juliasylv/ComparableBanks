import java.util.*;
/**
 * Write a description of class AccountNumComparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AccountNumComparator implements Comparator<BankAccount>
{
    public int compare(BankAccount b1, BankAccount b2)
    {
        return b1.getAccountNumber() - b2.getAccountNumber();
        
    }
}
