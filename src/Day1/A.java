package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {
        List<String> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/Day1/input.txt"));

        String s;
        int maxSum = 0;
        int sum = 0;

        while((s = br.readLine()) != null) {
            arr.add(s);
            if(s.isBlank()) {
                if(sum > maxSum) {
                    maxSum = sum;
                }
                sum = 0;
            } else {
                int val = Integer.parseInt(s);
                sum += val;
            }
        }
    }
}
