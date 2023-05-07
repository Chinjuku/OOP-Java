import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class BookAdd implements ActionListener{
    public JFrame fr;
    private JLabel lb1, lb2, lb3;
    private JTextField tf_name, tf_price;
    private JPanel pn1, pn2;
    private JComboBox<String> cb_type;
    private String[] items = { "General", "Computer", "Math&Sci" , "Photo"};
    private JButton btn;
    public BookAdd(){
        fr = new JFrame();
        pn1 = new JPanel();
        pn2 = new JPanel();
        lb1 = new JLabel(" Name");
        lb2 = new JLabel(" Price");
        lb3 = new JLabel(" Type");
        tf_name = new JTextField();
        tf_price = new JTextField();
        btn = new JButton("Insert");
        cb_type = new JComboBox<String>(items);
        //Set Label, TextField
        pn1.add(lb1);
        pn1.add(tf_name);
        pn1.add(lb2);
        pn1.add(tf_price);
        pn1.add(lb3);
        pn1.add(cb_type);
        pn1.setLayout(new GridLayout(3, 2));
        //Set Frame
        fr.add(pn1);
        pn2.add(btn);
        fr.add(pn2, BorderLayout.SOUTH);
        btn.addActionListener(this);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(false);
    }
    //ปุ่มสั่งการให้ทำงาน
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(btn)){
            // BookView.addBook(this.getBook());
            BookView.colBook.add(this.getBook());
            fr.dispose();
            JOptionPane.showMessageDialog(null, "Done It.",
            "", JOptionPane.CLOSED_OPTION);
        }
    }
    //getBook ที่เก็บสร้างหนังสือ
    public Book getBook(){
        Book b = new Book(tf_name.getText(), Double.parseDouble(tf_price.getText()),
        String.valueOf(cb_type.getSelectedItem()));
        return b;
    }
    //GetBook อีกวีธี
    //public Book getBook(String name, Double price, String type)
    //Book b = null;
    // try {
    //     b = new Book(name, price, type);
    // } catch(NumberFormatException e){
    //     e.printStackTrace();
    // } catch (Exception e) {
    //     System.out.println("An error occurred while creating the book: " + e.getMessage());
    // }
}
