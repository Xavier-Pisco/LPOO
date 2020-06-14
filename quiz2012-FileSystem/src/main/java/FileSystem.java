public class FileSystem {
    private String type;
    private Folder root;
    private NameFormatter nameFormatter;

    public FileSystem(String type) {
        this.type = type;
        root = new Folder();
    }

    public String getType() {
        return type;
    }

    public Folder getRoot() {
        return root;
    }

    public void setNameFormatter(NameFormatter nameFormatter) {
        root.setNameFormatter(nameFormatter);
        this.nameFormatter = nameFormatter;
    }
}
