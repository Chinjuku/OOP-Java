package Lab6;

public class Main2 {
    public static void main(String[] args) {

        Wallet w1 = new Wallet();

        Wallet w2 = new Wallet();

        w1.setBalance(200);

        w2.setBalance(100);

        

        Programmer p1 = new Programmer();

        p1.setName("Sara");

        p1.setEnergy(100);

        p1.setWallet(w1);

        p1.setHappiness(100);

        

        SeniorProgrammer sp1 = new SeniorProgrammer();

        sp1.setName("Kim");

        sp1.setEnergy(100);

        sp1.setWallet(w2);

        sp1.setHappiness(100);

        

        System.out.println(p1 + "\nHappiness : " +p1.getHappiness());

        System.out.println(sp1 + "\nHappiness : " +sp1.getHappiness());

        sp1.compliment(p1);

        sp1.compliment(p1);

        System.out.println(p1 + "\nHappiness : " +p1.getHappiness());

        System.out.println(sp1 + "\nHappiness : " +sp1.getHappiness());

        sp1.blame(p1);

        System.out.println(p1 + "\nHappiness : " +p1.getHappiness());

        System.out.println(sp1 + "\nHappiness : " +sp1.getHappiness());

    }

}

