import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Library management");
        Library library = new Library("Georgensburg National Library", "Georgensburg, Left st. 16");
        LibraryManagement libraryManagement = new LibraryManagement(library);

        boolean exit = true;
        do {
            System.out.println("Enter a command to manage library. Type \"help\" or \"commands\" for list of commands.");
            String command = input.nextLine();

            switch (command) {
                case "addb":
                    Book book = new Book();
                    System.out.println("Enter book title: ");
                    String title = input.nextLine();
                    book.setTitle(title);
                    System.out.println("Enter book Author: ");
                    String author = input.nextLine();
                    book.setAuthor(author);
                    System.out.println("Enter book isbn (digits only): ");
                    int isbn = input.nextInt();
                    book.setISBN(isbn);
                    System.out.println(book.toString());
                    System.out.println("Book added to library.");
                    break;
                case "remb":
                    System.out.println("Enter book ISBN to remove book: ");
                    int isbn1 = input.nextInt();
                    if (libraryManagement.checkAvaiability(isbn1)) {
                        System.out.println(libraryManagement.getBookByIsbn(isbn1).toString());
                        System.out.println("Book removed from library.");
                    }
                    break;
                case "addm":
                    Member member = new Member();
                    System.out.println("Enter member name: ");
                    String name = input.nextLine();
                    member.setName(name);
                    System.out.println("Enter member id (numbers only): ");
                    int memberid = input.nextInt();
                    member.setMemberId(memberid);
                    System.out.println(member.toString());
                    System.out.println("Member added to library.");
                    break;
                case "remm":
                    System.out.println("Enter member id to remove member: ");
                    int memberid1 = input.nextInt();
                    System.out.println(libraryManagement.getMemberById(memberid1).toString());
                    System.out.println("Member removed from library.");
                    break;
                case "checki":
                    System.out.println("Enter book ISBN to check avaiabilty: ");
                    int isbn2 = input.nextInt();
                    if (libraryManagement.checkAvaiability(isbn2))
                        System.out.println("Book is avaiable: \n" + libraryManagement.getBookByIsbn(isbn2).toString());
                    else
                        System.out.println("Book is not avaiable.");
                    break;
                case "checkt":
                    System.out.println("Enter book name to check avaiability: ");
                    String title1 = input.nextLine();
                    if (libraryManagement.checkAvaiability(title1))
                        System.out.println("Book is avaiable: \n" + libraryManagement.getBookByTitle(title1).toString());
                    else
                        System.out.println("Book is not avaiable.");
                    break;
                case "issue":
                    System.out.println("Enter book isbn: ");
                    int isbn3 = input.nextInt();
                    System.out.println("Enter member id: ");
                    int memberid2 = input.nextInt();
                    libraryManagement.issueBook(isbn3, memberid2);
                    break;
                case "return":
                    System.out.println("Enter book isbn: ");
                    int isbn4 = input.nextInt();
                    System.out.println("Enter member id: ");
                    int memberid3 = input.nextInt();
                    libraryManagement.returnBook(isbn4, memberid3);
                    break;
                case "list":
                    for (Book book1 : libraryManagement.getAllBooks())
                        System.out.println(book1.toString());
                    break;
                case "listm":
                    for (Member member1 : libraryManagement.getAllMembers())
                        System.out.println(member1.toString());
                    break;
                case "help", "commands":
                    System.out.println("addb - add book\n" +
                            "remb - remove book\n" +
                            "addm - add member\n" +
                            "remm - remove member\n" +
                            "checki - check avaiability of the book by isbn\n" +
                            "checkt - check avaiability of the book by title\n" +
                            "issue - issue a book\n" +
                            "return - return a book\n" +
                            "list - list all books\n" +
                            "listm - list all members\n" +
                            "help - display this list\n" +
                            "commands - display this list\n" +
                            "exit - exit\n" +
                            "end - exit\n");
                    break;
                case "exit", "end":
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }


        } while (exit);


    }
}