package pattern.Composite;
import java.util.ArrayList;
import java.util.List;

abstract class FileComponent {
    public void add(FileComponent component) {
        throw new UnsupportedOperationException();
    }
    public void remove(FileComponent component) {
        throw new UnsupportedOperationException();
    }
    public FileComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void show(int indent);
}


class FileLeaf extends FileComponent {
    private String name;
    public FileLeaf(String name) { this.name = name; }

    public void show(int indent) {
        System.out.println(" ".repeat(indent) + name);
    }
}


class DirectoryComposite extends FileComponent {
    private String name;
    private List<FileComponent> children = new ArrayList<>();

    public DirectoryComposite(String name) {
        this.name = name;
    }

    @Override
    public void add(FileComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileComponent component) {
        children.remove(component);
    }

    @Override
    public FileComponent getChild(int i) {
        return children.get(i);
    }

    public void show(int indent) {
        System.out.println(" ".repeat(indent) + name);
        for (FileComponent c : children)
            c.show(indent + 2);
    }
}

public class compositeExample1 {
    public static void main(String[] args) {
        DirectoryComposite root = new DirectoryComposite("Root");
        DirectoryComposite src = new DirectoryComposite("src");
        DirectoryComposite assets = new DirectoryComposite("assets");

        FileLeaf main = new FileLeaf("Main.java");
        FileLeaf utils = new FileLeaf("Utils.java");
        FileLeaf image = new FileLeaf("logo.png");

        src.add(main);
        src.add(utils);
        assets.add(image);

        root.add(src);
        root.add(assets);

        root.show(0);
    }
}
