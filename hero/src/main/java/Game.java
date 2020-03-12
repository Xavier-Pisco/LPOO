import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;
    private Arena arena = new Arena(70, 20);
    TextGraphics graphics;

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            graphics = screen.newTextGraphics();

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw(){
        screen.clear();
        arena.draw(screen.newTextGraphics());
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        KeyStroke key = null;
        while(true) {
            draw();
            try {
                key = screen.readInput();
                arena.processKey(key);
                if (!arena.alive) {
                    screen.close();
                    System.out.println("Game Lost \n");
                }
                if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')) screen.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (key.getKeyType() == KeyType.EOF) break;
        }
    }


}
