import java.util.*;

public class Person {
    Hashtable<String, Long> seqAndCount = new Hashtable<String, Long>();
    String name;

    public Person(String name){
       this.name = name; 
    }
    

    public void addSeqAndNum(String seq, Long num){
        seqAndCount.put(seq, num);
    }
}