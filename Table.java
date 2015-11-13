package Utils;

public class Table {
  private String[][] data;
  private String[] headings;
  private int[] colSizes;

  public Table(String[][] data) {
    this(null, data);
  }

  public Table(String[] headings, String[][] data) {
    this.headings = headings;
    this.data = data;

    this.colSizes = new int[this.headings.length];
    for (int i = 0; i < this.headings.length; i++) {
      int size = this.getMaxSize(i);
      this.colSizes[i] = this.headings[i].length() > size ? this.headings[i].length() : size;
    }
  }

  public String toString() {
    StringBuilder out = new StringBuilder();

    String header = addRow(this.headings);
    out.append(header + '\n' + fillLength(header.length(), '=') + '\n');

    for (String[] row : this.data) {
      String line = addRow(row);
      out.append(line + '\n' + fillLength(line.length(), '-') + '\n');
    }

    return out.toString();
  }

  private String addRow(String[] row) {
    StringBuilder line = new StringBuilder();
    for (int i = 0; i < row.length; i++) {
      line.append(this.fillLength(row[i], this.colSizes[i], ' ') + " | ");
    }
    return line.toString();
  }

  private String fillLength(int length, char c) {
    return fillLength("", length, c);
  }

  private String fillLength(String word, int length, char c) {
    return word + new String(new char[length - word.length()]).replace('\0', c);
  }

  private int getMaxSize(int col) {
    int max = 0;
    for (String[] row : this.data) {
      int size = row[col].length();
      max = size > max ? size : max;
    }
    return max;
  }
}