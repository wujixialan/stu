import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(",");
        List<Integer> list = new ArrayList<>();
        Arrays.stream(strings).forEach(ele -> {
            list.add(Integer.parseInt(ele));
        });
        int result = candy(list, list.size());
        System.out.println(result);
    }
    public static int candy(List<Integer> ratings, int n) {
        int i, j, sum = 0, min = ratings.get(0);
        int[] dp = new int[n];
        if (n < 2)
            return 1;
        for (i = 0; i < n; i++)
            dp[i] = 1;
        for (i = 0; i < n; i++) {
            if (i < n - 1 && ratings.get(i + 1) > ratings.get(i))
                dp[i + 1] = dp[i] + 1;
        }
        for (i = n - 1; i >= 0; i--) {
            if (i > 0 && ratings.get(i - 1) > ratings.get(i) && dp[i - 1] < dp[i] + 1)
                dp[i - 1] = dp[i] + 1;
                sum += dp[i];
        }
        return sum;
    }
}
