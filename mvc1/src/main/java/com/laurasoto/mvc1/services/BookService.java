package com.laurasoto.mvc1.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.laurasoto.mvc1.models.Book;
import com.laurasoto.mvc1.repositories.BookRepository;


@Service
public class BookService {
 //Agregando el book al repositorio como una dependencia
	private final BookRepository bookRepository;
 
	 public BookService(BookRepository bookRepository) {
	     this.bookRepository = bookRepository;
	 }
	 //Devolviendo todos los libros.
	 public List<Book> allBooks() {
	     return bookRepository.findAll();
	 }
	 //Creando un libro.
	 public Book createBook(Book b) {
	     return bookRepository.save(b);
	 }
	 //Obteniendo la información de un libro
	 public Book findBook(Long id) {
	     Optional<Book> optionalBook = bookRepository.findById(id);
	     if(optionalBook.isPresent()) {
	         return optionalBook.get();
	     } else {
	         return null;
	     }
	 }
	 //guarda libro
	 public Book saveBook(Book book) {
		 return bookRepository.save(book);
	 }
	 
      //elimina libro
	 public Book deleteBook(Long id) {
		 Book book = findBook(id);
		 if(book != null) {
			 bookRepository.deleteById(id);
		 }
		 return bookRepository.save(book);
	 }
	 
	//actualiza libro
	public Book updateBook(Long id, String title, String desc,String lang,int numOfPages) {
		 Book book = findBook(id);
		 if(book != null) {
			book.setTitle(title);
			book.setDescription(desc);
			book.setLanguage(lang);
			book.setNumberOfPages(null);
		 }
		 return bookRepository.save(book);
	 }
	 
}

