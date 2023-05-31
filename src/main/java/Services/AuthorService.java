package Services;

import Entity.Author;
import Repository.AuthorRepository;

import java.sql.SQLException;

public class AuthorService {

    public void register(String name, String last_name, int age) throws SQLException {
        Author author = new Author(name, last_name, age);
        AuthorRepository authorRepository = new AuthorRepository();
        authorRepository.save(author);
        System.out.println(author);

    }

    public Author loadAuthor(int id) throws SQLException {
        AuthorRepository authorRepository = new AuthorRepository();
        return authorRepository.load(id);
    }
}
