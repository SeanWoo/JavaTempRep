package Lambda;

public class ImageFunctionsImpl extends ImageFunctions{
    @Override
    public int greyScale(int color) {
        var rgba = RgbMaster.rgbIntToArray(color);

        var averageColor = (rgba[0] + rgba[1] + rgba[2]) / 3;
        var newRgba = new float[] {
                averageColor,
                averageColor,
                averageColor
        };

        try {
            return RgbMaster.rgbArrayToInt(newRgba);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int sepia(int color) {
        var rgba = RgbMaster.rgbIntToArray(color);

        var rgbaAbs = new float[] {
                rgba[0] * 255,
                rgba[1] * 255,
                rgba[2] * 255
        };

        if (rgbaAbs[0] < 63){
            rgbaAbs[0] = (float) (rgbaAbs[0] * 1.1);
            rgbaAbs[2] = (float) (rgbaAbs[2] * 0.9);
        }else if (rgbaAbs[0] < 192){
            rgbaAbs[0] = (float) (rgbaAbs[0] * 1.15);
            rgbaAbs[2] = (float) (rgbaAbs[2] * 0.85);
        }else{
            rgbaAbs[0] = (float) Math.min(rgbaAbs[0] * 1.08, 255);
            rgbaAbs[2] = (float) (rgbaAbs[2] * 0.93);
        }

        try {
            return RgbMaster.rgbArrayToInt(new float[] { rgbaAbs[0] / 255, rgbaAbs[1] / 255, rgbaAbs[2] / 255 });
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int inversion(int color) {
        return ~color;
    }

    @Override
    public int onlyRed(int color) {
        return color & 0xFF0000;
    }

    @Override
    public int onlyGreen(int color) {
        return color & 0x00FF00;
    }

    @Override
    public int onlyBlue(int color) {
        return color & 0x0000FF;
    }

    @Override
    public void fft(int color) {

    }
}
