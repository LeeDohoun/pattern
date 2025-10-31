package pattern.Decorator;
abstract class TextComponent {
    public abstract void display();
}

class PlainText extends TextComponent {
    private String content;
    public PlainText(String content) { this.content = content; }
    public void display() {
        System.out.print(content);
    }
}

abstract class TextDecorator extends TextComponent {
    protected TextComponent text;
    public TextDecorator(TextComponent text) {
        this.text = text;
    }
    public void display() {
        text.display();
    }
}

class BoldDecorator extends TextDecorator {
    public BoldDecorator(TextComponent text) { super(text); }
    public void display() {
        System.out.print("<b>");
        super.display();
        System.out.print("</b>");
    }
}

class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(TextComponent text) { super(text); }
    public void display() {
        System.out.print("<i>");
        super.display();
        System.out.print("</i>");
    }
}

class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(TextComponent text) { super(text); }
    public void display() {
        System.out.print("<u>");
        super.display();
        System.out.print("</u>");
    }
}

public class decoratorExample2 {
    public static void main(String[] args) {
        TextComponent text = new PlainText("Hello, World!");
        TextComponent decorated = new BoldDecorator(
                                      new UnderlineDecorator(
                                          new ItalicDecorator(text)));
        decorated.display();
    }
}
