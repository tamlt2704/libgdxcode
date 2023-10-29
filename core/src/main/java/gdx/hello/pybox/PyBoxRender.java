package gdx.hello.pybox;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class PyBoxRender {

    //https://github.com/tabreturn/processing.py-book/blob/master/chapter-01-hello%2C_world!/rainbow/rainbow.pyde
    public static void renderRainbow(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer) {
        Gdx.gl.glClearColor( 0,68/255f,119/255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        int sW = Gdx.graphics.getWidth();
        int sH = Gdx.graphics.getHeight();
        float radius = 0.8F * (sW / 3);
        float x = sW / 2.0f;
        float y = 0.0f;
        float rainbowSize = 20;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.valueOf("#FF0000"));
        shapeRenderer.circle(x, y, radius);
        //red
        shapeRenderer.setColor(Color.valueOf("#FF9900"));
        shapeRenderer.circle(x, y, radius-1*rainbowSize);
        //orange
        shapeRenderer.setColor(Color.valueOf("#FF9900"));
        shapeRenderer.circle(x, y, radius-2*rainbowSize);
        //yellow
        shapeRenderer.setColor(Color.valueOf("#FFFF00"));
        shapeRenderer.circle(x, y, radius-3*rainbowSize);
        //green
        shapeRenderer.setColor(Color.valueOf("#00FF00"));
        shapeRenderer.circle(x, y, radius-4*rainbowSize);
        //blue
        shapeRenderer.setColor(Color.valueOf("#0099FF"));
        shapeRenderer.circle(x, y, radius-5*rainbowSize);
        //purple
        shapeRenderer.setColor(Color.valueOf("#6633FF"));
        shapeRenderer.circle(x, y, radius-6*rainbowSize);

        shapeRenderer.setColor(Color.valueOf("#004477"));
        shapeRenderer.circle(x, y, 50);

        shapeRenderer.end();
    }

    public static void renderArc(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        Gdx.gl.glClearColor( 0,68/255f,119/255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        int sW = Gdx.graphics.getWidth();
        int sH = Gdx.graphics.getHeight();
        float x  = sW/2.0f;
        float y  = sH/2.0f;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.valueOf("#FF0000"));
        // libgdx built-in draw arc 'closed' :(
        shapeRenderer.arc(x, y, 300, 0, 90);
        shapeRenderer.arc(x, y, 300, 180, 25, 360);
//        shapeRenderer.circle(x, y, 300);
        shapeRenderer.end();
    }
}
