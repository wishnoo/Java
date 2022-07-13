package ProblemSolving.Miscellaneous.FrogJump;

/**
 * FrogJump
 */
public class FrogJump {

    public int solution(int X, int Y, int D){

        int distanceRemaining = Y - X;
        return (int)Math.ceil((double)distanceRemaining / D);
    }

    public static void main(String[] args) {
        FrogJump obj = new FrogJump();
        System.out.println(obj.solution(10,85, 30));
    }
}