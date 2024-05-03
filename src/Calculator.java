import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public abstract class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    /* 연산 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정*/
    private final int total = 0;
    private List<Double> resultList;

    // 원의 넓이를 구하는 필드와 메서드 선언과 구현 ----------------------------

    /* 원의 넓이 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    /* 원의 넓이 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정*/
    private double AreaTotal = 0;
    private List<Double> AreaResultList;
    /* 원주율은 pi 이기에 상수로 생성*/
    private static final double PI = 3.141592;


    public enum Operator {
        PLUS("+", (a, b) -> (a + b)),
        MINUS("-", (a, b) -> (a - b)),
        MULTIPLY("*", (a, b) -> (a * b)),
        DIVIDE("/", (a, b) -> (a / b)),
        MOD("%", (a, b) -> (a / b));

        private final String op;
        private final BiFunction<Double, Double, Double> biFunction;

        Operator(String op, BiFunction<Double, Double, Double> biFunction) {
            this.op = op;
            this.biFunction = biFunction;
        }

        public Double calculate(double a, double b) {
            return this.biFunction.apply(a, b);
        }
    }

    /* Calculator 기본 생성자 구현 */
    public Calculator() {
        resultList = new ArrayList<>(); // 생성자에서 컬렉션 필드 초기화
        AreaResultList = new ArrayList<>();
    }

    /* 사칙연산 저장 리스트 Getter 구현 */
    public List<Double> getResultList() {
        return resultList;
    }

    /* 원의 넓이 저장 필드 Getter, Setter, 조회 메서드 구현 */
    /* 원의 넓이 결과 저장 리스트 Getter 구현 */
    public List<Double> getAreaResultList() {
        return AreaResultList;
    }


    public abstract Double calculate(int Number1, int Number2, char operator) throws CalculatorException;

    /* 원의 넓이를 구하는 메서드 선언*/
    public abstract double calculateCircleArea(int r) throws CalculatorException;

    // removeResult 메서드 구현
    public abstract void removeResult();

    // 사칙 연산의 inquiryResults 메서드 오버라이딩
    public abstract void inquirybiggerResults(int num1, int num2);

    // 사칙 연산의 inquiryResults 메서드 오버라이딩

    // inquiryResults 메서드 구현
    public abstract void inquiryResults();

    static class ArithmeticCalculator extends Calculator {

        @Override
        public Double calculate(int Number1, int Number2, char operator) throws CalculatorException {
            Double answer;
            if (Number1 <= 0 && Number2 <= 0) {
                throw new CalculatorException("두 정수가 모두 0 이상이어야 합니다.");
            } else {
                switch (operator) {
                    case '+':
                        answer = Operator.PLUS.calculate(Number1, Number2);
                        break;
                    case '-':
                        answer = Operator.MINUS.calculate(Number1, Number2);
                        break;
                    case '*':
                        answer = Operator.MULTIPLY.calculate(Number1, Number2);
                        break;
                    case '/':
                        if (Number2 == 0) {
                            throw new CalculatorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        }
                        answer = Operator.DIVIDE.calculate(Number1, Number2);
                        break;
                    case '%':
                        answer = Operator.MOD.calculate(Number1, Number2);
                        break;
                    default:
                        throw new CalculatorException("올바르지 않은 연산자입니다.");
                }
            }
            getResultList().add(answer);

            return answer;
        }

        @Override
        public double calculateCircleArea(int r) throws CalculatorException {
            return 0;
        }

        // 사칙 연산의 removeResult 메서드 오버라이딩
        @Override
        public void removeResult() {
            if (!getResultList().isEmpty()) {
                getResultList().remove(0); // 첫 번째 결과 삭제
            }
        }


        @Override
        public void inquirybiggerResults(int num1, int num2) {
            // 배열에 저장된 연산 결과를 출력합니다.
            getResultList().stream()
                    .filter(number -> number > num1 && number > num2)
                    .forEach(number -> System.out.print(number + " "));
            System.out.println();

        }

        // 사칙 연산의 inquiryResults 메서드 오버라이딩
        @Override
        public void inquiryResults() {
            // 배열에 저장된 연산 결과를 출력합니다.
            for (Double number : getResultList()) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }

    static class CircleCalculator extends Calculator {
        public CircleCalculator() {

        }

        @Override
        public Double calculate(int Number1, int Number2, char operator) throws CalculatorException {
            return 0.0;
        }

        @Override
        public double calculateCircleArea(int r) throws CalculatorException {
            if (r <= 0) {
                throw new CalculatorException("반지름은 0보다 커야 합니다.");
            }
            return r * r * PI;
        }

        @Override
        public void removeResult() {

        }

        @Override
        public void inquirybiggerResults(int num1, int num2) {

        }
        // 원의 넓이 구하기 inquiryResults 메서드 오버라이딩
        @Override
        public void inquiryResults() {
            // 배열에 저장된 연산 결과를 출력합니다.
            for (double number : getAreaResultList()) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }

    // 예외 선언 !
    class CalculatorException extends Exception {
        public CalculatorException(String message) {
            super(message);
        }
    }

}

