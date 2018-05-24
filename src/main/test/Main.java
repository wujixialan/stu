import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Main main = new Main();
        List<String> list = main.Permutation(str);
        System.out.println(list);
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        char[] ch = str.toCharArray();
        Permu(ch, 0, list);
        Collections.sort(list);
        return list;
    }

    public void Permu(char[] str, int i, ArrayList<String> list) {
        if (str == null) {
            return;
        }
        if (i == str.length - 1) {
            if (list.contains(String.valueOf(str))) {
                return;
            }
            list.add(String.valueOf(str));
        } else {
            boolean num = true;
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;

                Permu(str, i + 1, list);

                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }

    }
}
