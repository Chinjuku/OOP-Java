package Mocktestbyajbank;

public class Dog extends Animal{
    public Dog(String name, int age){
        super(name, 200, age);
    }
    public void kick(Animal a){
        a.setPower(a.getPower()-10);
    }
    public void eat(Food f){
        setPower(getPower()+(1*f.getPower()));
    }
}
