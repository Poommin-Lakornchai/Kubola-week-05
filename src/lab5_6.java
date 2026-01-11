import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class lab5_6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Save File with JFileChooser");
        frame.setLocationRelativeTo((Component)null);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(3);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem save = new JMenuItem("Save File");
        JMenuItem exit = new JMenuItem("Exit");

        menu.add(save);
        menu.add(exit);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        JTextArea textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);

        save.addActionListener((e) -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(frame);
            if (result == 0) {
                File file = fileChooser.getSelectedFile();

                try {
                    PrintWriter writer = new PrintWriter(file);
                    writer.write(textArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Save file successfully.");
                } catch (IOException var7) {
                    JOptionPane.showMessageDialog(frame, "Error. Unable to save file.");
                }
            }

        });

        exit.addActionListener((e) -> System.exit(0));
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, "Center");
        frame.setVisible(true);
    }
}
