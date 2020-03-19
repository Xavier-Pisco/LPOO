public class Line implements Shape{
    private int length;

    public Line(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void draw() {
        System.out.println(this.getClass());
    }
}
