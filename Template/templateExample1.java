package pattern.Template;

abstract class AbstractDownloader {
 
    public final void downloadFile() {
        connect();
        authenticate();
        transfer();
        save();
        System.out.println("다운로드 완료!\n");
    }

    abstract void connect();
    abstract void authenticate();
    abstract void transfer();

    void save() {
        System.out.println("파일 저장 중...");
    }
}

class HttpDownloader extends AbstractDownloader {
    void connect() {
        System.out.println("HTTP 서버 연결 중...");
    }
    void authenticate() {
        System.out.println("API 키로 인증 완료.");
    }
    void transfer() {
        System.out.println("HTTP 프로토콜로 데이터 다운로드 중...");
    }
}

class FtpDownloader extends AbstractDownloader {
    void connect() {
        System.out.println("FTP 서버 연결 중...");
    }
    void authenticate() {
        System.out.println("사용자 이름/비밀번호 인증 완료.");
    }
    void transfer() {
        System.out.println("FTP 전송 프로토콜로 데이터 다운로드 중...");
    }
}

public class templateExample1 {
    
    public static void main(String[] args) {
        AbstractDownloader http = new HttpDownloader();
        AbstractDownloader ftp = new FtpDownloader();

        System.out.println("=== HTTP 다운로드 ===");
        http.downloadFile();

        System.out.println("=== FTP 다운로드 ===");
        ftp.downloadFile();
    }
}
