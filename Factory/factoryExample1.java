package pattern.Factory;
import javax.print.Doc;

interface DocumentConverter {
    void convert();
}

class PdfConverter implements DocumentConverter {
    public void convert() {
        System.out.println("PDF 형식으로 문서를 변환합니다.");
    }
}

class WordConverter implements DocumentConverter {
    public void convert() {
        System.out.println("Word 형식으로 문서를 변환합니다.");
    }
}

class HtmlConverter implements DocumentConverter {
    public void convert() {
        System.out.println("HTML 형식으로 문서를 변환합니다.");
    }
}

abstract class ConverterFactory {
    public abstract DocumentConverter createConverter();
}

class PdfFactory extends ConverterFactory {
    public DocumentConverter createConverter() {
        return new PdfConverter();
    }
}

class WordFactory extends ConverterFactory {
    public DocumentConverter createConverter() {
        return new WordConverter();
    }
}

class HtmlFactory extends ConverterFactory {
    public DocumentConverter createConverter() {
        return new HtmlConverter();
    }
}

public class factoryExample1 {
    public static void main(String[] args) {
        ConverterFactory factory1 = new PdfFactory();
        DocumentConverter converter = factory1.createConverter();
        converter.convert();

        ConverterFactory factory2 = new HtmlFactory();
        DocumentConverter converter2 = factory2.createConverter();
        converter2.convert();

        ConverterFactory factory3 = new WordFactory();
        DocumentConverter converter3 = factory3.createConverter();
        converter3.convert();
    }
}
