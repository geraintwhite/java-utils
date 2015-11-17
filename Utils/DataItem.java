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

  public String toString() {
    String delim = "";
    StringBuilder out = new StringBuilder();
    for (String parameter : this.map.keySet()) {
      out.append(delim);
      out.append(parameter + ": " + this.map.get(parameter));
      delim = "\n";
    }
    return out.toString();
  }
}
