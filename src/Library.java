import java.util.ArrayList;

public class Library {
    private String name;
    private String address;
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public Library() {}

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
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

    public void removeBook(int isbn) {
        for (Book book : this.books)
            if (book.getISBN() == isbn)
                this.books.remove(book);
    }


    public void removeBooks(ArrayList<Book> books) {
        this.books.removeAll(books);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public void addMembers(ArrayList<Member> members) {
        this.members.addAll(members);
    }

    public void removeMember(Member member) {
        this.members.remove(member);
    }

    public void removeMember(int memberid){
        for (Member member : this.members)
            if (memberid == member.getMemberId())
                this.members.remove(member);
    }

    public void removeMembers(ArrayList<Member> members) {
        this.members.removeAll(members);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address;
    }
}
