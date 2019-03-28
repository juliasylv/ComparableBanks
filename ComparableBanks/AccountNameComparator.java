import java.util.*;
/**
 * Write a description of class AccountNameComparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AccountNameComparator implements Comparator<BankAccount>
{
    public int compare(BankAccount b1, BankAccount b2)
    {
        if(b1.getName().equals(b2.getName() ))
        {
            if (b1.getBalance() == b2.getBalance() ) // sort by account num
            {
                return b1.getAccountNumber() - b2.getAccountNumber();
            }
            else // sort by account balance
            {
                if(b1.getBalance() < b2.getBalance() )
                {
                    return -1;
                }
                else if(b1.getBalance() > b2.getBalance() )
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        }
        else // sort by account name
        {
            return b1.getName().compareTo(b2.getName() );
            
        }
    }
}
