package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Book;
import in.ashokit.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	//2
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		//sending empty object for form binding
		mav.addObject("book", new Book());
		mav.setViewName("index");
		return mav;
	}
	
	
	
	//3
	@PostMapping("/book")
	public ModelAndView saveBook(Book book) {
		
		ModelAndView mav = new ModelAndView();
		boolean status = service.saveBook(book);
		if(status) {
			mav.addObject("succMsg","Book Saved");
		}else {
			mav.addObject("errMsg","Failed to saved");
		}
		mav.setViewName("index");
		return mav;
	}
	
	
	
	
	
	
	
	//1
	@GetMapping("/books")
	public ModelAndView getBooks() {
	
		ModelAndView mav= new ModelAndView();
		List<Book> allBooks=service.getAllBooks();
		mav.addObject("books" , allBooks);
		mav.setViewName("booksView");
		return mav;
		
	}
	
	
	//4
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId")Integer BookId) {
		service.deleteBook(BookId);
		ModelAndView mav = new ModelAndView();
		List<Book> allBooks = service.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("booksView");
		return mav;
	}

	@GetMapping("/edit")
	public ModelAndView editBook(@RequestParam Integer bookId) { 
		Book bookObj = service.getBookById(bookId);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", bookObj);
		mav.setViewName("index");
		
		return mav;
		
	}
}
