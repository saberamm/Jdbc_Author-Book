package Repository;

import Entity.Author;
import connection.Connection;

public class AuthorRepository {

    public void save(Author author) {
        Connection connection=Connection.getConnections();
        String sql = "INSERT INTO writers (name , last_name , age) VALUES (? , ? , ?) ";

    }

    public Author load(int author_id) {

    }
}
