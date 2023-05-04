import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class StudentView extends JFrame implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel pn1, pn2, pn3, pn4;
    private JLabel lb1, lb2, lb3;
    private JTextField idField, nameField, moneyField;
    private JButton btn1, btn2;

    private File logs;
    private Student s;

    public StudentView(){
        s = new Student();
        fr = new JFrame("StudentView");
        pn1 = new JPanel();
        pn2 = new JPanel();
        pn3 = new JPanel();
        pn4 = new JPanel();
        lb1 = new JLabel(" ID :");
        lb2 = new JLabel(" Name :");
        lb3 = new JLabel(" Money :");
        idField = new JTextField();
        nameField = new JTextField();
        moneyField = new JTextField("0");
        btn1 = new JButton("Deposit");
        btn2 = new JButton("Withdraw");
        //add File
        logs = new File("StudentM.dat");
        try{ logs.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        //add label, textfield, button
        pn1.add(lb1);
        pn1.add(idField);
        pn1.setLayout(new GridLayout(1, 2));

        pn2.add(lb2);
        pn2.add(nameField);
        pn2.setLayout(new GridLayout(1, 2));

        pn3.add(lb3);
        pn3.add(moneyField);
        pn3.setLayout(new GridLayout(1, 2));

        pn4.add(btn1);
        pn4.add(btn2);
        pn4.setLayout(new GridLayout(1, 2));

        //add Listener
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        fr.addWindowListener(this);
        //fr frame
        fr.add(pn1);
        fr.add(pn2);
        fr.add(pn3);
        fr.add(pn4);
        fr.setLayout(new GridLayout(4, 1));
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new StudentView();
        // System.out.println("Name: " + s.name);
        // System.out.println("ID: " + s.id);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(btn1)){
            // int num1 = Integer.parseInt(moneyField.getText());
            s.setMoney(s.getMoney() + 100);
        }
        else if (ae.getSource().equals(btn2)){
            if(s.getMoney() <= 0){
                s.setMoney(0);
            }
            else{
                s.setMoney(s.getMoney() - 100);
            }
            // int num2 = Integer.parseInt(moneyField.getText());
        }
        moneyField.setText(Integer.toString(s.getMoney()));
    }
    public void saveText(){
        try {
            FileOutputStream fOut = new FileOutputStream("dataStudent.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fOut);
            oout.writeObject(s);
            oout.close();
            fOut.close();
            System.out.printf("Serialized data is saved");
            } catch (IOException i) {
            i.printStackTrace();
            }
    }
    public Student loadText(){
        try {FileInputStream fin = new FileInputStream("dataStudent.dat");
            ObjectInputStream in = new ObjectInputStream(fin);
            s = (Student) in.readObject();
            if(s == null){
                s = new Student();
            }
            in.close();
            fin.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        return s;
    }
    @Override
    public void windowClosing(WindowEvent we){
        s.setID(Integer.valueOf(idField.getText()));
        s.setName(nameField.getText());
        s.setMoney(Integer.valueOf(moneyField.getText()));
        saveText();
    }
    @Override
    public void windowOpened(WindowEvent we){
        Student data = loadText();
        idField.setText(String.valueOf(s.getID()));
        nameField.setText(s.getName());
        moneyField.setText(String.valueOf(s.getMoney()));
    }
    @Override
    public void windowActivated(WindowEvent we){}
    @Override
    public void windowIconified(WindowEvent we){}
    @Override
    public void windowClosed(WindowEvent we){}
    @Override
    public void windowDeactivated(WindowEvent we){}
    @Override
    public void windowDeiconified(WindowEvent e) {}

}


// import java.awt.*;
// import java.awt.event.*;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import javax.swing.*;

// public class StudentView implements ActionListener, WindowListener{
    
//     private JFrame fr;
//     private JPanel p1, p2;
//     private JLabel lb1, lb2, lb3;
//     private JButton btn1, btn2;
//     private JTextField f1, f2, f3;
//     private Student student;
//     private File db;
    
//     public StudentView(){
//         fr = new JFrame();
//         p1 = new JPanel();
//         p2 = new JPanel();
//         lb1 = new JLabel("ID: ");
//         lb2 = new JLabel("Name: ");
//         lb3 = new JLabel("Money :");
//         btn1 = new JButton("Deposit");
//         btn2 = new JButton("Withdraw");
//         f1 = new JTextField();
//         f2 = new JTextField();
//         f3 = new JTextField();
        
//         f3.setEnabled(false);
        
//         fr.setLayout(new BorderLayout());
//         p1.setLayout(new GridLayout(3, 2));
//         p2.setLayout(new FlowLayout());
//         p1.add(lb1);
//         p1.add(f1);
//         p1.add(lb2);
//         p1.add(f2);
//         p1.add(lb3);
//         p1.add(f3);
        
//         p2.add(btn1);
//         p2.add(btn2);
        
//         fr.add(p1, BorderLayout.NORTH);
//         fr.add(p2, BorderLayout.SOUTH);
        
//         fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         fr.pack();
//         fr.setVisible(true);
        
//         db = new File("StudentM.dat");
//         try{
//             db.createNewFile();
//         }catch(IOException e){
//             e.printStackTrace();
//         }
        
//         btn1.addActionListener(this);
//         btn2.addActionListener(this);
//         fr.addWindowListener(this);
        
//         student = new Student();
//     }
    
//     public static void main(String[] args) {
//         new StudentView();
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if(e.getSource().equals(btn1)){
//             student.setMoney(student.getMoney() + 100);
//         }
//         else if(e.getSource().equals(btn2)){
//             if(student.getMoney() <= 0){
//                 student.setMoney(0);
//             }
//             else{
//                 student.setMoney(student.getMoney() - 100);
//             }
//         }
//         f3.setText(String.valueOf(student.getMoney()));
//     }

//     @Override
//     public void windowOpened(WindowEvent e) {
//         Student data = load();
//         f1.setText(String.valueOf(data.getID()));
//         f2.setText(data.getName());
//         f3.setText(String.valueOf(data.getMoney()));
//     }

//     @Override
//     public void windowClosing(WindowEvent e) {
//        student.setID(Integer.valueOf(f1.getText()));
//        student.setName(f2.getText());
//        student.setMoney(Integer.valueOf(f3.getText()));
//        save();
//     }
    
//     public void save(){
//         try{
//             FileOutputStream stream = new FileOutputStream(db);
//             ObjectOutputStream outputStream = new ObjectOutputStream(stream);
//             outputStream.writeObject(student);
//             stream.close();
//             outputStream.close();
//         }catch(IOException e){
//             e.printStackTrace();
//         }
//     }
    
//     public Student load(){
//         try{
//             FileInputStream stream = new FileInputStream(db);
//             ObjectInputStream outputStream = new ObjectInputStream(stream);
//             student = (Student) outputStream.readObject();
//             if(student == null){
//                 student = new Student();
//             }
//             stream.close();
//             outputStream.close();
//         }catch(IOException e){
//             e.printStackTrace();
//         }catch(ClassNotFoundException e){
//             e.printStackTrace();
//         }
//         return student;
//     }

//     @Override
//     public void windowClosed(WindowEvent e) {}
//     @Override
//     public void windowIconified(WindowEvent e) {}
//     @Override
//     public void windowDeiconified(WindowEvent e) {}
//     @Override
//     public void windowActivated(WindowEvent e) {}
//     @Override
//     public void windowDeactivated(WindowEvent e) {}
// }
