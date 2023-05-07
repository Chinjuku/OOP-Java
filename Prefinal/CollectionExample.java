import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CollectionExample {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> comboBox;
    private JButton addButton;
    private List<String> itemList;

    public CollectionExample() {
        frame = new JFrame("Collection Example");
        panel = new JPanel();
        comboBox = new JComboBox<>();
        addButton = new JButton("Add Item");
        itemList = new ArrayList<>();

        panel.add(comboBox);
        panel.add(addButton);

        addButton.addActionListener(e -> {
            String newItem = JOptionPane.showInputDialog(frame, "Enter a new item:");
            if (newItem != null && !newItem.isEmpty()) {
                itemList.add(newItem);
                comboBox.addItem(newItem);
            }
        });

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CollectionExample();
    }
}
