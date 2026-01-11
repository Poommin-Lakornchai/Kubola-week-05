import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class lab5_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI with Menu");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo((Component)null);
        frame.setDefaultCloseOperation(3);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCalculate = new JMenu("Calculate");
        JMenu menuOther = new JMenu("Others");

        JMenuItem itemAdd = new JMenuItem("Add");
        JMenuItem itemSub = new JMenuItem("Subtract");
        JMenuItem itemMultiplies = new JMenuItem("Multiplies");
        JMenuItem itemName = new JMenuItem("Greeting");
        JMenuItem itemExit = new JMenuItem("Quit");

        menuCalculate.add(itemAdd);
        menuCalculate.add(itemSub);
        menuCalculate.add(itemMultiplies);
        menuOther.add(itemName);
        menuOther.addSeparator();
        menuOther.add(itemExit);
        menuBar.add(menuCalculate);
        menuBar.add(menuOther);
        frame.setJMenuBar(menuBar);

        itemAdd.addActionListener((e) -> {
            int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Adding result = " + (a + b));
        });

        itemSub.addActionListener((e) -> {
            int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Subtract result = " + (a - b));
        });

        itemMultiplies.addActionListener((e) -> {
            int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Multiple result = " + a * b);
        });

        itemName.addActionListener((e) -> {
            String name = JOptionPane.showInputDialog(frame, "Enter name");
            JOptionPane.showMessageDialog(frame, "Hello " + name);
        });

        itemExit.addActionListener((e) -> System.exit(0));
        frame.setVisible(true);
    }
}
