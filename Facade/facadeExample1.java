package pattern.Facade;

class Light {
    public void on() { System.out.println(" 조명이 켜졌습니다."); }
    public void off() { System.out.println(" 조명이 꺼졌습니다."); }
}

class AirConditioner {
    public void start() { System.out.println(" 에어컨 작동 시작."); }
    public void stop() { System.out.println(" 에어컨 작동 종료."); }
}

class Computer {
    public void boot() { System.out.println(" 컴퓨터 부팅 중..."); }
    public void shutdown() { System.out.println(" 컴퓨터 종료."); }
}

class Curtain {
    public void open() { System.out.println(" 커튼을 엽니다."); }
    public void close() { System.out.println("커튼을 닫습니다."); }
}


class OfficeFacade {
    private Light light;
    private AirConditioner ac;
    private Computer pc;
    private Curtain curtain;

    public OfficeFacade(Light light, AirConditioner ac, Computer pc, Curtain curtain) {
        this.light = light;
        this.ac = ac;
        this.pc = pc;
        this.curtain = curtain;
    }

    public void startWork() {
        System.out.println("\n=== 출근 모드 ===");
        curtain.open();
        light.on();
        ac.start();
        pc.boot();
    }

    public void endWork() {
        System.out.println("\n=== 퇴근 모드 ===");
        pc.shutdown();
        ac.stop();
        light.off();
        curtain.close();
    }
}

public class facadeExample1 {
    public static void main(String[] args) {
        OfficeFacade office = new OfficeFacade(
            new Light(), new AirConditioner(), new Computer(), new Curtain()
        );

        office.startWork();
        office.endWork();
    }
}
