package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day2/input2.txt"));
        String s;
        List<List<String>> data = new ArrayList<>();
        while((s = br.readLine()) != null) {
            List<String> pair = new ArrayList<>();
            pair.add(s);
            data.add(pair);
        }
        int finalScore = 0;

        for(List<String> pair : data) {
            char m1 = pair.get(0).charAt(0);
            char m2 = pair.get(0).charAt(2);
            char chosen = 'A';
            if(m2 == 'X') {
                if(m1 == 'A' ) {
                    chosen = 'C';
                } else if (m1 == 'B') {
                    chosen = 'A';
                } else {
                    chosen = 'B';
                }
            } else if(m2 == 'Y') {
                chosen = m1;
            } else if(m2 == 'Z'){
                if(m1 == 'A') {
                    chosen = 'B';
                } else if (m1 == 'B') {
                    chosen = 'C';
                } else {
                    chosen = 'A';
                }
            }
            finalScore += (getPoints(chosen) + getWinner(m1, chosen));
        }

        System.out.println(finalScore);
//        System.out.println(getWinner('A', 'C'));
    }

    static int getPoints(char move) {
        int point = 0;
        if(move == 'A') {
           point += 1;
        } else if (move == 'B') {
           point += 2;
        } else {
            point += 3;
        }
        return point;
    }
    static int getWinner(char m1, char m2) {
        int score = 0;
        if((m1 == 'A' && m2 == 'B') || (m1 == 'B' && m2 == 'C') || (m1 == 'C' && m2 == 'A') ) {
            score+=6;
        } else if (m1 ==  m2) {
            score+=3;
        }
        return score;
    }
}
