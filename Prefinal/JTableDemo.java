import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class JTableDemo {
    private JFrame fr;
    private JScrollPane scrollPane;
    private JTable table;
    public JTableDemo() {
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(100, 100, 580, 242);
        fr.setTitle("Demo JTable");
        fr.getContentPane().setLayout(null);
        // ScrollPane for Table
        scrollPane = new JScrollPane();
        scrollPane.setBounds(41, 41, 494, 90);
        fr.getContentPane().add(scrollPane);
        // Table
        table = new JTable();
        scrollPane.setViewportView(table);
        // Model for Table
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addColumn("No");
        model.addColumn("CustomerID");
        model.addColumn("Name");
        model.addColumn("Email");
        // model.addColumn("CountryCode");
        // Data Row
        for(int i=0;i <= 10; i++) {
        model.addRow(new Object[0]);
        model.setValueAt(i+1, i, 0);
        model.setValueAt("", i, 1);
        model.setValueAt("Data Col 2", i, 2);
        model.setValueAt("Data Col 3", i, 3);
        // model.setValueAt("Data Col 4", i, 4);
        }
        fr.setVisible(true);
        }
        public static void main(String[] args) { new JTableDemo(); }
}
