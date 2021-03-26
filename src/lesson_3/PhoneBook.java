package lesson_3;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new HashMap<>();
    private Set<String> numbers = new HashSet<>(Set.of("0"));

    public Set<String> get(String name){
        return phoneBook.get(name);
    }

    public void add(String name, String number){
        if(phoneBook.containsKey(name)){
            Set<String> numbers = new HashSet<>(this.numbers);
            numbers.add(number);
            phoneBook.put(name, numbers);
        }else{
            numbers = new HashSet<>();
            numbers.add(number);
            phoneBook.put(name, numbers);
        }
    }

    public void print(){
        Set<Map.Entry<String, Set<String>>> entries = phoneBook.entrySet();
        Iterator<Map.Entry<String, Set<String>>> entryIterator = entries.iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, Set<String>> entry = entryIterator.next();
            System.out.print(entry.getKey() + "--> ");
            System.out.println(entry.getValue());
        }
    }
}
