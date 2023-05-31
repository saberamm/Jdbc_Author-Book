package Entity;

public class Book {
    String title;
    int print_year;
    int author_id;

    public Book(String title, int print_year, int author_id) {
        this.title = title;
        this.print_year = print_year;
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrint_year() {
        return print_year;
    }

    public void setPrint_year(int print_year) {
        this.print_year = print_year;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", print_year=" + print_year +
                ", author_id=" + author_id +
                '}';
    }
}
