package pattern.Composite;

import java.util.*;


abstract class UIComponent {
    public void add(UIComponent component) {
        throw new UnsupportedOperationException();
    }
    public void remove(UIComponent component) {
        throw new UnsupportedOperationException();
    }
    public UIComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void render(int indent);
}


class Button extends UIComponent {
    private String label;
    public Button(String label) { this.label = label; }

    public void render(int indent) {
        System.out.println(" ".repeat(indent) + "Button: " + label);
    }
}


class Text extends UIComponent {
    private String content;
    public Text(String content) { this.content = content; }

    public void render(int indent) {
        System.out.println(" ".repeat(indent) + "Text: \"" + content + "\"");
    }
}


class Panel extends UIComponent {
    private String name;
    private List<UIComponent> children = new ArrayList<>();

    public Panel(String name) {
        this.name = name;
    }

    @Override
    public void add(UIComponent c) {
        children.add(c);
    }

    @Override
    public void remove(UIComponent c) {
        children.remove(c);
    }

    @Override
    public UIComponent getChild(int i) {
        return children.get(i);
    }

    public void render(int indent) {
        System.out.println(" ".repeat(indent) + "Panel: " + name);
        for (UIComponent c : children)
            c.render(indent + 2);
    }
}

public class compositeExample2 {
    public static void main(String[] args) {
        Panel mainWindow = new Panel("Main Window");
        Panel header = new Panel("Header");
        Panel footer = new Panel("Footer");

        Button loginBtn = new Button("Login");
        Button signupBtn = new Button("Sign Up");
        Text copyright = new Text("2025 MyApp");

        header.add(loginBtn);
        header.add(signupBtn);
        footer.add(copyright);

        mainWindow.add(header);
        mainWindow.add(footer);

        mainWindow.render(0);
    }
}
