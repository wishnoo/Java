package Miscellaneous.MinPerimeterRectangle;

public class MinPerimeterRectangle {
    public int solution(int N) {
        // minPermiter variable to track the minimum value.
        int minPerimeter = Integer.MAX_VALUE;
        // We use the concept where one of the symmetric divisors are present within the square root of the number.
        // With the above theory in mind we don't have to iterate i where i * i is greater then N. 
        int i = 1;

        // Use the above theory to limit i upto square root of N
        while(i * i <= N){
            // if N is divisible by i with remainder then i is a factor
            if(N % i == 0){
                // find the perimeter with both symmetric divisors multiplied by 2.
                int currPerimeter = (i + (N / i)) * 2;
                // Update the minPerimeter value.
                minPerimeter = Math.min(currPerimeter, minPerimeter);
            }
            i++;
        }
        // After processing all the symmetric divisors return the minPerimeter.
        return minPerimeter;
    }

    public static void main(String[] args) {
        MinPerimeterRectangle obj = new MinPerimeterRectangle();
        int N1 = 30;
        System.out.println(obj.solution(N1));
        // obj.solution(N1) should return:
        // 22

        int N2 = 1;
        System.out.println(obj.solution(N2));
        // obj.solution(N2) should return:
        // 4
    }
}
