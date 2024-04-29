import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Calculator.ArithmeticCalculator arithmeticCalculator = new Calculator.ArithmeticCalculator();
        Calculator.CircleCalculator circleCalculator= new Calculator.CircleCalculator();

        // 1.  Scanner 를 사용하여 양의 정수

        int result = 0;
        String order = "";

        int index = 0; // 배열 인덱스를 나타내는 변수
        // 7. 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정합니다.


        do {
            try {
                /* 사칙연산을 진행할지 원의 너비를 구할지 선택 구현 */
                System.out.print("원의 넓이 구하기 : 1. 사칙연산하기 : 2 ");
                int choose = Integer.parseInt(sc.nextLine());

                if (choose == 1) {
                    // 원의 넓이
                    /* 원의 넓이를 구하는 경우 반지름을 입력받아 원의 넓이를 구한 후 출력*/
                    System.out.print("반지름 입력: ");
                    int radius = Integer.parseInt(sc.nextLine());
                    double areaResult = circleCalculator.calculateCircleArea(radius);
                    System.out.println("원의 넓이: " + areaResult);
                    /* 원의 넓이 저장 */
                    circleCalculator.getAreaResultList().add(areaResult);
                    /* 원의 넓이 리스트 출력 */
                    circleCalculator.inquiryResults();


                } else if (choose == 2) {

                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                    int Number1 = Integer.parseInt(sc.nextLine());
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                    int Number2 = Integer.parseInt(sc.nextLine());

                    // 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다
                    char operator = sc.nextLine().charAt(0);

                    // 3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.

                    result = arithmeticCalculator.calculate(Number1, Number2, operator);
                    //System.out.println("결과: " + result);


                    // 5. 연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성하고 연산의 결과를 저장합니다.

                    // 6. 연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정합니다.

                    // 7. 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정합니다.

                    System.out.println(result);

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    order = sc.nextLine();

                    if (order.equals("remove")) {
                        arithmeticCalculator.removeResult(); // 첫 번째 결과 삭제
                    }

                    arithmeticCalculator.getResultList().add(result);

                    // 8. “inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력합니다.
                    // - foreach(향상된 for문)을 활용하여 구현 해봅니다.

                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    order = sc.nextLine();
                    if (order.equals("inquiry")) {
                        arithmeticCalculator.inquiryResults();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            } catch (Calculator.CalculatorException e) {
                System.out.println("오류: " + e.getMessage());
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            order = sc.nextLine();

            // 4. 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지
            // 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.

        } while (!order.equals("exit"));


        sc.close();
    }
}