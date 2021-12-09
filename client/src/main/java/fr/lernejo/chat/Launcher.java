package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate beantemplate = ctx.getBean(RabbitTemplate.class);
        //beantemplate.setRoutingKey("chat_message");

        while(true){
            System.out.println("Input a message, we will send it for you(q for quit)");
            String messageToSend = new Scanner(System.in).nextLine();
            if(messageToSend.equals("q")){
                System.out.println("Bye");
                return;
            }
            beantemplate.convertAndSend("chat_messages",messageToSend);
            System.out.print("Message sent.");
        }
    }
}
