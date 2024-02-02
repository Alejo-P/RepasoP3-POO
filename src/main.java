import javax.swing.*;

public class main {
    public static void main (String [] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setContentPane(new Pantalla1().Pantalla1);
        frame.pack();
        frame.setVisible(true);
    }
}
