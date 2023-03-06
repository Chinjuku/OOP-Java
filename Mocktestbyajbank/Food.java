package Mocktestbyajbank;

public abstract class Food {
    protected String name;
    public Food(){
        name = "";
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public abstract int getPower();
}
