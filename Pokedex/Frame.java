import javax.swing.JFrame;

import java.awt.EventQueue;

public class Frame {

    JFrame frame;

    public Frame() {
        frame = new JFrame("Pokedex");

        initializeFrame();
    }

    private void initializeFrame() {
        frame.add(new Pokedex());
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Frame frame = new Frame();
            }
        });
    }
}