package com.geektext.bookbrowsing.Controller;

import com.geektext.bookbrowsing.Service.BookService;
import com.geektext.bookbrowsing.model.Book;
import com.geektext.bookbrowsing.model.DiscountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GeekText/books")
public class BookController {
    private final BookService bookService;

    @Autowired BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @PatchMapping("/discount")
    public ResponseEntity<String> applyDiscount(@RequestBody DiscountRequest discountRequest){
        String publisher=discountRequest.getPublisher();
        double discountPercent=discountRequest.getDiscountPercent();
        bookService.applyDiscountByPublisher(publisher,discountPercent);
        return new ResponseEntity<>("Discount applied successfully",HttpStatus.OK);
    }

   @GetMapping("/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable List<String> genre){
        List<Book> books = bookService.getBooksByGenre(genre);
        return new ResponseEntity<>(books,HttpStatus.OK);
   }

   @GetMapping("/TopSellers")
    public ResponseEntity<List<Book>> getTop10Books(){
        List<Book>books=bookService.getTop10BooksByCopiesSold();
        return new ResponseEntity<>(books,HttpStatus.OK);
   }

    @GetMapping("/{Genre}/TopRated")
    public ResponseEntity<List<Book>> getTopBooksByGenre(@PathVariable List<String> Genre){
        List<Book> books = bookService.getTopBooksByGenre(Genre);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    // @GetMapping("/TopSellers")
    @GetMapping("/Rating:{rating}")
    public ResponseEntity<List<Book>> getBooksByRating(@PathVariable double rating){
        List<Book> books = bookService.getBooksByRating(rating);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

}
