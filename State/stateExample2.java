package pattern.State;


interface PlayerState {
    void Play(MusicPlayer player);
    void Stop(MusicPlayer player);
}


class PlayingState implements PlayerState {
    public void Play(MusicPlayer player) {
        System.out.println("음악을 일시정지합니다.");
        player.setState(new PausedState());
    }

    public void Stop(MusicPlayer player) {
        System.out.println("음악 재생을 중지합니다.");
        player.setState(new StoppedState());
    }
}

class PausedState implements PlayerState {
    public void Play(MusicPlayer player) {
        System.out.println("음악을 다시 재생합니다.");
        player.setState(new PlayingState());
    }

    public void Stop(MusicPlayer player) {
        System.out.println("음악 재생을 완전히 중지합니다.");
        player.setState(new StoppedState());
    }
}

// 구체 상태 3: 정지
class StoppedState implements PlayerState {
    public void Play(MusicPlayer player) {
        System.out.println("음악을 재생합니다.");
        player.setState(new PlayingState());
    }

    public void Stop(MusicPlayer player) {
        System.out.println("이미 정지된 상태입니다.");
    }
}

// Context
class MusicPlayer {
    private PlayerState state;

    public MusicPlayer() {
        state = new StoppedState();
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void pressPlay() {
        state.Play(this);
    }

    public void pressStop() {
        state.Stop(this);
    }
}

public class stateExample2 {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.pressPlay();
        player.pressPlay();
        player.pressPlay();
        player.pressStop();
        player.pressStop();
    }
}
