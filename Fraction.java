public class Fraction {
    public int topN;
    public int btmN;
    public String toFraction(){
        return topN+"/"+btmN;
    }
    public String toFloat() {
        return (1.0 * topN / btmN) + "";
    }
    public void addFraction(Fraction f) {
        if (btmN == f.btmN) {
            topN += f.topN;
        }
        else {
            topN = topN * f.btmN + f.topN * btmN;
            btmN *= f.btmN;
        }
    }
    public static void main(String[] args) {
        Fraction f1 = new Fraction();
        f1.topN = 2;
        f1.btmN = 5;
        Fraction f2 = new Fraction();
        f2.topN = 3;
        f2.btmN = 7;
        System.out.println("before" +  f1.toFraction());
        System.out.println("before" +  f1.toFloat());
        f1.addFraction(f2);
        System.out.println("after" +  f1.toFraction());
        System.out.println("after" +  f1.toFloat());
    }

}
