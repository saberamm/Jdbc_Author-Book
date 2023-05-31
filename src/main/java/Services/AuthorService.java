package Services;

import Entity.Author;

public class AuthorService {

    public void register(String name, String last_name, int age) {
        Author author = new Author(name, last_name, age);

    }
}
