import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.io.*;

public class SaveMoneyDataButton extends JFrame {
    private JButton saveButton, moneyButton;
    private JLabel moneyLabel;
    private MoneyData moneyData;
    private File dataFile;

    public SaveMoneyDataButton() {
        super("Save Money Data Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        moneyData = new MoneyData();

        dataFile = new File("moneydata.dat");
        if (dataFile.exists()) {
            loadMoneyData();
        }

        saveButton = new JButton("Save Money Data");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moneyData.saveMoney(new BigDecimal("100.00"));
                moneyLabel.setText("Money: " + moneyData.getMoney().toString());
                saveMoneyData();
            }
        });

        moneyLabel = new JLabel("Money: " + moneyData.getMoney().toString());

        JPanel panel = new JPanel();
        panel.add(saveButton);
        panel.add(moneyLabel);
        getContentPane().add(panel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                saveMoneyData();
            }
        });

        setSize(300, 100);
        setVisible(true);
    }

    private void saveMoneyData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile));
            oos.writeObject(moneyData);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadMoneyData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile));
            moneyData = (MoneyData) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SaveMoneyDataButton();
    }
}

