import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        List<JsonParameter> allInfo = new ArrayList<>();
        InputStream file = new FileInputStream("infoTask2.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            String tmp = scanner.nextLine();
            String[] tmpInfo = tmp.split(" ");
            String name = tmpInfo[0];
            int age = Integer.parseInt(tmpInfo[1]);
            allInfo.add(new JsonParameter(name,age));

        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(allInfo);
        OutputStream fos = new FileOutputStream("user.json");
        fos.write(s.getBytes());
        System.out.println(s);
    }
}
