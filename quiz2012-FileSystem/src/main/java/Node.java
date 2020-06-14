import java.util.Objects;

public abstract class Node {
    protected Folder parent;
    protected String name;
    protected int size;
    private static int number;
    private NameFormatter nameFormatter;

    public Node(Folder parent, String name) {
        this.parent = parent;
        this.name = name;
        this.size = 0;
        if (parent != null) this.nameFormatter = parent.getNameFormatter();
    }

    public Node(Folder parent, String name, int size) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        if (parent != null) this.nameFormatter = parent.getNameFormatter();
    }

    public static void resetNumbering(int i) {
        number = i;
    }


    public Folder getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return ++number;
    }

    public NameFormatter getNameFormatter() {
        return nameFormatter;
    }

    public abstract int getSize();

    public String getPath(){
        return (parent == null ? "" : parent.getPath() + nameFormatter.getSeparator() + name);
    }

    public void setNameFormatter(NameFormatter nameFormatter) {
        this.nameFormatter = nameFormatter;
    }

    public abstract Node clone(Folder f, String name) throws DuplicateNameException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, name);
    }

    public void move(Folder parent, String name) throws CycleException {
        Folder p = parent;

        if (this instanceof Folder) {
            while (p.getParent() != null && p.getParent().getName() != null) {
                if (p.getParent().equals(this)) throw new CycleException();
                p = p.getParent();
            }
        }
        this.parent = parent;
        this.name = name;
    }
}
