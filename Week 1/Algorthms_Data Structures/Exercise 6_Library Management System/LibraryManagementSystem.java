public class LibraryManagementSystem {

  public static void main(String[] args) {
    Book b1 = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
    Book b2 = new Book("B002", "1984", "George Orwell");
    Book b3 = new Book("B003", "To Kill a Mockingbird", "Harper Lee");
    Book b4 = new Book("B004", "The Catcher in the Rye", "J.D. Salinger");
    Book b5 = new Book("B005", "Pride and Prejudice", "Jane Austen");

    Book[] books = { b1, b2, b3, b4, b5 };

    String bookToSearch = "1984";
    Book foundBookLS = LinearSearch.linearSearch(books, bookToSearch);
    Book foundBookBS = BinarySearch.binarySearch(books, bookToSearch);

    if (foundBookLS != null)
      System.out.println("Product found. Details are:\n" + foundBookLS);
  
    else
      System.out.println("The searched product could not be found");

    if (foundBookBS != null) 
      System.out.println("Product found. Details are:\n" + foundBookBS);
    
    else
      System.out.println("The searched product could not be found");
  }
}