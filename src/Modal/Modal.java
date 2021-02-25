package Modal;

import javax.swing.*;

public class Modal extends JDialog {


    public Modal( JFrame parent, String title, String message ) {

        super(parent, title, true);
      
        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);


        panel.add(label);
        getContentPane().add(panel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void render(JFrame parent, String title, String message) {
        new Modal(parent, title, message);
    }

}