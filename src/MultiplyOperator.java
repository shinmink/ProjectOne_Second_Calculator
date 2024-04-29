public class MultiplyOperator extends AbstractOperation{
    public int answer;
    public MultiplyOperator(){
        answer = 0;
    }

    @Override
    public int operate(int Number1, int Number2) {

        answer = Number1 * Number2;

        return answer;
    }
}
