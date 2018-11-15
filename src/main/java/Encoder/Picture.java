package Encoder;

import javax.imageio.ImageIO;

import java.awt.*;
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
        try{
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    Color curCol = new Color(img.getRGB(i, j));
                    String oldRed = Integer.toString(curCol.getRed());
                    int newRed;
                    if (Integer.parseInt(msgToInsert.substring(msgIndex, msgIndex+1)) < 6) {
                        newRed = Integer.parseInt(oldRed.substring(0, oldRed.length() - 1) + msgToInsert.charAt(msgIndex));
                    }
                    else{
                        newRed = Integer.parseInt(msgToInsert.substring(msgIndex, msgIndex+1));
                    }

                    Color newColor = new Color(newRed, curCol.getGreen(), curCol.getBlue());
                    img.setRGB(i, j, newColor.getRGB());
                    msgIndex++;
                }
            }
        }
        catch (java.lang.StringIndexOutOfBoundsException e){
        }

    }

    public void save(String path) throws IOException{
        ImageIO.write(img, "png", new File(path));
    }

    public String extractMessage(){
        int lenNumber = (new Color(img.getRGB(0, 0))).getRed() % 10;
        StringBuilder sb = new StringBuilder();
        for(int j = 1; j < lenNumber + 1; j++){
            sb.append((new Color(img.getRGB(0, j))).getRed() % 10);
        }
        int lenMessage = Integer.parseInt(sb.toString());
        StringBuilder message = new StringBuilder();
        for (int j = 1 + lenNumber; j < lenMessage + lenNumber + 1; j++){
            message.append((new Color(img.getRGB(0, j))).getRed() % 10);
        }
        return message.toString();
    }


}
