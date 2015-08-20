package appewtc.salt;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	//private Texture img;
	private Texture wallpaperTexture;
	private OrthographicCamera objOrthographicCamera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//Set Screen
		objOrthographicCamera = new OrthographicCamera();
		objOrthographicCamera.setToOrtho(false,1200,800);

		//Setup Wallpaper
		wallpaperTexture = new Texture("minion-1366x768.jpg");

		//img = new Texture("badlogic.jpg");
	}//Create ส่วนกำหนดค่า

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Setup Screen
		objOrthographicCamera.update();
		batch.setProjectionMatrix(objOrthographicCamera.combined);

		//เอาไว้วาดวัตถุ Object
		batch.begin();
		//batch.draw(img, 0, 0);

		//Drawable Wallpaper
		batch.draw(wallpaperTexture, 0, 0);

		//

		batch.end();
	}
}
