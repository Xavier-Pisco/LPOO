public class Ellipse implements AreaShape {
    private int xradius, yradius;

    public Ellipse(int xradius, int yradius) {
        this.xradius = xradius;
        this.yradius = yradius;
    }

    public int getXradius() {
        return xradius;
    }

    public int getYradius() {
        return yradius;
    }

    @Override
    public double getArea() {
        return Math.PI * xradius * yradius;
    }

    @Override
    public void draw() {
        System.out.println(this.getClass());
    }
}
