public class Triangle implements AreaShape {
    private int base, height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return base*height/2;
    }

    @Override
    public void draw() {
        System.out.println(this.getClass());
    }
}
