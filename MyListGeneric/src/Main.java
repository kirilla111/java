import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int N = 10000000;



        new Thread(new Runnable() {
            @Override
            public void run() {
                List<ListItem> list = new ArrayList();
                for (int i = 0; i <= N; i++) {
                    list.add(new ListItem(i, "SpeedTest: " + i));
                }

                long currentTimeMills = System.currentTimeMillis();
                for (ListItem i: list
                ) {
                    i.getValue();
                }
                System.out.println("Java List Speed Test, Time Spent: "+ ((System.currentTimeMillis() - currentTimeMills)));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ListItem[] array = new ListItem[N+1];
                for (int i = 0; i <= N; i++) {
                    array[i] = new ListItem(i, "SpeedTest: " + i);
                }

                long currentTimeMills = System.currentTimeMillis();
                for (ListItem i: array
                ) {
                    i.getValue();
                }
                System.out.println("Java Array Speed Test, Time Spent: "+ ((System.currentTimeMillis() - currentTimeMills)));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MyList<ListItem> list = new MyList<ListItem>();
                for (int i = 0; i <= N; i++) {
                    list.add(new ListItem(i, "SpeedTest: " + i));
                }

                long currentTimeMills = System.currentTimeMillis();
                for (ListItem i: list
                ) {
                    i.getValue();
                }
                System.out.println("MyList Speed Test, Time Spent: "+ ((System.currentTimeMillis() - currentTimeMills)));
            }
        }).start();
    }
}
