import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width, height;
    private Hero hero = new Hero(10,10);
    private String color = "#005599";
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    public boolean alive = true;

    public Arena(int w, int h){
        width = w;
        height = h;
        walls = createWalls();
        monsters = createMonsters();
        coins = createCoins();
    }

    private List<Monster> createMonsters(){
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        int x = 0,y = 0;
        for (int i = 0; i < 5; i++){
            x = random.nextInt(width - 2) + 1;
            y = random.nextInt(height - 2) + 1;
            Position p = new Position(x,y);
            if (!p.equals(hero.getPosition())) {
                monsters.add(new Monster(x,y));
            } else {
                i--;
            }

        }
        return monsters;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        int x = 0,y = 0;
        boolean intercept;
        for (int i = 0; i < 5; i++){
            intercept = false;
            x = random.nextInt(width - 2) + 1;
            y = random.nextInt(height - 2) + 1;
            Position p = new Position(x,y);
            if (!p.equals(hero.getPosition())) {
                for (Coin coin: coins){
                    if (coin.getPosition().equals(p)){
                        intercept = true;
                    }
                }
                for (Monster monster: monsters){
                    if (monster.getPosition().equals(p)){
                        intercept = true;
                    }
                }
                if (intercept){
                    i--;
                } else {
                    coins.add(new Coin(x,y));
                }
            } else {
                i--;
            }

        }
        return coins;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()){
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            default:
                break;
        }
    }

    private void moveHero(Position position){
        Position p;
        if (canMove(position)){
            hero.setPosition(position);
            removeCoin(position);
        }
        for (Monster monster:monsters){
            p = monster.move();
            if (canMove(p)){
                monster.setPosition(p);
            }
        }
        for (Monster monster:monsters){
            if (monster.getPosition().equals(hero.getPosition())) alive = false;
        }
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height), ' ');

        for (Coin coin: coins){
            coin.draw(graphics);
        }

        hero.draw(graphics);

        for (Wall wall: walls){
            wall.draw(graphics);
        }

        for (Monster monster: monsters){
            monster.draw(graphics);
        }
    }

    private boolean canMove(Position position){

        if (!(position.getX() < width && position.getY() < height && position.getX() > 0 && position.getY() > 0))
            return false;

        for (Wall wall: walls){
            if (position.equals(wall.position)) return false;
        }
        return true;
    }

    private void removeCoin(Position position){
        for (Coin coin: coins){
            if (coin.getPosition().equals(hero.getPosition())){
                coins.remove(coin);
                break;
            }
        }
    }

    private boolean verifyMonsterCollisions(){
        for (Monster monster: monsters){
            if (monster.getPosition().equals(hero.getPosition())) return false;
        }
        return true;
    }
}
