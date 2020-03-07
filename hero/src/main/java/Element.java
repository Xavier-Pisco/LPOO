import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {

    protected Position position;

    public Element(int x, int y){
        position = new Position(x,y);
    }

    public abstract void draw(TextGraphics graphics);

}
