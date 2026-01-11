import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class lab5_4 {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Progam with JTextArea");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(3);

        final JTextArea textArea = new JTextArea(8, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton button = new JButton("Show message");
        JButton button1 = new JButton("Save");

        JPanel buttonpanel = new JPanel();
        buttonpanel.setLayout(new FlowLayout(1));
        buttonpanel.add(button1);
        buttonpanel.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                JOptionPane.showMessageDialog(frame, text, "Your message: ", 1);
            }
        });

        button1.addActionListener((e) -> {
            File f = new File("\\D:message.txt");
            PrintWriter p = null;

            try {
                p = new PrintWriter(f);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            String textsave = textArea.getText();
            p.println(textsave);
            p.close();
        });

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, "Center");
        frame.add(buttonpanel, "South");
        frame.setVisible(true);
    }
}

