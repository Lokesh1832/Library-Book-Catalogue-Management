package bizdigital.code.assessment.sql_version.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bizdigital.code.assessment.sql_version.Bean.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
