package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class GenericDataList<T extends GenericDataList<T, E>, E extends DataItem> extends ArrayList<E> {
  protected abstract T getThis();
  protected abstract T newInstance();

  public T clone() {
    T cloned = newInstance();
    for (E element : getThis()) {
      cloned.add(element);
    }
    return cloned;
  }

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
    T sorted = getThis().clone();
    Collections.sort(sorted, comparator);
    return sorted;
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
    T reversed = getThis().clone();
    Collections.reverse(reversed);
    return reversed;
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
