package in.ashokit.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	

	public List<Book> findByActiveSW(String status);

}
