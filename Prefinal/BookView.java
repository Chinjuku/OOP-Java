import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.security.InvalidParameterException;
import java.util.*;
public class BookView implements ActionListener, WindowListener{
    private JFrame fr;
    private JLabel lb1, lb2, lb3;
    private JTextField tf_name, tf_price, page;
    private JComboBox<String> cb;
    private String[] items = { "General", "Computer", "Math&Sci" , "Photo"};
    private JButton back, front, add_b, up, de;
    private JPanel pn1, pn2, pn3;
    private Book b;
    //Collection Book
    public static ArrayList<Book> colBook;
    //Constructor
    public BookView(){
        //New Everything (ประกาศ)
        colBook = new ArrayList();
        b = new Book();
        fr = new JFrame();
        pn1 = new JPanel();
        pn2 = new JPanel();
        pn3 = new JPanel();
        lb1 = new JLabel(" Name");
        lb2 = new JLabel(" Price");
        lb3 = new JLabel(" Type");
        tf_name = new JTextField();
        tf_price = new JTextField();
        page = new JTextField("0");
        back = new JButton("<<<");
        front = new JButton(">>>");
        add_b = new JButton("Add");
        up = new JButton("Update");
        de = new JButton("Delete");
        cb = new JComboBox<String>(items);
        //Set Label, TextField
        pn1.add(lb1);
        pn1.add(tf_name);
        pn1.add(lb2);
        pn1.add(tf_price);
        pn1.add(lb3);
        pn1.add(cb);
        pn1.setLayout(new GridLayout(3, 2));
        //Set change page panel
        pn2.add(back);
        pn2.add(page);
        pn2.add(front);
        pn2.setLayout(new FlowLayout());
        //Set button panel
        pn3.add(add_b);
        pn3.add(up);
        pn3.add(de);
        pn3.setLayout(new FlowLayout());
        //Set Location Frame
        fr.add(pn1, BorderLayout.NORTH);
        fr.add(pn2, BorderLayout.CENTER);
        fr.add(pn3, BorderLayout.SOUTH);
        //Add Listener //ย้ำๆๆๆ อย่าลืม******
        back.addActionListener(this);
        front.addActionListener(this);
        add_b.addActionListener(this);
        up.addActionListener(this);
        de.addActionListener(this);
        fr.addWindowListener(this);
        //Set to cannot Edit
        page.setEditable(false);
        //Set frame
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
    //Click button to work
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(add_b)){
            BookAdd ba = new BookAdd();
            ba.fr.setVisible(true);
        }
        //Backward
        else if(ae.getSource().equals(back)){
            if (Integer.valueOf(page.getText()) <= 1){
                //Do Nothing
            }
            else {
                page.setText(Integer.valueOf(page.getText()) - 1 + "");
                this.setCurrentpage();
            }
        }
        //Forward
        else if(ae.getSource().equals(front)){
            if (Integer.valueOf(page.getText()) == colBook.size()){
                //Do Nothing
            }
            else {
                page.setText(Integer.valueOf(page.getText()) + 1 + "");
                this.setCurrentpage();
            }
        }else if (ae.getSource().equals(up)){
            // savedata();
            int in_num = Integer.valueOf(page.getText()) - 1;
            colBook.get(in_num).setName(tf_name.getText());
            colBook.get(in_num).setPrice(Double.parseDouble(tf_price.getText()));
            colBook.get(in_num).setType(String.valueOf(cb.getSelectedItem()));
            JOptionPane.showMessageDialog(null, "Done It.",
            "Update Command", JOptionPane.CLOSED_OPTION);
        }else if (ae.getSource().equals(de)){
            colBook.remove(Integer.valueOf(page.getText()) - 1);
            JOptionPane.showMessageDialog(null, "Done It.",
            "Delete Command", JOptionPane.CLOSED_OPTION);
            if (colBook.isEmpty()){
                page.setText("0");
                tf_name.setText("");
                tf_price.setText("");
                cb.setSelectedItem("General");
            }
        }
    }
    //Set present page
    public void setCurrentpage(){
        tf_name.setText((colBook.get(Integer.valueOf(page.getText()) - 1)).getName());
        tf_price.setText((colBook.get(Integer.valueOf(page.getText()) - 1)).getPrice() + "");
        cb.setSelectedItem((colBook.get(Integer.valueOf(page.getText()) - 1)).getType());
    }
    //load array file
    public Book loaddata(){
        try{
            FileInputStream is = new FileInputStream("Book.dat");
            ObjectInputStream ois = new ObjectInputStream(is);
            colBook = (ArrayList<Book>) ois.readObject();
            // b = (Book) ois.readObject();
            // if (b == null){
            //     b = new Book();
            // }
            // tf_name.setText(b.getName());
            // tf_price.setText(Double.toString(b.getPrice()));
            // cb.setSelectedItem(b.getType());
            if (colBook.size() >= 1){
                page.setText("1");
                tf_name.setText((colBook.get(0).getName()));
                tf_price.setText((colBook.get(0).getPrice()) + "");
                cb.setSelectedItem((colBook.get(0).getType()));
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return b;
    }
    //save array file
    public void savedata(){
        try{
            FileOutputStream os = new FileOutputStream("Book.dat");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            // b.setName(tf_name.getText());
            // b.setPrice(Integer.parseInt(tf_price.getText()));
            // b.setType(String.valueOf(cb.getSelectedItem()));
            oos.writeObject(colBook);
            oos.close();
            os.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void addBook(Book b){
        if (b == null) throw new InvalidParameterException();
        colBook.add(b);
    }
    @Override
    public void windowOpened(WindowEvent e) { loaddata(); }
    @Override
    public void windowClosing(WindowEvent e) { savedata(); }
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
    public static void main(String[] args) {
        new BookView();
    }
}
