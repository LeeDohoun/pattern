package pattern.Adapter;

interface NewPayment {
    void pay(int amount);
}


interface OldPayment {
    void makeTransaction(int amount);
}


class LegacyCardSystem implements OldPayment {
    public void makeTransaction(int amount) {
        System.out.println("구형 카드 시스템에서 " + amount + "원 결제 완료");
    }
}


class PaymentAdapter implements NewPayment {
    private OldPayment oldPayment;

    public PaymentAdapter(OldPayment oldPayment) {
        this.oldPayment = oldPayment;
    }

    public void pay(int amount) {
        System.out.println("새 결제 요청을 구형 시스템으로 변환 중...");
        oldPayment.makeTransaction(amount);
    }
}


class PaymentApp {
    public void checkout(NewPayment payment, int amount) {
        payment.pay(amount);
    }
}

public class adapterExample2 {
    public static void main(String[] args) {
        OldPayment legacySystem = new LegacyCardSystem();
        NewPayment adapter = new PaymentAdapter(legacySystem);

        PaymentApp app = new PaymentApp();
        app.checkout(adapter, 70000);
    }
}
