package pattern.Adapter;

interface HDMI {
    void connectHDMI();
}


interface USBC {
    void connectUSBC();
}


class HDMI_Monitor implements HDMI {
    public void connectHDMI() {
        System.out.println("HDMI 모니터에 연결됨");
    }
}


class LaptopUSBCDevice implements USBC {
    public void connectUSBC() {
        System.out.println("USB-C 포트로 신호 송출 중...");
    }
}


class USBtoHDMI_Adapter implements HDMI {
    private USBC usbDevice;

    public USBtoHDMI_Adapter(USBC usbDevice) {
        this.usbDevice = usbDevice;
    }

    public void connectHDMI() {
        usbDevice.connectUSBC();
        System.out.println("USB-C 신호를 HDMI로 변환합니다!");
    }
}


public class adapterExample1{
    public static void main(String[] args) {
        USBC laptop = new LaptopUSBCDevice();
        HDMI adapter = new USBtoHDMI_Adapter(laptop);

        adapter.connectHDMI();
    }
}
