import java.util.ArrayList;

public class Member {
    private String name;
    private int memberId;
    private ArrayList<Book> books = new ArrayList<>();

    public Member() {}

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addBooks(ArrayList<Book> books) {
        this.books.addAll(books);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }


    @Override
    public String toString() {
        return "Name: '" + name + '\'' + ", memberId: " + memberId;
    }
}
