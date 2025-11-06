package pattern.Command;

import java.util.*;

interface Command {
    void execute();
    void undo();
}

class Light {
    public void on() { System.out.println("조명이 켜졌습니다."); }
    public void off() { System.out.println("조명이 꺼졌습니다."); }
}

class AirConditioner {
    public void turnOn() { System.out.println("에어컨이 작동합니다."); }
    public void turnOff() { System.out.println("에어컨이 꺼졌습니다."); }
}

class Curtain {
    public void open() { System.out.println("커튼이 열렸습니다."); }
    public void close() { System.out.println("커튼이 닫혔습니다."); }
}

class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.on(); }
    public void undo() { light.off(); }
}

class ACOnCommand implements Command {
    private AirConditioner ac;
    public ACOnCommand(AirConditioner ac) { this.ac = ac; }
    public void execute() { ac.turnOn(); }
    public void undo() { ac.turnOff(); }
}

class CurtainOpenCommand implements Command {
    private Curtain curtain;
    public CurtainOpenCommand(Curtain curtain) { this.curtain = curtain; }
    public void execute() { curtain.open(); }
    public void undo() { curtain.close(); }
}

class SmartHomeController {
    private Stack<Command> history = new Stack<>();
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        command.execute();
        history.push(command);
    }
    public void pressUndo() {
        if (!history.isEmpty()) history.pop().undo();
        else System.out.println("실행 취소할 명령이 없습니다.");
    }
}

public class commandExample1 {
    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();

        Light light = new Light();
        AirConditioner ac = new AirConditioner();
        Curtain curtain = new Curtain();

        controller.setCommand(new LightOnCommand(light));
        controller.pressButton();

        controller.setCommand(new ACOnCommand(ac));
        controller.pressButton();

        controller.setCommand(new CurtainOpenCommand(curtain));
        controller.pressButton();

        controller.pressUndo();
        controller.pressUndo();
    }
}
