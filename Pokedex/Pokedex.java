import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pokedex extends JPanel implements ActionListener {

    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    private final int BUTTON_SIZE = 45;

    private final String FILE_PATH = "Images/";

    private Pokemon[] pokemon;
    private int index;

    private JButton topButton;
    private JButton bottomButton;

    public Pokedex() {
        index = 0;

        initializePokemon();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initializeButtons();
        setLayout();
    }

    private void initializeButtons() {
        topButton = new JButton();
        bottomButton = new JButton();

        topButton.addActionListener(this);
        bottomButton.addActionListener(this);

        topButton.setMaximumSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
        bottomButton.setMaximumSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));

        topButton.setIcon(new ImageIcon(new ImageIcon(FILE_PATH + "UpArrow.png").getImage()
                .getScaledInstance(BUTTON_SIZE, BUTTON_SIZE, Image.SCALE_SMOOTH)));
        bottomButton.setIcon(new ImageIcon(new ImageIcon(FILE_PATH + "DownArrow.png").getImage()
                .getScaledInstance(BUTTON_SIZE, BUTTON_SIZE, Image.SCALE_SMOOTH)));

        topButton.setBackground(Color.RED);
        topButton.setBorder(BorderFactory.createLineBorder(Color.RED));
        bottomButton.setBackground(Color.RED);
        bottomButton.setBorder(BorderFactory.createLineBorder(Color.RED));

        topButton.setEnabled(false);
    }

    private void setLayout() {
        setBackground(Color.RED);
        setBorder(BorderFactory.createEmptyBorder(0, WIDTH / 2 - BUTTON_SIZE / 2, 0, 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(topButton);
        add(Box.createRigidArea(new Dimension(0, HEIGHT - (60 + BUTTON_SIZE * 2))));
        add(bottomButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        pokemon[index].drawPokemon(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkClick(e);
        repaint();
    }

    private void checkClick(ActionEvent e) {
        if (e.getSource() == topButton) {
            index--;
        }
        if (e.getSource() == bottomButton) {
            index++;
        }
        disableButtons();
    }

    private void disableButtons() {
        if (index == 0) {
            topButton.setEnabled(false);
        } else {
            topButton.setEnabled(true);
        }

        if (index == pokemon.length - 1) {
            bottomButton.setEnabled(false);
        } else {
            bottomButton.setEnabled(true);
        }
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    private void initializePokemon() {
        pokemon = new Pokemon[] {
                new Pokemon(this, FILE_PATH + "Bulbasaur.png", "Bulbasaur", "Seed", "Overgrow", "Grass + Poison",
                        "15.2 lbs"),
                new Pokemon(this, FILE_PATH + "Ivysaur.png", "Ivysaur", "Seed", "Overgrow", "Grass + Poison",
                        "28.7 lbs"),
                new Pokemon(this, FILE_PATH + "Venasaur.png", "Venasaur", "Seed", "Overgrow", "Grass + Poison",
                        "220.5 lbs"),
                new Pokemon(this, FILE_PATH + "Charmander.png", "Charmander", "Lizard", "Blaze", "Fire", "18.7 lbs"),
                new Pokemon(this, FILE_PATH + "Charmeleon.png", "Charmeleon", "Flame", "Blaze", "Fire", "41.9 lbs"),
                new Pokemon(this, FILE_PATH + "Charizard.png", "Charizard", "Flame", "Blaze", "Fire + Flying",
                        "199.5 lbs"),
                new Pokemon(this, FILE_PATH + "Squirtle.png", "Squirtle", "Tiny Turtle", "Torrent", "Water",
                        "19.8 lbs"),
                new Pokemon(this, FILE_PATH + "Wartortle.png", "Wartortle", "Turtle", "Torrent", "Water", "49.6 lbs"),
                new Pokemon(this, FILE_PATH + "Blastoise.png", "Blastoise", "Shellfish", "Torrent", "Water",
                        "188.5 lbs") };
    }
}