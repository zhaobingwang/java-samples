package tutorials.base.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Students {
    private List<Student> list;
    private Map<String, Integer> cache;

    public Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    public int getScore(String name) {
        Integer score = this.cache.get(name);
        if (score == null) {
            if ((score = findInList(name)) != null) {
                this.cache.put(name, score);
            }
        }
        return score == null ? -1 : score;
    }

    private Integer findInList(String name) {
        for (Student ss : this.list) {
            if (ss.getName().equals(name)) {
                return ss.getScore();
            }
        }
        return null;
    }
}
