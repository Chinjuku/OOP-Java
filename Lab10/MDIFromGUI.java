
import java.awt.*;
import javax.swing.*;
public class MDIFromGUI extends JFrame{
    private JFrame fr;
    // private JPanel p;
    private JMenuBar mb;
    private JInternalFrame if1, if2 ,if3;
    private JDesktopPane dp;
    private JMenu m1, m2, m3, ms1;
    private JMenuItem mi2, mi3, mi4, msi1, msi2;
    public MDIFromGUI(){
        fr = new JFrame("SubMenuItem Demo");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // p = new JPanel();
        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("View");
        fr.setJMenuBar(mb);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        ms1 = new JMenu("New");
        mi2 = new JMenuItem("Open");
        mi3 = new JMenuItem("Save");
        mi4 = new JMenuItem("Exit");
        m1.add(ms1);
        m1.add(mi2);
        m1.addSeparator();
        m1.add(mi3);
        m1.addSeparator();
        m1.add(mi4);
        msi1 = new JMenuItem("Window");
        msi2 = new JMenuItem("Massage");
        ms1.add(msi1);
        ms1.addSeparator();
        ms1.add(msi2);
        // fr.add(p);
        dp = new JDesktopPane();
        dp.setBackground(Color.BLACK);
        if1 = new JInternalFrame("Application 01", true, true, true, true);
        if1.setBounds(50, 100, 300, 300);
        if1.setVisible(true);

        if2 = new JInternalFrame("Application 02", true, true, true, true);
        if2.setBounds(500, 500, 300, 300);
        if2.setVisible(true);
        
        if3 = new JInternalFrame("Application 03", true, true, true, true);
        if3.setBounds(1000, 600, 300, 300);
        if3.setVisible(true);

        // if1.setLocation(80, 30);
        // if2.setLocation(10, 5);
        // if3.setLocation(30, 50);
        dp.add(if1);
        dp.add(if2);
        dp.add(if3);
        
        fr.add(dp);
        fr.setSize(1500, 1000);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        new MDIFromGUI();
        }
}
