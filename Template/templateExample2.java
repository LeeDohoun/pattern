package pattern.Template;

abstract class ExamTemplate {
    
    public final void takeExam() {
        showIntro();
        presentQuestions();
        collectAnswers();
        evaluate();
        submit();
        System.out.println(" 시험이 완료되었습니다.\n");
    }

    
    void showIntro() {
        System.out.println("온라인 시험을 시작합니다.");
    }

    abstract void presentQuestions();
    abstract void collectAnswers();
    abstract void evaluate();

    
    void submit() {
        System.out.println(" 답안을 서버로 제출 중...");
    }
}

class MultipleChoiceExam extends ExamTemplate {
    void presentQuestions() {
        System.out.println("객관식 문제 20문항을 표시합니다.");
    }
    void collectAnswers() {
        System.out.println("객관식 답안 선택 완료.");
    }
    void evaluate() {
        System.out.println("자동 채점 시스템이 점수를 계산합니다.");
    }
}

class SubjectiveExam extends ExamTemplate {
    void presentQuestions() {
        System.out.println("주관식 문제 5문항을 표시합니다.");
    }
    void collectAnswers() {
        System.out.println("학생이 직접 서술형 답안을 작성합니다.");
    }
    void evaluate() {
        System.out.println("교수님이 수동 채점합니다.");
    }
}

public class templateExample2 {
    public static void main(String[] args) {
        ExamTemplate exam1 = new MultipleChoiceExam();
        ExamTemplate exam2 = new SubjectiveExam();

        System.out.println("=== 객관식 시험 ===");
        exam1.takeExam();

        System.out.println("=== 주관식 시험 ===");
        exam2.takeExam();
    }
}
