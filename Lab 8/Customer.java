package Lab8;


// Lab 8.2
// public class Customer {
//     private String firstName;
//     private String lastName;
//     private Account[] acct;
//     private int numOfAccount;
//     public Customer(){
//         this("", "");
//         //acct = new Account[5];
//     }
//     public Customer(String firstName, String lastName){
//         this.firstName = firstName;
//         this.lastName = lastName;
//         // this(firstName, lastName);
//         acct = new Account[5];
//     }
//     public void setFirstName(String firstName){
//         this.firstName = firstName;
//     }
//     public String getFirstName(){
//         return firstName;
//     }
//     public void setLastName(String lastName){
//         this.lastName = lastName;
//     }
//     public String getLastName(){
//         return lastName;
//     }
//     public String toString(){
//         return (firstName + "-" + lastName + " has " + getNumOfAccount() + " Accounts.");
//     }
//     public Account getAccount(int index){
//         return acct[index];
//     }
//     public void addAccount(Account acct){
//         this.acct[numOfAccount] = acct;
//         numOfAccount += 1;
//     }
//     public int getNumOfAccount(){
//         return numOfAccount;
//     }
// }

// Lab 8.3
import java.util.ArrayList;
public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList acct;
    private int numOfAccount;
    public Customer(){
        this("", "");
        //acct = new Account[5];
    }
    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        // this(firstName, lastName);
        this.acct = new ArrayList();
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public String toString(){
        return (firstName + "-" + lastName + " has " + this.numOfAccount + " Accounts.");
    }
    public Account getAccount(int index){
        return (Account) this.acct.get(index);
    }
    public void addAccount (Account acct) {
        this.acct.add(acct);
        this.numOfAccount++;
  }
    public int getNumOfAccount(){
        return acct.size();
    }
}

