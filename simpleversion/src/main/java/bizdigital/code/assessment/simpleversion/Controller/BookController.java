package bizdigital.code.assessment.simpleversion.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bizdigital.code.assessment.simpleversion.Bean.Book;
import bizdigital.code.assessment.simpleversion.Service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService service;
	
	// Not using endpoints for Post and Get All, to retain the RESTfull Design.
	
	@PostMapping // For posting one book at a time
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		if (book.getTitle()  == null || book.getTitle().trim().isEmpty()) {
			return ResponseEntity.badRequest().body("Title cannot be kept empty");
		}
		return ResponseEntity.ok(service.addBook(book));
	}
	
	@PostMapping("/batch") // For posting multiple books together
	public ResponseEntity<String> addBooks(@RequestBody List<Book> books) {
	    for (Book book : books) {
	        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
	            return ResponseEntity.badRequest().body("One or more books have empty titles");
	        }
	    }
	    return ResponseEntity.ok(service.addBooks(books));
	}
		
	@GetMapping // For getting all the books in the catalogue, even if availability=false
	public List<Book> getAllBooks() {
		return service.getAllBooks();
		
	}
	
	@GetMapping("/{id}") // For getting the particular book by id, even if that book availability=false
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = service.getBookById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }
	
	@DeleteMapping("/{id}") // For deleting a particular book by id
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteBook(id));
    }
	
	@PatchMapping("/{id}/availability") // For setting the availability of a book
    public ResponseEntity<String> updateAvailability(@PathVariable int id, @RequestParam boolean available) {
        return ResponseEntity.ok(service.updateAvailability(id, available));
    }
	 
}
	
   


