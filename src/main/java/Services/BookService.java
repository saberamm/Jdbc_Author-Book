package Services;

import Entity.Author;
import Entity.Book;

public class BookService {

    public void addBook(String title,int print_year,int author_id) {
        Book book=new Book(title,print_year,author_id);

    }
}
