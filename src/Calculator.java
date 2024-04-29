import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    /* 연산 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정*/
    private static int total = 0;
    private static List<Integer> resultList;

    // 원의 넓이를 구하는 필드와 메서드 선언과 구현 ----------------------------

    /* 원의 넓이 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    /* 원의 넓이 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정*/
    private static double AreaTotal = 0;
    private static List<Double> AreaResultList;
    /* 원주율은 pi 이기에 상수로 생성*/
    private static final double PI = 3.141592;

    /* Calculator 기본 생성자 구현 */
    public Calculator() {
        resultList = new ArrayList<>(); // 생성자에서 컬렉션 필드 초기화
        AreaResultList = new ArrayList<>();
    }

    /* 사칙연산 저장 리스트 Getter 구현 */
    public List<Integer> getResultList() {
        return resultList;
    }

    /* 사칙연산 결과 Getter 구현 */
    public int getTotal() {
        return total;
    }

    /* 사칙연산 결과 Setter 구현 */
    public void setTotal(int total) {
        this.total = total;
    }

    /* 원의 넓이 저장 필드 Getter, Setter, 조회 메서드 구현 */
    /* 원의 넓이 결과 저장 리스트 Getter 구현 */
    public List<Double> getAreaResultList() {
        return AreaResultList;
    }

    /* 원의 넓이 결과 Getter 구현 */
    public double getAreaTotal() {
        return AreaTotal;
    }

    /* 원의 넓이 결과 Setter 구현 */
    public void setAreaTotal(double AreaTotal) {
        this.AreaTotal = AreaTotal;
    }


    public int calculate(int Number1, int Number2, char operator) throws CalculatorException {

        //1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아
        int answer = 0;

        //3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.

        /* 제어문을 활용하여 위 요구사항을 만족할 수 있게 구현합니다.*/
        if (Number1 <= 0 && Number2 <= 0) {
            throw new CalculatorException("두 정수가 모두 0 이상이어야 합니다.");
        } else {
            switch (operator) {
                case '+':
                    answer = Number1 + Number2;
                    break;
                case '-':
                    answer = Number1 - Number2;
                    break;
                case '*':
                    answer = Number1 * Number2;
                    break;
                case '/':
                    if (Number2 == 0) {
                        throw new CalculatorException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        //continue;
                    }
                    answer = Number1 / Number2;
                    break;
                case '%':
                    answer = Number1 % Number2;
                    break;
                default:
                    throw new CalculatorException("올바르지 않은 연산자입니다.");
                    //continue;
            }
        }
        setTotal(answer);
        System.out.println("결과: " + getTotal());

        // 5. 연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성하고 연산의 결과를 저장합니다.

        //6. 연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정합니다.

        //7. 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정합니다.

        return total;

    }

    /* 원의 넓이를 구하는 메서드 선언*/
    public double calculateCircleArea(int r) throws CalculatorException {
        /* 원의 넓이 계산 구현 */
        double answer = r * r * PI;
        AreaTotal = answer;
        //AreaResultList.add(AreaTotal);

        return answer;
    }

    // removeResult 메서드 구현
    public void removeResult() {
        //if (!resultList.isEmpty()) {
           // resultList.remove(0);
        //}
        // 첫 번째 결과 삭제 오버라이딩으로 하단에서 구현
    }

    // inquiryResults 메서드 구현
    public void inquiryResults() {

        //for (int number : resultList) {
            //System.out.print(number + " ");
        //}
        //System.out.println();

        // 배열에 저장된 연산 결과를 출력합니다.
        // 오버라이딩으로 하단에서 구현
    }

    public static class ArithmeticCalculator extends Calculator {

        public ArithmeticCalculator(){

        }
        // 사칙 연산의 removeResult 메서드 오버라이딩
        @Override
        public void removeResult() {
            if (!resultList.isEmpty()) {
                resultList.remove(0); // 첫 번째 결과 삭제
            }
        }

        // 사칙 연산의 inquiryResults 메서드 오버라이딩
        @Override
        public void inquiryResults() {
            // 배열에 저장된 연산 결과를 출력합니다.
            for (int number : resultList) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }

    public static class CircleCalculator extends Calculator {
        public CircleCalculator(){

        }
        // 원의 넓이 구하기 inquiryResults 메서드 오버라이딩
        @Override
        public void inquiryResults() {
            // 배열에 저장된 연산 결과를 출력합니다.
            for (double number : AreaResultList) {
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

