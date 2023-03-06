import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Integer> result = new HashMap<>();
        InputStream file = new FileInputStream("words.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String slovo = scanner.next();
            Integer count = 1;
            if (!result.containsKey(slovo)) {
                result.put(slovo, count);
            }else{
                Integer counts = result.get(slovo);
                result.put(slovo,counts + 1);
            }
        }
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return result.get(o1) < result.get(o2) ? 1 : -1;
            }
        };
        Map<String, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(result);
        System.out.println(treeMap);
    }
}





