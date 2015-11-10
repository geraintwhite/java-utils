package Utils;

import java.util.HashMap;

public abstract class DataItem {
  protected HashMap<String, Comparable> map;

  protected DataItem() {
    this.map = new HashMap<String, Comparable>();
  }

  protected <T extends Comparable> void set(String parameter, T value) {
    this.map.put(parameter, value);
  }

  public Comparable get(String parameter) {
    return this.map.get(parameter);
  }
}
