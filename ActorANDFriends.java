package org.example;

import java.time.LocalDate;
import java.util.List;

public class ActorAndFriends extends Actor{

    List<String> friends;
    public  ActorAndFriends(){
        super();
    }
    public  ActorAndFriends(List<String> friends){
        super();
        this.friends= friends;
    }
    public  ActorAndFriends(String name, String address, LocalDate birthday, boolean crime, int prisonterm, List<String>friends ){
        super(name,address,birthday,crime,prisonterm);
        this.friends= friends;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "ActorAndFriends{" +super.toString()+
                "friends=" + friends +
                '}';
    }
}
