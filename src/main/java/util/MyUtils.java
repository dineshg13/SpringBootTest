package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dinesh on 7/19/2015.
 */
public class MyUtils {

      public static <E> List<E> makeList(Iterable<E> iter) {
        List<E> list = new ArrayList<E>();
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }
}
