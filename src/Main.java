import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1.  Scanner 를 사용하여 양의 정수
        // 2개(0 포함)를 전달 받을 수 있습니다.
        // 양의 정수는 각각 하나씩 전달 받습니다.
        // 양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.

        int result = 0;
        String order = "";
        // int[] intArray = new int[10]; // 초기값 {0,0,0 ... }
        int index = 0; // 배열 인덱스를 나타내는 변수
        // 7. 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정합니다.
        // - JCF(Java Collection Framework)를 사용합니다. (e.g. List, Set …)

        List<Integer> resultList = new ArrayList<>();




        do {

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

//        3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
//        - 사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
//        - 입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (e.g.if, switch)
//        - 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
//        - e.g. “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. “


            /* 제어문을 활용하여 위 요구사항을 만족할 수 있게 구현합니다.*/
            if (Number1 <= 0 && Number2 <= 0) {
                System.out.println("두 정수가 모두 0 이상이어야 합니다.");
            } else {
                switch (operator) {
                    case '+':
                        result = Number1 + Number2;
                        break;
                    case '-':
                        result = Number1 - Number2;
                        break;
                    case '*':
                        result = Number1 * Number2;
                        break;
                    case '/':
                        if (Number2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                            continue;
                        }
                        result = Number1 / Number2;
                        break;
                    case '%':
                        result = Number1 % Number2;
                        break;
                    default:
                        System.out.println("올바르지 않은 연산자입니다.");
                        continue;
                }
            }

            System.out.println("결과: " + result);

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

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            order = sc.nextLine();
            if (order.equals("remove")) {
                // 첫 번째 결과를 삭제합니다.
                resultList.remove(0);
                // 새로운 결과 값을 맨 뒤에 추가합니다.
                resultList.add(result);
            } else {
                // 결과 값을 추가합니다.
                resultList.add(result);
                }

            // 8. “inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력합니다.
            // - foreach(향상된 for문)을 활용하여 구현 해봅니다.

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            order = sc.nextLine();
            if (order.equals("inquiry")) {
                // 배열에 저장된 연산 결과를 출력합니다.
                for (int number : resultList) {
                    System.out.print(number + " ");
                }
            }


            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            order = sc.nextLine();

            // 4. 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지
            // 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.
        } while (!order.equals("exit"));


        sc.close();
    }
}