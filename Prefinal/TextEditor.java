import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;

public class TextEditor implements ActionListener{
    private JFrame fr;
    // private JPanel pn;
    private JMenuBar mb;
    private JMenu mn;
    private JMenuItem mt1, mt2, mt3, mt4;
    private JTextArea ta;
    private String txt;
    // private JSeparator sp;

    public TextEditor(){
        fr = new JFrame("My Text Editor");
        mb = new JMenuBar();
        mn = new JMenu("File");
        mt1 = new JMenuItem("New");
        mt2 = new JMenuItem("Open");
        mt3 = new JMenuItem("Save");
        mt4 = new JMenuItem("Close");
        // sp = new JSeparator();
        ta = new JTextArea();

        mb.add(mn);
        mn.add(mt1);
        mn.add(mt2);
        mn.add(mt3);
        mn.addSeparator();
        mn.add(mt4);
        fr.add(mb, BorderLayout.NORTH);
        fr.add(ta, BorderLayout.CENTER);

        mt1.addActionListener(this);
        mt2.addActionListener(this);
        mt3.addActionListener(this);
        mt4.addActionListener(this);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 300);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new TextEditor();
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(mt1)){
            ta.setText("");
        } else if(ae.getSource().equals(mt2)){
            Open();
        } else if(ae.getSource().equals(mt3)){
            Save();
        } else if(ae.getSource().equals(mt4)){
            fr.dispose();
        }
    }
    //Class TextEditor Save / Load File txt
    public String Open(){
        String txt = "";
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(fr); // fr คือ ตัวแปรออปเจ็ค JFrame
        File f = fc.getSelectedFile();
        System.out.println("getfile");
        try{ FileReader fr = new FileReader(f);
            int ch;
            while((ch = fr.read()) != -1){
                txt += (char) ch;
            }
            // txt += (char) fr.read();
            ta.setText(txt);
            fr.close();
        } catch (IOException | NullPointerException e){
            e.printStackTrace();
        }
        return txt;
    }
    public void Save(){
        JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(fr); // fr คือ ตัวแปรออปเจ็ค JFrame
            File f = fc.getSelectedFile();
        try{ FileWriter fw = new FileWriter(f);
            fw.write(ta.getText());
            fw.close();
        } catch(IOException | NullPointerException e){
            e.printStackTrace();
        }
    }
}
