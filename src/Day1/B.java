package Day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day1/input.txt"));
        String s;
        List<List<String>> result = new ArrayList<>();
        List<String> currentGroup = new ArrayList<>();

        while((s = br.readLine()) != null) {
            if(s.isBlank()) {
                result.add(currentGroup);
                currentGroup = new ArrayList<>();
            } else {
                currentGroup.add(s);
            }
        }

        result.add(currentGroup);

        List<Integer> sums = new ArrayList<>(result.stream()
                .map(subList -> subList.stream().mapToInt(Integer::parseInt).sum()).toList());
        sums.sort(Comparator.comparingInt(a -> a));
        int finalSum = sums.get(sums.size() - 1) + sums.get(sums.size() - 2) + sums.get(sums.size() - 3);
        System.out.println(finalSum);
    }
}
