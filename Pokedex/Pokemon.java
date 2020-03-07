import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Font;
import java.awt.FontMetrics;

public class Pokemon {

    private final int IMAGE_WIDTH = 250;
    private final int IMAGE_LENGTH = 250;

    private final int STRING_GAP = 18;

    Pokedex pokedex;

    ImageIcon unscaled;
    Image scale;
    ImageIcon character;

    String name;
    String category;
    String ability;
    String type;
    String weight;

    public Pokemon(Pokedex pokedex, String imageFile, String name, String category, String ability, String type,
            String weight) {
        this.pokedex = pokedex;
        unscaled = new ImageIcon(imageFile);
        this.name = name;
        this.category = category;
        this.ability = ability;
        this.type = type;
        this.weight = weight;

        resizeImage();
    }

    private void resizeImage() {
        scale = unscaled.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_LENGTH, Image.SCALE_SMOOTH);
        character = new ImageIcon(scale);
    }

    public void drawPokemon(Graphics g) {
        int backgroundXCor = pokedex.getWidth() / 20;
        int backgroundYCor = (pokedex.getHeight() / 2) - (IMAGE_LENGTH / 2) - 10;
        int textXCor = 3 * pokedex.getWidth() / 4;
        Graphics2D g2d = (Graphics2D) g;
        Font title = new Font("arial", Font.PLAIN, 24);
        Font information = new Font("arial", Font.PLAIN, 18);

        g.setColor(Color.BLACK);
        g.fillRect(backgroundXCor, backgroundYCor, IMAGE_WIDTH + 20, IMAGE_LENGTH + 20);
        character.paintIcon(pokedex, g, backgroundXCor + 10, backgroundYCor);

        g2d.setColor(Color.WHITE);

        g2d.setFont(title);
        FontMetrics fontSize = g2d.getFontMetrics();

        g2d.drawString(name, (backgroundXCor + (IMAGE_WIDTH + 20) / 2) - (fontSize.stringWidth(name) / 2),
                backgroundYCor - 22);

        g2d.setFont(information);
        fontSize = g2d.getFontMetrics();

        g2d.drawString("Type", textXCor - (fontSize.stringWidth("Type") / 2), backgroundYCor + 20);
        g2d.drawString(type, textXCor - (fontSize.stringWidth(type) / 2), (backgroundYCor + 20) + STRING_GAP);

        g2d.drawString("Category", textXCor - (fontSize.stringWidth("Category") / 2),
                backgroundYCor + 20 + (IMAGE_LENGTH / 4));
        g2d.drawString(category, textXCor - (fontSize.stringWidth(category) / 2),
                backgroundYCor + 20 + (IMAGE_LENGTH / 4) + STRING_GAP);

        g2d.drawString("Ability", textXCor - (fontSize.stringWidth("Ability") / 2),
                backgroundYCor + 20 + (IMAGE_LENGTH * 2 / 4));
        g2d.drawString(ability, textXCor - (fontSize.stringWidth(ability) / 2),
                backgroundYCor + 20 + (IMAGE_LENGTH * 2 / 4) + STRING_GAP);

        g2d.drawString("Weight", textXCor - (fontSize.stringWidth("Weight") / 2),
                backgroundYCor + 20 + (IMAGE_LENGTH * 3 / 4));
        g2d.drawString(weight, textXCor - (fontSize.stringWidth(weight) / 2),
                backgroundYCor + 20 + (IMAGE_LENGTH * 3 / 4) + STRING_GAP);
    }
}