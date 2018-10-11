package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Enamy  {
    public static Image enamy2;
    public static  Image enamy2_ballet;

    public Enamy () throws IOException {
        this.enamy2 = ImageIO.read (Enamy.class.getResourceAsStream ("ename.png"));
        this.enamy2_ballet = ImageIO.read (Enamy.class.getResourceAsStream ("enamy_bullet.png"));
    }
}
