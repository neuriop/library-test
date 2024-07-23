import java.util.ArrayList;

public class LibraryManagement {
    private Library library;

    public LibraryManagement(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public ArrayList<Book> getAllBooks() {
        return library.getBooks();
    }

    public Book getBookByIsbn(int isbn) {
        for (Book book : library.getBooks())
            if (book.getISBN() == isbn)
                return book;
        return null;
    }

    public Book getBookByTitle(String name) {
        for (Book book : library.getBooks())
            if (book.getTitle().toLowerCase().contains(name.toLowerCase()))
                return book;
        return null;
    }


    public void addBook(Book book) {
        if (checkDuplicates(book))
            library.addBook(book);
    }

    public void addAllBooks(ArrayList<Book> books) {
        checkDuplicates(books);
        library.addBooks(books);
    }

    public void removeBook(Book book) {
        library.removeBook(book);
    }

    public void removeBook (int isbn) {
        library.removeBook(isbn);
    }

    public void removeAllBooks(ArrayList<Book> books) {
        library.removeBooks(books);
    }

    public ArrayList<Member> getAllMembers() {
        return library.getMembers();
    }

    public Member getMemberById(int memberId) {
        for (Member member : library.getMembers())
            if (member.getMemberId() == memberId)
                return member;
        return null;
    }

    public void addMember(Member member) {
        library.addMember(member);
    }

    public void addAllMembers(ArrayList<Member> members) {
        library.addMembers(members);
    }

    public void removeMember(Member member) {
        library.removeMember(member);
    }

    public void removeMember(int memberid){
        library.removeMember(memberid);
    }

    public void removeAllMembers(ArrayList<Member> members) {
        library.removeMembers(members);
    }

    public void issueBook(int isbn, int memberId) {
        if (getBookByIsbn(isbn) != null && getMemberById(memberId) != null) {
            getBookByIsbn(isbn).setIssued(true);
            getMemberById(memberId).addBook(getBookByIsbn(isbn));
            System.out.println("Book has been issued.");
        } else {
            System.out.println("Book does not exist.");
        }
    }

    public void returnBook(int isbn, int memberId) {
        if (getBookByIsbn(isbn) != null && getMemberById(memberId) != null) {
            if (!getBookByIsbn(isbn).isIssued())
                System.out.println("Book is not issued.");
            else if (!getMemberById(memberId).getBooks().contains(getBookByIsbn(isbn)))
                System.out.println("Book is not issued.");
            else {
                getBookByIsbn(isbn).setIssued(false);
                getMemberById(memberId).removeBook(getBookByIsbn(isbn));
                System.out.println("Book has been returned.");
            }
        }
    }

    public boolean checkAvaiability(int isbn) {
        for (Book book : library.getBooks())
            if (book.getISBN() == isbn)
                return true;
        return false;
    }

    public boolean checkAvaiability(String name) {
        for (Book book : library.getBooks())
            if (book.getTitle().toLowerCase().contains(name.toLowerCase()))
                return true;
        return false;
    }

    public boolean checkAvaiability(Book book) {
        for (Book book1 : library.getBooks())
            if (book1 == book)
                return true;
        return false;
    }

    private void checkDuplicates() {
        for (int i = 0; i < library.getBooks().size(); i++) {
            Book book = library.getBooks().get(i);
            for (int j = i + 1; j < library.getBooks().size(); j++) {
                if (book == library.getBooks().get(j))
                    library.removeBook(book);
                j--;
            }
        }
    }

    private boolean checkDuplicates(Book book) {
        for (int i = 0; i < library.getBooks().size(); i++)
            if (book == library.getBooks().get(i))
                return false;
        return true;
    }

    private void checkDuplicates(ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            for (int j = i; j < books.size(); j++) {
                if (book == books.get(j))
                    books.remove(j);
                j--;
            }
        }
    }







}
