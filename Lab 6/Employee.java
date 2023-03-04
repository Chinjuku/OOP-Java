package Lab6;

public class Employee {
    private static String nationality = "Thai";
    private String name;
    private Wallet wallet;
    private int energy;
    public boolean equals(Employee e){
        return name.equals(e.name);
    }
    @Override
    public String toString(){
        return ("My name is "+name+".\nI have "+energy+" energy left.\nI have a balance of "+wallet.getBalance()+" baht.");
    }
    public boolean buyFood(Seller s){
        if (getWallet().getBalance() >= Food.getPrice()){
            Food f1 = s.sell(this);
            eat(f1);
            return true;
        }else{
            s = null;
            return false;
        }
    }
    public void eat(Food f){
        setEnergy(getEnergy()+Food.getEnergy());
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setWallet(Wallet wallet){
        this.wallet = wallet;
    }
    public Wallet getWallet(){
        return wallet;
    }
    public void setEnergy(int energy){
        this.energy = energy;
    }
    public int getEnergy(){
        return energy;
    }
    public static void setNationality(String nationality){
        Employee.nationality = nationality;
    }
    public static String getNationality(){
        return nationality;
    }
}
