
import java.util.*;
import java.io.*;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class tester2  
{
    public static void main (String [] args) throws IOException
    {
        String [] lines ;
        //Bank OSSM = new Bank(lines[0].split("=")[1], Integer.parseInt(lines[1].split("=")[1]));

        // String line = lines[0];
        // String [] words = line.split("=");
        // String name = words[1];
        // String line2 = lines[1];
        // String [] words2 = line2.split("=");
        // int numEmployees = Integer.parseInt(words2[1]);

        //Bank OSSM = new Bank(name, numEmployees);

        //ArrayList<BankAccount> bank = new ArrayList<BankAccount>();

        lines = ReadFromFile.ReadFile("/Users/juliasylvester/Desktop/temp_nerd/BankOfOSSM.txt");

        String line = lines[0];
        String [] words = line.split("=");
        String name = words[1];
        String line2 = lines[1];
        String [] words2 = line2.split("=");
        int numEmployees = Integer.parseInt(words2[1]);
        Bank OSSM = new Bank(name, numEmployees);

        // for(i = 0; i < lines.length; i++)
        // {
        // System.out.println(lines[i]);
        // }
        int i = 2;
        while(i < lines.length)
        {
            //Bank OSSM = new Bank(lines[0].split("=")[1], Integer.parseInt(lines[1].split("=")[1]));

            if(lines[i].contains("BankAccount"))
            {
                BankAccount blah = new BankAccount(lines[i].split("=")[1],Double.parseDouble(lines[i+2].split("=")[1]));
                OSSM.addAccount(blah);
                i += 3;
            }
            else if(lines[i].contains("SavingsAccount"))
            {
                SavingsAccount bleh = new SavingsAccount(lines[i].split("=")[1], Double.parseDouble(lines[i+2].split("=")[1]), Double.parseDouble(lines[i+3].split("=")[1]));
                OSSM.addAccount(bleh);
                i += 4;
            }
            // to check problems
            //System.out.println(lines[i]);

        }

        while(true)
        {
            Scanner kb = new Scanner(System.in);
            System.out.println("Would you like a bank account, or savings account?");
            System.out.println("When you are done entering accounts, please input: quit");
            String accountType = kb.nextLine();
            if(accountType.contains("bank"))
            {
                System.out.println("Input as many bank accounts as you would like, enter in the name, followed by your intial deposit!");
                String namee = kb.nextLine();
                Scanner kb2 = new Scanner(System.in);
                double intDeposit = kb2.nextDouble();
                BankAccount bA = new BankAccount(namee, intDeposit);
                OSSM.addAccount(bA);

            }
            else if(accountType.contains("savings"))
            {
                System.out.println("Input as many savings accounts as you would like, enter in the name, followed by your intial deposit,");
                System.out.println("and then input the rate!");
                Scanner kbName = new Scanner(System.in);
                String namee = kbName.nextLine();
                Scanner kb3 = new Scanner(System.in);
                double intDeposit = kb3.nextDouble();
                double rate = kb3.nextDouble();
                SavingsAccount sA = new SavingsAccount(namee, intDeposit, rate);
                OSSM.addAccount(sA);
            }
            else if(accountType.contains("quit"))
            {
                System.out.println("Thank you for inputting an account!");
                break;
            }

            
        }

        BankAccount boom = new BankAccount("Bob",500, 4);
        BankAccount bam = new BankAccount("Bob", 500, 8);
        SavingsAccount wow = new SavingsAccount("Bob", 500, 5, 9);

        OSSM.addAccount(boom);
        OSSM.addAccount(bam);
        OSSM.addAccount(wow);

        Scanner kb2 = new Scanner(System.in);
        System.out.println("How would you like to sort the accounts?");
        System.out.println("a. Ascending sort by account number");
        System.out.println("b. Ascending sort by account name?");
        System.out.println("c. Sort by account type");
        String response = kb2.next();

        BankAccount[] ba = new BankAccount[OSSM.getAccounts().size()];
        BankAccount[] arr = OSSM.getAccounts().toArray(ba);
        if(response.equals("a"))
        {
            AccountNumComparator anc = new AccountNumComparator();
            Arrays.sort(arr, anc);

        }
        else if(response.equals("b"))
        {
            AccountNameComparator anac = new AccountNameComparator();
            Arrays.sort(arr, anac);

        }
        else if(response.equals("c"))
        {
            AccountTypeComparator atc = new AccountTypeComparator();
            Arrays.sort(arr, atc);

        }
        FileWriter fw = new FileWriter("/Users/juliasylvester/Desktop/temp_nerd/SortedAccounts.txt");
        PrintWriter pw = new PrintWriter(fw);

        OSSM.updateAccounts(arr);

        pw.print(OSSM);
        pw.close();
        fw.close();
    }

}