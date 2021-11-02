package Lambda;

import Lambda.ImageIteratorCallback;
import Lambda.ImageOperation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


//а этот класс особенно не трогай. Трогать можно экземпляр этого класса
public class RgbMaster {
    public boolean hasAlphaChannel;
    private BufferedImage image;
    private int width;
    private int height;
    private int[] colors;

    public RgbMaster(String path) throws IOException {
        image = ImageIO.read(new File(path));
        width = image.getWidth();
        height = image.getHeight();
        colors = image.getRGB(0, 0, width, height, null, 0, width * height);
        hasAlphaChannel = image.getAlphaRaster() != null;
    }

    public static float[] rgbIntToArray(int rgbInt) {
        Color color = new Color(rgbInt);
        return color.getRGBComponents(null); // [red, green, blue, alpha]
    }

    public static int rgbArrayToInt(float[] rgbArray) throws Exception {
        if (rgbArray.length == 3) {
            return new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
        } else if (rgbArray.length == 4) {
            return new Color(rgbArray[0], rgbArray[1], rgbArray[2], rgbArray[3]).getRGB();
        } else {
            throw new Exception("invalid color");
        }
    }

    public void changeImage(ImageOperation operation) throws Exception {
        for (int i = 0; i < colors.length; i++) {
            colors[i] = operation.execute(colors[i]);
        }
    }

    public void iterateInImage(ImageIteratorCallback operation) {
        for (int i = 0; i < colors.length; i++) {
            operation.callback(colors[i]);
        }
    }

    public void save(String fileName) throws IOException {
        int type = hasAlphaChannel ? BufferedImage.TYPE_INT_ARGB: BufferedImage.TYPE_INT_RGB;
        image = new BufferedImage(width, height, type);
        image.setRGB(0, 0, width, height, colors, 0, width * height);
        ImageIO.write(image, "png", new File(fileName));
    }
}

//TODO: Тебе нужно написать реализацию этого класса ImageFunctionsImpl.
//И уже эту реализацию использовать как лямбды
