package Services;

import Entity.Book;
import Repository.BookRepository;

import java.sql.SQLException;

public class BookService {

    public void addBook(String title, int print_year, int author_id) throws SQLException {
        Book book = new Book(title, print_year, author_id);
        BookRepository bookRepository = new BookRepository();
        bookRepository.save(book);
        System.out.println(book);
    }

    public Book loadBook(int id) throws SQLException {
        BookRepository bookRepository = new BookRepository();
        return bookRepository.load(id);
    }
    public void delete_book(Book book) throws SQLException {
        BookRepository bookRepository=new BookRepository();
        bookRepository.delete(book);
    }
}
