package Encoder;

import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString


public class Message {
    private String message;

    public Message(String msg) {
        this.message = msg;
    }

    public String encode() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < message.length() ; i++){
            sb.append((int)message.charAt(i));
        }
        return sb.toString();
    }


    public String decode(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i += 2) {
            int a = Integer.parseInt(message.substring(i, i+2));
            sb.append((char)a);
        }
        return sb.toString();
    }
}
