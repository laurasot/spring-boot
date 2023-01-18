package com.laurasoto.mvc1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laurasoto.mvc1.models.Book;
import com.laurasoto.mvc1.services.BookService;

//... Sentencias import removidas para resumir
@Controller
public class BooksController {
	//instancia un objeto de la clase BookService
 private final BookService bookService;
 
 	//constructor que pide este servicio?
	 public BooksController(BookService bookService) {
	     this.bookService = bookService;
	 }
	 
	 //en la ruta /books mostrara una lista de todos los libros
	 // se crea variable tipo lista que a traves del metodo allbooks llama todos los libros
	 //se guarda en el model para posteriormente mostrarlo en el jsp
	 @RequestMapping("/books")
	 public String index(Model model) {
	     List<Book> books = bookService.allBooks();
	     model.addAttribute("books", books);
	     return "/books/index";
	 }
	 // @modelattribute asigna un objeto llamado book de la clase book?
	 @RequestMapping("/books/new")
	 public String newBook(@ModelAttribute("book") Book book) {
	     return "/books/new";
	 }
	 
	 @RequestMapping(value="/books", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/books/new";
	     } else {
	         bookService.createBook(book);
	         return "redirect:/books";
	     }
	 }
	 
	 //muestra segun el id entregado, usando el metodo findbook, todos los atributos del libro requerido 
	 @GetMapping(value="/books/show/{id}")
	 public String show(@PathVariable("id") Long id, Model model) {
		 Book book = bookService.findBook(id);
		 model.addAttribute("book", book);
		 return "/books/show";
	 }
	 //muestra todos los libros?
	 @GetMapping(value="/books/show")
	 public String show( Model model) {
		 List<Book> book = bookService.allBooks();
		 model.addAttribute("book", book);
		 return "/books/show";
	 }
	 //edita libros
	    @RequestMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Book book = bookService.findBook(id);
	        model.addAttribute("book", book);
	        return "/books/edit";
	    }
	    
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
	        if (result.hasErrors()) {
	        	return "/books/edit";
	        }
            else {
            	Book bookToUpdate = bookService.findBook(id);
            	 if(bookToUpdate != null) {
            		 book.setId(id);
            		 bookService.saveBook(book);
            	 }
	            return "redirect:/books";
	        }
	    }
    //elimina el libro
     @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        bookService.deleteBook(id);
	        return "redirect:/books";
    }
}
