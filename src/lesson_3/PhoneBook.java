package lesson_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PhoneBook {

    private HashMap<String, String> phoneBook;
    private HashSet<String> numbers;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
        this.numbers = new HashSet<>();
    }

    public void add(String name, String number){
        if(!numbers.contains(number)){
            phoneBook.put(number, name);
            numbers.add(number);
        }
    }

    public void printPhoneBook() {
        for (String keys: numbers) {
            System.out.print(phoneBook.get(keys) + "=");
            System.out.print(keys + ", ");
        }
    }
//    public String get(){
//        return phoneBook.;
//    }
}
