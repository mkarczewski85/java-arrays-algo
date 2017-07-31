import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAlgo {

    /**
     * statyczna metoda checkUniqueValues() przyjmuje jako argument zainicjalizowaną tablicę int-ów. Zwraca też tablicę
     * int-ów, która stanowi zbiór tych samych wartości, ale bez powtórzeń. Algorytm metody wykorzystuje
     * pomocniczą listę tablicową, która dzięki wbudowanej metodzie contains() potrafi odsiać powtórzenia
     */

    public static int[] checkUniqueValues(int[] a) {
        //pomocnicza lista tablicowa
        ArrayList<Integer> tempList = new ArrayList<>();

        //pętla for, która wprowadza do listy tempList unikatowe wartości z tablicy stanowiącej argument metody
        for (int i = 0; i < a.length; i++) {
            if (!tempList.contains(a[i])) {
                tempList.add(a[i]);
            }
        }

        //zmienna tablicowa t1 o pojemności odpowiadającej rozmiarowi listy tempList
        int[] uniqueValuesArray = new int[tempList.size()];
        //pętla for, która wypełnia tablicę t1 wartościami z listy tempList
        for (int i = 0; i < tempList.size(); i++) {
            uniqueValuesArray[i] = tempList.get(i);
        }
        return uniqueValuesArray;
    }

    public static void main(String[] args) {
        int a[] = {2, 4, 99, 6, 7, 4, 2, 4};
        int t1[];
        int t2[];
        int n = a.length;

        //wartości w tablicy t1 stanowią wynik wywołania metody checkUniqueValues() z argumentem w postaci tablicy a[]
        t1 = checkUniqueValues(a);
        t2 = new int[t1.length];

        //pierwszy for odpowiada za przeskakiwanie po indeksach tablic t1 i t2, zagnieżdżony for sprawdza
        //czy wartości z t1[i] pojawiają się w a[j]  - za każdym pojawieniem się inkrementuje się t2[i]
        for (int i = 0; i < t1.length; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] == t1[i]) {
                    t2[i]++;
                }
            }
        }

        //prezentacja wyników za pomocą wbudowanej metody toString() z klasy Arrays
        System.out.println("Wartości dla tablicy a: " + Arrays.toString(a));
        System.out.println("Wartości dla tablicy t1: " + Arrays.toString(t1));
        System.out.println("Wartości dla tablicy t2: " + Arrays.toString(t2));
    }
}