package bizdigital.code.assessment.simpleversion.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// I have used lombok dependency for reducing boiler plate code
@Data                   
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private Integer id;
	private String title;
	private String author;
	private String isbn;
	private boolean availability;
	
}
