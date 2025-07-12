package bizdigital.code.assessment.simpleversion.Service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import bizdigital.code.assessment.simpleversion.Bean.Book;
import bizdigital.code.assessment.simpleversion.Service.BookService;

@Service
public class BookServiceImpl implements BookService {
	private final Map<Integer, Book> bookMap = new HashMap<>();
    private int currentId = 1;
   
    @Override
    public String addBook(Book book) {
        book.setId(currentId++);
        bookMap.put(book.getId(), book);
        return "Book added with ID: " + book.getId();
    }
    
    @Override
    public String addBooks(List<Book> books) {
        for (Book book : books) {
            book.setId(currentId++);
            bookMap.put(book.getId(), book);
        }
        return books.size() + " books added successfully";
    }
    
    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookMap.values());
    }
    
    @Override
    public Book getBookById(int id) {
        return bookMap.get(id);
    }
    
    @Override
    public String deleteBook(int id) {
        return bookMap.remove(id) != null ? "Book deleted successfully" : "Book not found";
    }
    
    @Override
    public String updateAvailability(int id, boolean available) {
        Book book = bookMap.get(id);
        if (book != null) {
            book.setAvailability(available);
            return "Availability updated for book ID: " + id;
        }
        return "Book not found";
    }
}
