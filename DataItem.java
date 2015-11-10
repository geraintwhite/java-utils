package Utils;

import java.util.HashMap;

public abstract class DataItem {
  protected HashMap<String, Comparable> map;

  public Comparable get(String parameter) {
    return this.map.get(parameter);
  }
}
