package bizdigital.code.assessment.sql_version.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bizdigital.code.assessment.sql_version.Bean.Book;
import bizdigital.code.assessment.sql_version.Repository.BookRepository;
import bizdigital.code.assessment.sql_version.Service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public String addBook(Book book) {
        repository.save(book);
        return "Book added successfully with ID: " + book.getId();
    }

    @Override
    public String addBooks(List<Book> books) {
        repository.saveAll(books);
        return books.size() + " books added successfully";
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public String deleteBook(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Book deleted successfully";
        }
        return "Book not found";
    }

    @Override
    public String updateAvailability(int id, boolean available) {
        Book book = repository.findById(id).orElse(null);
        if (book != null) {
            book.setAvailability(available);
            repository.save(book);
            return "Availability updated for book ID: " + id;
        }
        return "Book not found";
    }
}
