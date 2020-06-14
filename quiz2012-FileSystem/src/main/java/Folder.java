import java.util.Arrays;

public class Folder extends Node{
    private Node[] child;

    public Folder(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
        child = new Node[0];
        if (parent != null) parent.addChild(this);
    }

    @Override
    public int getSize() {
        int result = 0;
        for (Node node: child) result += node.getSize();
        return result;
    }

    public Folder() {
        super(null, null);
        child = new Node[0];
    }

    public void addChild(Node n) throws DuplicateNameException {
        Node[] result = new Node[child.length + 1];

        int i;
        for (i = 0; i < child.length; i++) {
            if (child[i].getName().equals(n.getName())) throw new DuplicateNameException();
            result[i] = child[i];
        }
        result[i] = n;
        child = result;
    }

    public Node[] getChild() {
        return child;
    }

    public Node getChildByName(String bin) {
        for (Node n: child)
            if (n.getName().equals(bin)) return n;

        return null;
    }

    @Override
    public void setNameFormatter(NameFormatter nameFormatter) {
        super.setNameFormatter(nameFormatter);
        for (Node node: child) node.setNameFormatter(nameFormatter);
    }

    public Folder clone(Folder f, String name) throws DuplicateNameException {
        Folder folder = new Folder(f, name);
        for (Node n: child) n.clone(folder, n.getName());
        return folder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Folder)) return false;
        if (!super.equals(o)) return false;
        Folder folder = (Folder) o;
        return Arrays.equals(child, folder.child);
    }
}
