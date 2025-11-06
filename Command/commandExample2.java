package pattern.Command;

import java.util.*;

interface Command {
    void execute();
    void undo();
}

class TextEditor {
    private StringBuilder content = new StringBuilder();

    public void insert(String text) {
        content.append(text);
    }

    public void delete(int n) {
        if (n <= content.length()) {
            content.delete(content.length() - n, content.length());
        }
    }

    public String getContent() {
        return content.toString();
    }

    public void show() {
        System.out.println(" 현재 내용: " + content);
    }
}

class InsertCommand implements Command {
    private TextEditor editor;
    private String text;

    public InsertCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    public void execute() {
        editor.insert(text);
    }

    public void undo() {
        editor.delete(text.length());
    }
}

class DeleteCommand implements Command {
    private TextEditor editor;
    private String deletedText;

    public DeleteCommand(TextEditor editor, int n) {
        this.editor = editor;
        this.deletedText = editor.getContent()
                                 .substring(editor.getContent().length() - n);
    }

    public void execute() {
        editor.delete(deletedText.length());
    }

    public void undo() {
        editor.insert(deletedText);
    }
}

class CommandManager {
    private Stack<Command> history = new Stack<>();

    public void pressExecute(Command command) {
        command.execute();
        history.push(command);
    }

    public void pressUndo() {
        if (!history.isEmpty()) history.pop().undo();
        else System.out.println("실행 취소할 명령이 없습니다.");
    }
}

public class  commandExample2 {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        CommandManager manager = new CommandManager();

        manager.pressExecute(new InsertCommand(editor, "Hello "));
        manager.pressExecute(new InsertCommand(editor, "World!"));
        editor.show();

        manager.pressUndo();
        editor.show();
    }
}
