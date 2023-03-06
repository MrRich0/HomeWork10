
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Task1 {
    public static void main(String[] args) throws IOException {
        InputStream file = new FileInputStream("numberTask1.txt");
        Scanner scanner = new Scanner(file);
        StringBuilder allNumbers = new StringBuilder();
        while (scanner.hasNext()){
            allNumbers.append(scanner.nextLine());
            allNumbers.append(" ");
        }

        String[] formNumber = new String[]{"\\d{3}-\\d{3}-\\d{4}","\\(\\d{3}\\) \\d{3}-\\d{4}"};
        for (int i = 0; i < formNumber.length; i++) {
            Pattern pattern = Pattern.compile(formNumber[i]);
            Matcher matcher = pattern.matcher(allNumbers);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}


