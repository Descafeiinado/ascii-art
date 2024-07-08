package cc.staily.ascii.styles.graphic;

import cc.staily.ascii.styles.Style;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicallyPrintedStyle implements Style {
    @Override
    public String convert(String text) {
        int WIDTH = 300;
        int HEIGHT = 100;

        String fixedText = text.replaceAll("", " ").trim();

        StringBuilder finalAscii = new StringBuilder("\n");

        BufferedImage bufferedImage = new BufferedImage(
                WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.drawString(fixedText, 12, 24);

        for (int y = 0; y < HEIGHT; y++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int x = 0; x < WIDTH; x++) {
                stringBuilder.append(bufferedImage.getRGB(x, y) == -16777216 ? " " : "*");
            }
            if (stringBuilder.toString().trim().isEmpty()) {
                continue;
            }

            finalAscii.append(stringBuilder).append("\n");
        }

        return finalAscii.toString();
    }
}
