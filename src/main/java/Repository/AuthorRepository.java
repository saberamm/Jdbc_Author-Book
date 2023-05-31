package Repository;


import Entity.Author;
import connection.MyConnection;

import java.sql.*;

public class AuthorRepository {

    public void save(Author author) throws SQLException {
        Connection connection = MyConnection.getConnections();
        String sql = "INSERT INTO writers (name , last_name , age) VALUES (? , ? , ?) ";
        PreparedStatement prs = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        prs.setString(1, author.getName());
        prs.setString(2, author.getLast_name());
        prs.setInt(3, author.getAge());
        int affectedRows = prs.executeUpdate();
        connection.close();
        if (affectedRows == 0) {
            throw new SQLException("Creating author failed, no rows affected.");
        }

        try (ResultSet generatedKeys = prs.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                author.setId((int) generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating author failed, no ID obtained.");
            }
        }
    }

    public Author load(int id) throws SQLException {
        Connection connection = MyConnection.getConnections();
        String sql = "select * from writers where author_id = ?";
        PreparedStatement prs = connection.prepareStatement(sql);
        prs.setInt(1, id);
        ResultSet resultSet = prs.executeQuery();
        connection.close();
        int author_id=0;
        String name=null;
        String last_name=null;
        int age=0;
        while (resultSet.next()) {
            author_id = resultSet.getInt("author_id");
            name = resultSet.getString("name");
            last_name = resultSet.getString("last_name");
            age = resultSet.getInt("age");
        }
        return new Author(author_id, name, last_name, age);
    }
}
