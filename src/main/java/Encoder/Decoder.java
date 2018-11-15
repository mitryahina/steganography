package Encoder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Decoder {
    public Picture pic;

    public String decode(){
        Message message = new Message(pic.extractMessage());
        return message.decode();
    }

}
