package Encoder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Evgenia\\IdeaProjects\\steganography\\src\\main\\resources\\Images\\test.png";
        Picture pic = new Picture(path);
        Message msg = new Message("lemontree");
        Encoder enc = new Encoder(msg, pic);
        enc.encode("C:\\Users\\Evgenia\\IdeaProjects\\steganography\\src\\main\\resources\\Images\\out.png");

        Decoder decoder = new Decoder(new Picture("C:\\Users\\Evgenia\\IdeaProjects\\steganography\\src\\main\\resources\\Images\\out.png"));
        String decoded = decoder.decode();
        Message d = new Message(decoded);

        System.out.println("Your decoded message: " + d.decode());
       }
}
