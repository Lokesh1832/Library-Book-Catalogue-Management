package bizdigital.code.assessment.sql_version.Bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false) // Title cannot be kept null
    private String title;
    
    private String author;
    
    private String isbn;
   

    @Column(name = "availability")
    private boolean availability;
}

