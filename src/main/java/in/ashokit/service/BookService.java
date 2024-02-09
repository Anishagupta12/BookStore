package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Book;


//SRARTS FORM BACKED PART 1)SERVICE   2)IMPL  3)CONTROLLER


public interface BookService {
	
	//Retrieve
	public List<Book> getAllBooks();
	
	//adding books
	public boolean saveBook(Book book);
	
	//deleting data
	public void deleteBook(Integer bookId);
	
	public Book getBookById(Integer bookId);

}
