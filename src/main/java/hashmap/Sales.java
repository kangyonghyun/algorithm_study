package hashmap;

import java.util.*;

public class Sales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int section = sc.nextInt();
        int[] days = new int[day];
        for (int i = 0; i < day; i++) {
            days[i] = sc.nextInt();
        }

        Sales sales = new Sales();
        List<Integer> typeOfSales = sales.makeTypeOfSales(day, section, days);
        for (int type : typeOfSales) {
            System.out.print(type + " ");
        }
    }

    private List<Integer> makeTypeOfSales(int days, int section, int[] sales) {
        List<Integer> typeOfSales = new ArrayList<>();

        Map<Integer, Integer> sectionMap = new HashMap<>();
        for (int i = 0; i < section - 1; i++) {
            sectionMap.put(sales[i], sectionMap.getOrDefault(sales[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = section - 1; rt < days; rt++) {
            sectionMap.put(sales[rt], sectionMap.getOrDefault(sales[rt], 0) + 1);
            typeOfSales.add(sectionMap.size());
            sectionMap.put(sales[lt], sectionMap.get(sales[lt]) - 1);
            if (sectionMap.get(sales[lt]) == 0) {
                sectionMap.remove(sales[lt]);
            }
            lt++;
        }
        return typeOfSales;
    }

}
