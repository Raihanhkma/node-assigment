import java.util.Scanner;

class Contact {
    String name, phoneNum, email;
    Contact next;

    Contact(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }
}

public class ContactBook {
    private Contact head;
    
    void addContact(String name, String phoneNum, String email) {
        Contact newContact = new Contact(name, phoneNum, email);
        if (head == null) head = newContact;
        else {
            Contact temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newContact;
        }
    }

    void removeContact(String name) {
        if (head == null) return;
        if (head.name.equals(name)) {
            head = head.next;
            return;
        }
        Contact temp = head;
        while (temp.next != null && !temp.next.name.equals(name)) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    String searchContact(String name) {
        Contact temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) return temp.name + " - " + temp.phoneNum + " - " + temp.email;
            temp = temp.next;
        }
        return "not exit";
    }

    void printContacts() {
        Contact temp = head;
        if (temp == null) {
            System.out.println("Contact is empty");
            return;
        }
        while (temp != null) {
            System.out.println(temp.name + " - " + temp.phoneNum + " - " + temp.email);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactBook book = new ContactBook();
        
        while (true) {
            System.out.println("(A)dd (D)elete (S)earch (P)rint (Q)uit");
            switch (sc.nextLine().toUpperCase()) {
                case "A":
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    book.addContact(name, phone, email);
                    break;
                case "D":
                    System.out.print("Delete Name: ");
                    book.removeContact(sc.nextLine());
                    break;
                case "S":
                    System.out.print("Search Name: ");
                    System.out.println(book.searchContact(sc.nextLine()));
                    break;
                case "P":
                    book.printContacts();
                    break;
                case "Q":
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
