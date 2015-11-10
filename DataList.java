package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Utils.Matcher;
import Utils.DataItem;

public class DataList<E extends DataItem> extends ArrayList<E> {
  public ArrayList<E> filter(Matcher<E> matcher) {
    ArrayList<E> list = new ArrayList<E>();
    for (E element : this) {
      if (matcher.match(element)) {
        list.add(element);
      }
    }
    return list;
  }

  public <T> ArrayList<E> filterByParameter(final String parameter, final T value) {
    return this.filter(new Matcher<E>() {
      public Boolean match(E e) {
        return e.get(parameter).equals(value);
      }
    });
  }

  public void sort(final String parameter) {
    Collections.sort(this, new Comparator<E>() {
      public int compare(E e1, E e2) {
        return e1.get(parameter).compareTo(e2.get(parameter));
      }
    });
  }
}
