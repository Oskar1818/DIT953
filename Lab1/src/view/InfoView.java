package view;

import production.Tuple;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InfoView extends JFrame implements IInfoObserver {

    JTextArea label = new JTextArea();

    public InfoView() {
        initComponents();
    }

    private void initComponents() {

        this.setPreferredSize(new Dimension(200,300));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        label.setEditable(false);
        this.add(label);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Center the speed frame
        this.setLocation((dim.width/2-this.getSize().width/2+500), dim.height/2-this.getSize().height/2-250);

        // Make the frame visible
        this.setVisible(true);

        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
     public void update(ArrayList<Tuple<String, Integer>> info ) {
        label.setText("");
        info.forEach( t -> label.setText(label.getText() + "\n" + t.getFst() + ": " + t.getSnd()));
    }
}
