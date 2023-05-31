package Repository;
import Entity.Author;
import Entity.Book;
import connection.MyConnection;

import java.sql.*;

public class BookRepository {
    public void save(Book book) throws SQLException {
        Connection connection = MyConnection.getConnections();
        String sql = "INSERT INTO books (title , print_year , authors_id) VALUES (? , ? , ?) ";
        PreparedStatement prs = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        prs.setString(1,book.getTitle());
        prs.setInt(2,book.getPrint_year());
        prs.setInt(3,book.getAuthor_id());
        int affectedRows = prs.executeUpdate();
        connection.close();
        if (affectedRows == 0) {
            throw new SQLException("Creating author failed, no rows affected.");
        }

        try (ResultSet generatedKeys = prs.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                book.setId((int) generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating author failed, no ID obtained.");
            }
        }
    }
    public Book load(int id) throws SQLException {
        Connection connection = MyConnection.getConnections();
        String sql = "select * from Books where book_id = ?";
        PreparedStatement prs = connection.prepareStatement(sql);
        prs.setInt(1, id);
        ResultSet resultSet = prs.executeQuery();
        connection.close();
        int book_id=0;
        String title=null;
        int print_year=0;
        int author_id=0;
        while (resultSet.next()) {
            book_id = resultSet.getInt("book_id");
            title = resultSet.getString("title");
            print_year = resultSet.getInt("print_year");
            author_id = resultSet.getInt("authors_id");
        }
        return new Book(book_id, title, print_year, author_id);
    }
    public void delete (Book book) throws SQLException {
        Connection connection = MyConnection.getConnections();
        String sql = "delete from books where book_id = ? ";
        PreparedStatement prs = connection.prepareStatement(sql);
        prs.setInt(1,book.getId());
        prs.executeUpdate();
        connection.close();
    }
}
