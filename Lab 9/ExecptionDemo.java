
public class  ExecptionDemo extends Exception{
    public static void main(String[] args) {
        try{
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double numa = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / 2*a;
        double numb = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / 2*a;

        System.out.println(numa);
        System.out.println(numb);
        }
        catch (NumberFormatException e){
            System.out.println("Please input data in number format only.");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please enter 3 numbers as a, b, and c respectively.");
        }
    }
}
