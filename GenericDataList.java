package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Utils.Matcher;
import Utils.DataItem;
import Utils.Table;

public abstract class GenericDataList<T extends GenericDataList<T, E>, E extends DataItem> extends ArrayList<E> {
  protected abstract T getThis();
  protected abstract T newInstance();

  public T filter(Matcher<E> matcher) {
    T list = newInstance();
    for (E element : getThis()) {
      if (matcher.match(element)) {
        list.add(element);
      }
    }
    return list;
  }

  public <P> T filter(final String parameter, final P value) {
    return getThis().filter(new Matcher<E>() {
      public Boolean match(E e) {
        return e.get(parameter).equals(value);
      }
    });
  }

  public T sort(Comparator<E> comparator) {
    Collections.sort(getThis(), comparator);
    return getThis();
  }

  public T sort(final String parameter) {
    return getThis().sort(new Comparator<E>() {
      @SuppressWarnings("unchecked")
      public int compare(E e1, E e2) {
        return e1.get(parameter).compareTo(e2.get(parameter));
      }
    });
  }

  public T reverse() {
    Collections.reverse(getThis());
    return getThis();
  }

  public String toTable(String[] parameters) {
    String[][] data = new String[getThis().size()][parameters.length];

    for (int i = 0; i < getThis().size(); i++) {
      for (int j = 0; j < parameters.length; j++) {
        data[i][j] = getThis().get(i).get(parameters[j]).toString();
      }
    }

    return new Table(parameters, data).toString();
  }
}
