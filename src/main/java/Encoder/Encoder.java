package Encoder;

import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class Encoder {
    private Message message;
    private Picture pic;

    public void encode(String path) throws IOException {
        pic.insertMessage(message.encode());
        pic.save(path);
        System.out.println("Encoded picture saved! ");
    }

}
