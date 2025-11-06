package pattern.State;

interface TrafficLightState {
    void handleCar();
}

class RedState implements TrafficLightState {
    public void handleCar() {
        System.out.println("빨간불 -> 차량 정지!");
    }
}

class GreenState implements TrafficLightState {
    public void handleCar() {
        System.out.println("초록불 -> 차량 출발!");
    }
}

class YellowState implements TrafficLightState {
    public void handleCar() {
        System.out.println("노란불 -> 서행 준비!");
    }
}

class TrafficLightCar {
    private TrafficLightState state;

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void performAction() {
        state.handleCar();
    }
}

public class stateExample1 {
    public static void main(String[] args) {
        TrafficLightCar light = new TrafficLightCar();

        light.setState(new RedState());
        light.performAction();

        light.setState(new GreenState());
        light.performAction();

        light.setState(new YellowState());
        light.performAction();
    }
}
