package pattern.Singletone;

class DatabaseConnectionPool {
    private static DatabaseConnectionPool instance;

    private DatabaseConnectionPool() {
        System.out.println("DB 연결 풀 생성됨.");
    }

    public static DatabaseConnectionPool getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionPool.class) {
                if (instance == null) { 
                    instance = new DatabaseConnectionPool();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("데이터베이스 연결 중...");
    }

    public void disconnect() {
        System.out.println("데이터베이스 연결 해제");
    }
}

public class singletonExample2 {
    public static void main(String[] args) {
        DatabaseConnectionPool pool1 = DatabaseConnectionPool.getInstance();
        pool1.connect();

        DatabaseConnectionPool pool2 = DatabaseConnectionPool.getInstance();
        pool2.disconnect();

        System.out.println("pool1와 pool2는 같은 인스턴스 인가? => " + (pool1 == pool2));
    }
}
