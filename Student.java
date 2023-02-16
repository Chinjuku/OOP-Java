public class Student {
    public double mScore;
    public double fScore;
    public void showGrade(){
        double score = (mScore*0.4)+(fScore*0.4)+20;
        System.out.println("Your grade :"+ score);
    }
    public static void main(String[] args){
    Student s = new Student();
        s.mScore = 80;
        s.fScore = 80;
        s.showGrade();
    }
}


