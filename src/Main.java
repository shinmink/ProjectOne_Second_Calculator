import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1.  Scanner 를 사용하여 양의 정수
        // 2개(0 포함)를 전달 받을 수 있습니다.
        // 양의 정수는 각각 하나씩 전달 받습니다.
        // 양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.

        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int Number1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int Number2 = sc.nextInt();

    }
}