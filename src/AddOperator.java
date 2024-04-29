public class AddOperator extends AbstractOperation {
    public int answer;
    public AddOperator(){
        answer = 0;
    }

    public int operate(int Number1, int Number2) {

        answer = Number1 + Number2;

        return answer;
    }
}
