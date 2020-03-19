public class Rectangle implements AreaShape{
    private int x,y;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println(this.getClass());
    }

    @Override
    public double getArea() {
        return x*y;
    }
}
