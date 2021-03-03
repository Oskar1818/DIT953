package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import production.Production.*;
import static production.Production.production;


public class InfoView extends JFrame implements IObserver{


    JTextArea label = new JTextArea();
    HashMap<String, Integer> information = production().getInformation();

    public InfoView() {
        initComponents();
    }


    private void initComponents() {

        this.setPreferredSize(new Dimension(200,100));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        label.setEditable(false);
        this.add(label);


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        // Make the frame visible
        this.setVisible(true);

        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void update() {
        label.setText("");
        information.forEach( (name, speed) -> label.setText(label.getText() + "\n" + name + ": " + speed));
    }
}
