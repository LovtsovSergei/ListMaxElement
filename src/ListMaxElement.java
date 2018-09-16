import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListMaxElement {
    private static <T> T maxElement(List<? extends T> list, Comparator<? super T> c) {
        if (list.isEmpty()) throw new IllegalArgumentException();
        T candidate = list.get(0);
        if (list.size() == 1) return candidate;
        for (T iter : list) {
            if (c.compare(iter, candidate) > 0) candidate = iter;
        }
        return candidate;

    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("Hi");
        intList.add(21);
        intList.add(210);
        System.out.println(maxElement(stringList, new MyComparator<>()));
        System.out.println(maxElement(intList, new MyComparator<>()));

    }
}

class MyComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.toString().compareTo(o2.toString());
    }

}

