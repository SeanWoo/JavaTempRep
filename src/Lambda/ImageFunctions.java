package Lambda;

import java.util.HashMap;

public abstract class ImageFunctions {
    HashMap<Integer, Integer> frequency = new HashMap<>(); //<color, count>

    abstract int greyScale(int color);

    abstract int sepia(int color);

    abstract int inversion(int color);

    abstract int onlyRed(int color);

    abstract int onlyGreen(int color);

    abstract int onlyBlue(int color);

    abstract void fft(int color); //fill frequency map
}