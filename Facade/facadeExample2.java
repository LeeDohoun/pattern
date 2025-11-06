package pattern.Facade;

class ProductService {
    public void findProduct(String name) {
        System.out.println(" 상품 검색: " + name);
    }
}

class PaymentService {
    public void pay(int amount) {
        System.out.println("결제 완료: " + amount + "원");
    }
}

class InventoryService {
    public void checkStock(String name) {
        System.out.println("재고 확인: " + name + " (재고 있음)");
    }
}

class ShippingService {
    public void ship(String name) {
        System.out.println("배송 요청 완료: " + name);
    }
}


class OrderFacade {
    private ProductService productSvc;
    private PaymentService paymentSvc;
    private InventoryService inventorySvc;
    private ShippingService shippingSvc;

    public OrderFacade() {
        productSvc = new ProductService();
        paymentSvc = new PaymentService();
        inventorySvc = new InventoryService();
        shippingSvc = new ShippingService();
    }

    public void placeOrder(String product, int price) {
        System.out.println("\n=== 주문 처리 시작 ===");
        productSvc.findProduct(product);
        inventorySvc.checkStock(product);
        paymentSvc.pay(price);
        shippingSvc.ship(product);
        System.out.println("주문 완료!\n");
    }
}

public class facadeExample2 {
    public static void main(String[] args) {
        OrderFacade order = new OrderFacade();
        order.placeOrder("무선 키보드", 45000);
    }
}
