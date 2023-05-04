import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.*;

public class ChatDemo extends JFrame implements ActionListener, WindowListener{
    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private JButton btn1, btn2;
    private JPanel panel, panel1;

    private File logs;
    private String txt;

    public ChatDemo() {
        frame = new JFrame();
        textArea = new JTextArea(20, 45);
        textField = new JTextField(45);
        btn1 = new JButton("Submit");
        btn2 = new JButton("Reset");
        panel1 = new JPanel();
        textArea.setEditable(false);

        logs = new File("ChatDemo.dat");
        try{
            logs.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }

        panel = new JPanel(new BorderLayout());
        panel.add(textArea, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        panel1.add(btn1);
        panel1.add(btn2);
        panel.add(panel1, BorderLayout.SOUTH);
        frame.add(panel);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        frame.addWindowListener(this);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new ChatDemo();
    }

    public void saveText(String txt){
        try(FileWriter fw = new FileWriter(logs)){
            for(int i = 0; i < txt.length(); i++){
                fw.write(txt.charAt(i));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String loadText(){
        try(FileReader fr = new FileReader(logs)){
            int ch;
            while((ch = fr.read()) != -1){
                txt += (char) ch;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return txt;
    }
    @Override
    public void windowOpened(WindowEvent e) {
        loadText();
        textArea.setText(txt);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        txt = textArea.getText();
        saveText(txt);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(btn1)){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            System.out.println(dtf.format(LocalDateTime.now()));
            textArea.setText(textArea.getText() + dtf.format(LocalDateTime.now()) + " : " + textField.getText() + "\n");
            textField.setText("");
        }
        else if (ae.getSource().equals(btn2)){
            textArea.setText("");
            textField.setText("");
        }
    }
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
}
// import java.io.*;
// import java.util.*;

// public class ChatDemo extends JFrame implements Serializable, ActionListener {
//     private JFrame frame;
//     private JTextArea textArea;
//     private JTextField textField;
//     private JButton btn1, btn2;
//     private JPanel panel, panel1;
//     private String text;

//     public ChatDemo() {
//         try {
//             FileInputStream fileIn = new FileInputStream("savedstate.ser");
//             ObjectInputStream in = new ObjectInputStream(fileIn);
//             ChatDemo savedState = (ChatDemo) in.readObject();
//             text = savedState.textArea.getText();
//             in.close();
//             fileIn.close();
//         } catch (IOException i) {
//             text = "";
//         } catch (ClassNotFoundException c) {
//             System.out.println("ChatDemo class not found");
//             c.printStackTrace();
//             return;
//         }

//         frame = new JFrame();
//         textArea = new JTextArea(20, 45);
//         textArea.setText(text);
//         textField = new JTextField(45);
//         btn1 = new JButton("Submit");
//         btn2 = new JButton("Reset");
//         panel1 = new JPanel();
//         textArea.setEditable(false);

//         panel = new JPanel(new BorderLayout());
//         panel.add(textArea, BorderLayout.NORTH);
//         panel.add(textField, BorderLayout.CENTER);
//         panel1.add(btn1);
//         panel1.add(btn2);
//         panel.add(panel1, BorderLayout.SOUTH);
//         frame.add(panel);

//         btn1.addActionListener(this);
//         btn2.addActionListener(this);

//         frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//         frame.pack();
//         frame.setVisible(true);
//     }

//     public static void main(String[] args) {
//         new ChatDemo();
//     }

//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         if (ae.getSource().equals(btn1)) {
//             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//             System.out.println(dtf.format(LocalDateTime.now()));
//             textArea.setText(textArea.getText() + dtf.format(LocalDateTime.now()) + " : " + textField.getText() + "\n");
//             textField.setText("");
//         } else if (ae.getSource().equals(btn2)) {
//             textArea.setText("");
//             textField.setText("");
//         }
//         try {
//             FileOutputStream fileOut = new FileOutputStream("savedstate.ser");
//             ObjectOutputStream out = new ObjectOutputStream(fileOut);
//             out.writeObject(this);
//             out.close();
//             fileOut.close();
//         } catch (IOException i) {
//             i.printStackTrace();
//         }
//     }
// }
