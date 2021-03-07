// 10

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new MyMap<>();
        map.put(1, 2);
        map.put(2, 4);
        map.put(3, 6);

        Set<Integer> set = new MySet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Runnable runnable = ()-> {
            for (int i = 0; i < 5000; i++) {
                set.add(i);
                map.put(i, i * 2);
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        System.out.println("Размер Set: " + set.size());//должно выводить 5000
        System.out.println("Размер Map: " + map.size());//должно выводить 5000
    }
}
