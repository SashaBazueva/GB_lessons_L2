package lesson_3;

public class Task2 {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Brown", "+7892341");
        phoneBook.add("Brown", "9033425");
        phoneBook.add("Kitty", "5464345");

        phoneBook.print();

        System.out.println(phoneBook.get("Brown"));
        System.out.println(phoneBook.get("Kitty"));
    }
}
