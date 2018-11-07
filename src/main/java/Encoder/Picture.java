package Encoder;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Picture {
    private String path;
    private BufferedImage img;

    public Picture(String path) throws IOException {
        this.path = path;
        this.img = ImageIO.read(new File(path));
    }


    public void insertMessage(String msg) {
        Message m = new Message(msg);
        msg = m.encode();

        String msgToInsert = String.valueOf(Math.abs(msg.length())).length() + Integer.toString(msg.length()) + msg;
        int msgIndex = 0;
        System.out.println("To insert " + msgToInsert);

        try{
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    int pixel = img.getRGB(i, j);
                    int newPix = Integer.parseInt(Integer.toString(pixel).substring(0, 8) + msgToInsert.charAt(msgIndex));
                    img.setRGB(i, j, newPix);
                    msgIndex++;
                }
            }
        }
        catch (java.lang.StringIndexOutOfBoundsException e){
            ;
        }

        img.setRGB(0, 0, 	11000000);
        img.setRGB(0, 1, 	11000000);
        img.setRGB(0, 2, 	11000000);
    }

    public void save(String path) throws IOException{
        ImageIO.write(img, "png", new File(path));
    }

    public String extractMessage(){
        int w = img.getWidth();
        int h = img.getHeight();
        int lenNumber = (-1 * img.getRGB(0, 0)) % 10;
        System.out.println(lenNumber);
        System.out.println(img.getRGB(0, 0));
        System.out.println(img.getRGB(1, 0));
        System.out.println(img.getRGB(2, 0));

        StringBuilder sb = new StringBuilder();


        return "s";
    }
}
