
package pattern.Decorator;
abstract class Photo {
    public abstract void show();
}

class BasicPhoto extends Photo {
    public void show() {
        System.out.println("원본 사진 표시");
    }
}

abstract class PhotoDecorator extends Photo {
    protected Photo photo;
    public PhotoDecorator(Photo photo) {
        this.photo = photo;
    }
    public void show() {
        photo.show();
    }
}

class BlackWhiteFilter extends PhotoDecorator {
    public BlackWhiteFilter(Photo photo) {
        super(photo);
    }
    public void show() {
        super.show();
        System.out.println("-> 흑백 필터 적용");
    }
}

class BrightnessFilter extends PhotoDecorator {
    public BrightnessFilter(Photo photo) {
        super(photo);
    }
    public void show() {
        super.show();
        System.out.println("-> 밝기 조정 필터 적용");
    }
}

class FrameFilter extends PhotoDecorator {
    public FrameFilter(Photo photo) {
        super(photo);
    }
    public void show() {
        super.show();
        System.out.println("-> 사진 테두리 추가");
    }
}

public class decoratorExample1 {
    public static void main(String[] args) {
        Photo photo = new BasicPhoto();
        Photo filtered = new FrameFilter(
                            new BrightnessFilter(
                                new BlackWhiteFilter(photo)));
        filtered.show();
    }
}
