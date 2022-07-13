package ProblemSolving.Miscellaneous.FrogJump;

/**
 * FrogJump
 */
public class FrogJump {

    public int solution(int X, int Y, int D){

        int distanceRemaining = Y - X;
        // Math.ceil to get the value equal to more than the distance remaining
        // type cast of double is required to restrict java which does a floor division by default on integer numbers.
        // type cast of int is required as the return type is int.
        return (int)Math.ceil((double)distanceRemaining / D);
    }

    public static void main(String[] args) {
        FrogJump obj = new FrogJump();
        System.out.println(obj.solution(10,85, 30));
    }
}