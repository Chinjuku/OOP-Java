package Lab8;

// public class Main {
//   public static void main(String[] args) {
//       Account a1 = new Account(5000, "Sommai");
//       Account a2 = new Account(3000, "Somchai");
//       Account a3 = new Account(900, "Somsri");

//       Bank myBank = new Bank();
//       myBank.addAccount(a1);
//       myBank.addAccount(a2);
//       myBank.addAccount(a3);

//       System.out.println("Number of Account: " + myBank.getNumAccount());
//       myBank.getAccount(0).showAccount();
//       System.out.println("Deposit 500...");
//       myBank.getAccount(0).deposit(500);
//       myBank.getAccount(0).showAccount();
//       System.out.println("Show all accounts");
//       System.out.println("==============================");
//       for(int i=0; i<myBank.getNumAccount(); i++){
//           myBank.getAccount(i).showAccount();
//       }
//   }
// }
public class Main{
public static void main(String[] args) {
  Customer cust = new Customer("Somsri", "Boonjing");
  Account acct1 = new Account(5000, "Somsri01");
  Account acct2 = new Account(3000, "Somsri02");
  cust.addAccount(acct1);
  cust.addAccount(acct2);
  // ทดลองฝากเงิน ถอนเงินในบัญชีต่างๆ
  cust.getAccount(0).withdraw(3000);
  cust.getAccount(1).deposit(3000);
  // แสดงข้อมูลของลูกค้า เช่น Somsri Boonjing has 2 accounts.
  System.out.println(cust);
  // ทดลองสร้างบัญชีและเพิEมบัญชีนัFนๆ ให้กับลูกค้า มากกว่า 5 บัญชี
  for (int i = 0; i < cust.getNumOfAccount(); i++) {
  cust.getAccount(i).showAccount();
  }
 }
}


