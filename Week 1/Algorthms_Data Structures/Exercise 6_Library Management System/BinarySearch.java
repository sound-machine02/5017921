import java.util.Arrays;

public class BinarySearch {
  public static Book binarySearch(Book[] books, String title) {
    Arrays.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
    int l = 0, r = books.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;
      int cmp = books[mid].getTitle().compareTo(title);

      if (cmp == 0)
        return books[mid];
      else if (cmp > 0)
        r = mid - 1;
      else if (cmp < 0)
        l = mid + 1;
    }
    return null;
  }
}