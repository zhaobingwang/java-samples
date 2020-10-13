package tutorials.base.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListHome {
    public static void main(String[] args) {
        // 构建数组
        final int start = 10;
        final int end = 20;
        List<Integer> list = buildArrayList(start, end, true);
        System.out.println("源数组：");
        for (Integer item : list) {
            System.out.print(item + "\t");
        }
        int missingNumber = findMissingNumber(start, end, list);
        System.out.println("\n缺失的数字：" + missingNumber);
    }

    private static List<Integer> buildArrayList(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        return list;
    }

    private static List<Integer> buildArrayList(int start, int end, boolean removeSomeElements) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        if (removeSomeElements) {
            double rnd = Math.random() * list.size();
            list.remove((int) rnd);
        }
        return list;
    }

    private static int findMissingNumber(int start, int end, List<Integer> list) {
        int maxIndex = list.size();
        for (int i = start; i <= end; i++) {
            if (list.contains(i)) {
                continue;
            }
            return i;
        }
        return 0;
    }
}
