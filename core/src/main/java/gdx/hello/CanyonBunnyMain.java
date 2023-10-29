package gdx.hello;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import gdx.hello.pybox.PyBoxRender;
import gdx.hello.util.ScreenshotFactory;

import java.util.Random;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class CanyonBunnyMain extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        image = new Texture("libgdx.png");
    }

    @Override
    public void render() {
//        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        batch.draw(image, 140, 210);
//        renderLazerBeam();
        //PyBoxRender.renderRainbow(batch, shapeRenderer);
        PyBoxRender.renderArc(batch, shapeRenderer);
//        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.F5)) {
            dispose();
            create();
        }

        //ScreenshotFactory.saveScreenshot(200);
    }

    public void renderLazerBeam() {
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B= (int)(Math.random()*256);
        Gdx.app.log("renderLazerBeam", "renderLazerBeam" + R +":" + G + ":"+B);
        Random random = new Random();
        final float hue = random.nextFloat();
        final float saturation = 0.9f;//1.0 for brilliant, 0.0 for dull
        final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
        Color color = new Color(R, G, B, (float) Math.random()); //random color, but can be bright or dull

        shapeRenderer.setColor(color);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        int centerX =  screenWidth / 2;
        int centerY = screenHeight / 2;
        int randomX = com.badlogic.gdx.math.MathUtils.random(screenWidth);
        int randomY = com.badlogic.gdx.math.MathUtils.random(screenHeight);

        shapeRenderer.line(centerX, centerY, randomX, randomY);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.dispose();
        image.dispose();
    }
}
