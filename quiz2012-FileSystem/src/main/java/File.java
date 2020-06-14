public class File extends Node {
    public File(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
        if (parent != null) parent.addChild(this);
    }

    public File(Folder parent, String name, int size) throws DuplicateNameException {
        super(parent, name, size);
        if (parent != null) parent.addChild(this);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Node clone(Folder f, String name) throws DuplicateNameException {
        return new File(f, name, size);
    }


}
