public class CheckingAccount extends Account{
      private double credit;
      
      public CheckingAccount(){
          super(0, "");
          this.credit = 0;
      }
      public CheckingAccount(double balance, String name, double credit){
          super(balance, name);
          this.setCredit(credit);
      }
      public void setCredit(double credit){
          if (credit > 0){
              this.credit = credit;
          }else{
              System.out.println("Input number must be a positive integer.");
          }
      }
      public double getCredit(){
          return this.credit;
      }
      
      @Override
      public void withdraw(double a)throws WithdrawException{
          if (a<=0){
              System.out.println("Input number must be a positive integer.");
              
          }else if(this.getBalance() >= a){
              this.setBalance(this.balance - a);
              System.out.println(a + " baht is withdrawn from " + this.getName() + " and your credit balance is " + this.getCredit() + ".");
          }else if(this.getBalance() + this.getCredit() >= a){
              this.setCredit(this.getCredit()- (a - this.getBalance()));
              this.setBalance(0);
              System.out.println(a + " baht is withdrawn from " + this.getName() + " and your credit balance is " + this.getCredit() + ".");
          }else{
              throw new WithdrawException("Account "+this.getName()+" has not enough money.");
          }
      }
      public void withdraw(String a) throws WithdrawException{
          double b = Double.parseDouble(a);
          withdraw(b);
  //        if (b<=0){
  //            System.out.println("Input number must be a positive integer.");
  //            
  //        }else if(this.getBalance() >= b){
  //            this.setBalance(this.balance - b);
  //            System.out.println(b + " baht is withdrawn from " + this.getName() + " and your credit balance is " + this.getCredit() + ".");
  //        }else if(this.getBalance() + this.getCredit() >= b){
  //            
  //            this.setCredit(this.getCredit()- (b - this.getBalance()));
  //            this.setBalance(0);
  //            System.out.println(b + " baht is withdrawn from " + this.getName() + " and your credit balance is " + this.getCredit() + ".");
  //        }else{
  //            throw new WithdrawException("Account "+this.getName()+" has not enough money.");
  //        }
      }
      @Override
      public String toString(){
          return "The " + this.getName() + " account has " + this.getBalance() + " baht and " + this.getCredit() + " credits.";
      }
  }
