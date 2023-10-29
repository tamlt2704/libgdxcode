package gdx.hello.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.utils.ScreenUtils;
import gdx.hello.CanyonBunnyMain;

import java.nio.ByteBuffer;

public class ScreenshotFactory {
    public static final String TAG = ScreenshotFactory.class.getName();
    private static int counter = 1;
    public static void saveScreenshot(int totalFrame){
        if (counter < totalFrame) {
            saveScreenshot();
        }
    }

    public static void saveScreenshot(){
        try{
            FileHandle fh;
            String fn;
            int screenWidth = Gdx.graphics.getWidth();
            int screenHeight = Gdx.graphics.getHeight();
            do {
                //fn = "screenshot" + counter++ + ".png";
                fn = String.format("screenshot%05d.png", counter++);
                fh = new FileHandle(fn);
            } while (fh.exists());

            Gdx.app.log(TAG, String.format("save %s with size %s %s", fn, screenWidth, screenHeight));
            Pixmap pixmap = getScreenshot(0, 0, screenWidth, screenHeight, false);
            PixmapIO.writePNG(fh, pixmap);
            pixmap.dispose();
        }catch (Exception e){
            Gdx.app.error(TAG, e.getMessage());
        }
    }

    private static Pixmap getScreenshot(int x, int y, int w, int h, boolean yDown){
        final Pixmap pixmap = ScreenUtils.getFrameBufferPixmap(x, y, w, h);

        if (yDown) {
            // Flip the pixmap upside down
            ByteBuffer pixels = pixmap.getPixels();
            int numBytes = w * h * 4;
            byte[] lines = new byte[numBytes];
            int numBytesPerLine = w * 4;
            for (int i = 0; i < h; i++) {
                pixels.position((h - i - 1) * numBytesPerLine);
                pixels.get(lines, i * numBytesPerLine, numBytesPerLine);
            }
            pixels.clear();
            pixels.put(lines);
        }

        return pixmap;
    }
}
