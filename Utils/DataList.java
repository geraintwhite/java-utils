package Utils;

public class DataList<E extends DataItem> extends GenericDataList<DataList<E>, E> {
  @Override protected DataList<E> getThis() { return this; }
  @Override protected DataList<E> newInstance() { return new DataList<E>(); }
}
