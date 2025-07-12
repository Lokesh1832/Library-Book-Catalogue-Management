package bizdigital.code.assessment.sql_version.Service;

import java.util.List;
import bizdigital.code.assessment.sql_version.Bean.Book;

public interface BookService {
    String addBook(Book book);
    String addBooks(List<Book> books);
    List<Book> getAllBooks();
    Book getBookById(int id);
    String deleteBook(int id);
    String updateAvailability(int id, boolean available);
}