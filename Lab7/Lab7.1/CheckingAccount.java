package Lab7;

public class CheckingAccount extends Account{
    private double credit;
    public CheckingAccount(){
        // balance = 0;
        // name = "";
        super(0, "");
        this.credit = 0;
    }
    public CheckingAccount(double balance, String name, double credit){
        super(balance, name);
        this.credit = credit;
    }
    public void setCredit(double credit){
        if (credit > 0){
        this.credit = credit;
        }else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    public double getCredit(){
        return credit;
    }
    @Override
    public void withdraw(double a){
            if ((balance - a) >= 0){
                balance -= a;
                // super.withdraw(a);
                System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is "+ credit+".");
            }
            else if ((balance + credit) - a >= 0){
                balance = 0;
                // setCredit(getCredit()-(getBalance()-a));
                credit += (balance - a);
                System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is "+ credit+".");
            }
            else if ((balance - a) + credit < 0){
                System.out.println("Not enough money!");
            }
    }
    @Override
    public String toString(){
        return ("The " + name + " account has " + balance + " baht and " + credit + " credits.");
    }

    public void withdraw(String a){
        withdraw(Double.parseDouble(a));
}
}
