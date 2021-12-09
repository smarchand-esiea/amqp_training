package fr.lernejo.chat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatMessageRepository {
    List<String> laListeMessage = new ArrayList<>();

    void addChatMessage(String message){

        if (laListeMessage.size() < 10){
            laListeMessage.add(message);
        }else {
            laListeMessage.remove(0);
            laListeMessage.add(message);
        }

    }

    List<String> getLastTenMessages(){

        return laListeMessage;
    }
}
