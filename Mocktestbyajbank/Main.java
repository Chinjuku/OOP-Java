package Mocktestbyajbank;

public class Main {
    public static void main(String[] args) {
    Pigeous p = new Pigeous("Pee",5);
    Owner bank = new Owner("Bank",p);
   
    Dog d = new Dog("Qee",4);
    Owner ice = new Owner("Ice",d);
   
    Meat m = new Meat();
   
    System.out.println(bank);
    System.out.println(ice);
   
    bank.protectOwnerFrom(ice.getAnimal());
    System.out.println(bank);
    System.out.println(ice);
   
    ice.feedFood(m);
    System.out.println(bank);
    System.out.println(ice);
   
    p.fly();
    }
   }
