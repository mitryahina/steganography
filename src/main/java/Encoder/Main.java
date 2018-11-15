package Encoder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Evgenia\\IdeaProjects\\steganography\\src\\main\\resources\\Images\\test.png";
        Picture pic = new Picture(path);
        pic.insertMessage("lemontree");

        pic.save("C:\\Users\\Evgenia\\IdeaProjects\\steganography\\src\\main\\resources\\Images\\out.png");

        Picture encodedPic = new Picture("C:\\Users\\Evgenia\\IdeaProjects\\steganography\\src\\main\\resources\\Images\\out.png");
        encodedPic.extractMessage();


       }
}
