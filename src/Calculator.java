import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    /* 연산 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정*/
    private static int total = 0;

    private List<Integer> resultList = new ArrayList<>();

    public List<Integer> getResultList() {
        return resultList;
    }

    public Calculator() {
    }

    ; // 기본 생성자

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    class CalculatorException extends Exception {
        public CalculatorException(String message) {
            super(message);
        }
    }

    public int calculate(int Number1, int Number2, char operator) throws CalculatorException {

        //1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아
        // 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는 메서드와 연산 결과를
        // 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
        // - 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우
        // 적합한 Exception 클래스를 생성하여 throw 합니다.
        // (매개변수로 해당 오류 내용을 전달합니다.)

        int answer = 0;
//        3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
//        - 사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
//        - 입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (e.g.if, switch)
//        - 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
//        - e.g. “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. “

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
        // 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다
        // 연산의 결과를 비어있는 곳에 저장하기 위해 저장할 때마다 count 합니다.
        // 연산 결과가 10개를 초과하는 경우
        // 배열에 결과 값을 추가하고, 10개를 초과하는 경우 가장 처음에 들어온 결과 값을 제거합니다.
//            if (index >= intArray.length) {
//                for (int i = 0; i < intArray.length - 1; i++) {
//                    intArray[i] = intArray[i + 1];
//                }
//                intArray[intArray.length - 1] = result; // 새로운 결과 값을 맨 뒤에 추가합니다.
//            } else {
//                intArray[index] = result; // 현재 인덱스에 결과 값을 추가합니다.
//                index++;
//            }
        //6. 연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정합니다.
        // - 현재 저장된 index가 마지막(9)라면 가장 먼저 저장된 결과 값이 삭제 되고 새로운 결과 값이 마지막 index에 저장될 수 있도록 구현합니다.
        // - Hint : 결과 값들이 한칸씩 앞으로 이동되면 되지 않을까?
        //7. 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정합니다.
        // - JCF(Java Collection Framework)를 사용합니다. (e.g. List, Set …)
        // - “remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록 구현합니다.


        // 결과를 리스트에 추가
        //resultList.add(total);

        return total;


    }

    // removeResult 메서드 구현
    public void removeResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0); // 첫 번째 결과 삭제
        }
    }

    public void inquiryResults() {
        // 배열에 저장된 연산 결과를 출력합니다.
        for (int number : resultList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }


}
