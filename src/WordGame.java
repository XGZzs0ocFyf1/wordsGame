import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;



public class WordGame {

    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static boolean isWin = false;

    public static void main(String[] args) {

        String randomWord =  words[ThreadLocalRandom.current().nextInt(words.length)];
        System.out.println("загадал " + randomWord); //debug

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String word = "";

            while (!isWin) {
                System.out.println("Введите слово");
                word = br.readLine().toLowerCase();
                if (word.equals(randomWord)) {
                    isWin = true;
                    System.out.println("Вы угадали");
                } else {
                    StringBuilder sb = new StringBuilder("###############");
                    int max = Math.min(randomWord.length(), word.length());
                    for (int i = 0; i < max; i++) {
                        char c = '#';
                        if (word.charAt(i) == randomWord.charAt(i)) c = word.charAt(i);
                        sb.setCharAt(i, c);
                    }
                    System.out.println(sb.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
