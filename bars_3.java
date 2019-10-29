import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class bars_3 {
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static int summa = 0;
    private static  void task_3(Integer a){
        if (a == 0){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scannerMap = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        int sMap = scannerMap.nextInt();
        Scanner scannerList = new Scanner(System.in);
        System.out.print("Введите значение: ");
        int sList = scannerList.nextInt();
        if (map.containsKey(sMap)){
            map.get(sMap).add(sList);
        }else {
            list.add(sList);
            map.put(sMap, list);
        }
        task_3(a-1);
    }
    ////////////расчет/////////////
    private static int score(ArrayList<Integer> start){
        ArrayList<Integer> intermediate = new ArrayList<>();
        if (list.size() > 0){
            for (int i = list.size()-1; i >= 0; i--){
                if (map.containsKey(list.get(i))){
                    summa += map.get(list.get(i)).size();
                    intermediate.addAll(map.get(list.get(i)));
                    list.remove(i);
                    if ((list.size() == 0) && (intermediate.size() != 0)){
                        list.addAll(intermediate);
                        intermediate.clear();
                    }
                }else if (intermediate.size() != 0 && i == 0){
                    list.addAll(intermediate);
                }else list.remove(i);
            }
        }
        if (!list.isEmpty()){
            score(list);
        }
        return summa;
    }
    ////////////////////////////////////////
    public static void main(String[] args) {
        task_3(11);//количество вводимых ключей

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите стартовую точку: ");
        list.add(scanner.nextInt());
        System.out.println("Итого: " + score(list));
    }
}