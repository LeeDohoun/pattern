package pattern.Singletone;

class LogManager {
    private static LogManager instance;

    
    private LogManager() {}

    public static LogManager getInstance() {
        if (instance == null) {
            synchronized (LogManager.class) {
                if (instance == null) {
            instance = new LogManager();
            System.out.println("로그 관리자 생성됨.");
        }
            }
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

public class singletonExample1 {
    public static void main(String[] args) {
        LogManager log1 = LogManager.getInstance();
        log1.log("서버 시작");

        LogManager log2 = LogManager.getInstance();
        log2.log("DB 연결 성공");

        System.out.println("log1과 log2는 같은 인스턴스 인가? => " + (log1 == log2));
    }
}
