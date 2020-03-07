import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;


public class Monster extends Element {
    String color = "#FF0000";

    Monster(int x, int y){
        super(x,y);
    }

    public Position move(){
        Random random = new Random();
        int i = random.nextInt(4);
        switch (i){
            case 0:
                return moveUp();
            case 1:
                return moveDown();
            case 2:
                return moveLeft();
            default:
                return moveRight();
        }
    }

    public void setPosition(Position position){
        this.position = position;
    }

    private Position moveUp(){
        return new Position(position.getX(), position.getY() - 1);
    }

    private Position moveDown(){
        return new Position(position.getX(), position.getY() + 1);
    }

    private Position moveRight(){
        return new Position(position.getX() + 1, position.getY());
    }

    private Position moveLeft(){
        return new Position(position.getX() - 1, position.getY());
    }

    public Position getPosition(){
        return position;
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "Y");
    }
}
