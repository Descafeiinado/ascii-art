package cc.staily.ascii;

import cc.staily.ascii.styles.Style;
import cc.staily.ascii.styles.graphic.GraphicallyPrintedStyle;
import cc.staily.ascii.styles.storage.StyleStorage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StyleStorage.registerStyle(new GraphicallyPrintedStyle());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input the text you want to convert to ASCII art:");

        String text = scanner.nextLine();

        for (int i = 0; i < StyleStorage.getStyles().size(); i++) {
            System.out.println("Please select the style you want to use:");
            System.out.println(i + ". " + StyleStorage.getStyle(i).getClass().getSimpleName());
        }

        int styleIndex = scanner.nextInt();

        if (styleIndex < 0 || styleIndex >= StyleStorage.getStyles().size()) {
            System.out.println("Invalid style index.");
            return;
        }

        Style style = StyleStorage.getStyle(styleIndex);
        
        if (style == null) {
            System.out.println("Invalid style.");
            return;
        }
        
        if (style instanceof GraphicallyPrintedStyle) {
            System.out.println("Please note that the graphical style may not work properly in some terminals.");
            System.out.println(style.convert(text));
        } else {
            System.out.println("Invalid style.");
        }
    }
}
