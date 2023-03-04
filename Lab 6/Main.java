package Lab6;

public class Main {
    public static void main(String[] args) {
        Wallet w1 = new Wallet();

        Wallet w2 = new Wallet();

        w1.setBalance(200);

        w2.setBalance(100);

        Seller s1 = new Seller();

        s1.setName("Peter");

        s1.setEnergy(100);

        s1.setWallet(w1);

        Employee e1 = new Employee();

        e1.setName("Adam");

        e1.setEnergy(100);

        e1.setWallet(w2);


        System.out.println(s1);

        System.out.println(e1);

        e1.buyFood(s1);

        System.out.println(s1);

        System.out.println(e1);

    }

}

