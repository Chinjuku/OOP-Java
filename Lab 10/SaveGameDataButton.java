// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;

// public class SaveGameDataButton extends JFrame {
//     private JButton saveButton;
//     private GameData gameData;

//     public SaveGameDataButton() {
//         super("Save Game Data Button Example");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         gameData = new GameData(100, 3);

//         saveButton = new JButton("Save Game Data");
//         saveButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 JFileChooser fileChooser = new JFileChooser();
//                 int choice = fileChooser.showSaveDialog(null);
//                 if (choice == JFileChooser.APPROVE_OPTION) {
//                     File file = fileChooser.getSelectedFile();
//                     try {
//                         gameData.save(file.getAbsolutePath());
//                     } catch (IOException ex) {
//                         ex.printStackTrace();
//                     }
//                 }
//             }
//         });

//         JPanel panel = new JPanel();
//         panel.add(saveButton);
//         getContentPane().add(panel);

//         setSize(300, 100);
//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         new SaveGameDataButton();
//     }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaveGameDataButton extends JFrame {
    private JButton saveButton;
    private GameData gameData;

    public SaveGameDataButton() {
        super("Save Game Data Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameData = new GameData();

        saveButton = new JButton("Save Game Data");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // gameData.saveScore(100);
                // gameData.saveLevel(3);
                // gameData.savePosition(10.0, 20.0);
            }
        });

        JPanel panel = new JPanel();
        panel.add(saveButton);
        getContentPane().add(panel);

        setSize(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SaveGameDataButton();
    }
}



