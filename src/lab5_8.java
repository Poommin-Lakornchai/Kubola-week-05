import java.awt.BorderLayout;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class lab5_8 {
    static File currentFile = null;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Poommin Lakornchai 68160041 n74");
        frame.setLocationRelativeTo((Component)null);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(3);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");

        JMenuItem newf = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem save_as = new JMenuItem("Save as");
        JMenuItem exit = new JMenuItem("Exit");

        menu.add(newf);
        menu.add(open);
        menu.add(save);
        menu.add(save_as);
        menu.add(exit);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        JTextArea textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, "Center");

        newf.addActionListener((e) -> {
            currentFile = null;
            textArea.setText("");
        });

        open.addActionListener((e) -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == 0) {
                File file = fileChooser.getSelectedFile();

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    textArea.setText("");

                    String line;
                    while((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }

                    reader.close();
                } catch (IOException var8) {
                    JOptionPane.showMessageDialog(frame, "Cannot read file.", "Error", 0);
                }
            }

        });

        save.addActionListener((e) -> {
            if (currentFile == null) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result != 0) {
                    return;
                }

                currentFile = fileChooser.getSelectedFile();
            }

            try {
                PrintWriter writer = new PrintWriter(currentFile);
                writer.write(textArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(frame, "Save file successfully.");
            } catch (IOException var5) {
                JOptionPane.showMessageDialog(frame, "Error. Unable to save file.");
            }

        });

        save_as.addActionListener((e) -> {
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

        exit.addActionListener(e->{
            System.exit(0);
        });
        frame.setVisible(true);
    }
}