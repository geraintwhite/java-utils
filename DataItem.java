package Utils;

import java.util.HashMap;

public abstract class DataItem {
  protected HashMap<String, Object> map;

  public Object get(String parameter) {
    return this.map.get(parameter);
  }
}
