package Utils;

import java.util.ArrayList;
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
}
