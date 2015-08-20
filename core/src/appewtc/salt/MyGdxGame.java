package appewtc.salt;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	//private Texture img;
	private Texture wallpaperTexture, cloudTexture;
	private OrthographicCamera objOrthographicCamera;
	private BitmapFont nameBitmapFont;
	private int xCloudAnInt, yCloudAnInt = 600; //cloud size 263*192 pixels
	private boolean cloudABoolean = true;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//Set Screen
		objOrthographicCamera = new OrthographicCamera();
		objOrthographicCamera.setToOrtho(false,1200,800);

		//Setup Wallpaper
		wallpaperTexture = new Texture("minion-1366x768.jpg");

		//Setup BitMapFont
		nameBitmapFont = new BitmapFont();
		nameBitmapFont.setColor(Color.NAVY);
		nameBitmapFont.setScale(4);

		//Setup Cloud
		cloudTexture = new Texture("cloud.png");
	}//Create ส่วนกำหนดค่า

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Setup Screen
		objOrthographicCamera.update();
		batch.setProjectionMatrix(objOrthographicCamera.combined);

		//เอาไว้วาดวัตถุ Object
		batch.begin();  //batch.draw(img, 0, 0);

		//Drawable Wallpaper
		batch.draw(wallpaperTexture, 0, 0);

		//Drawable BitMapFont
		nameBitmapFont.draw(batch, "C o i n s   P B R U", 400, 550);

		//Drawable Cloud
		batch.draw(cloudTexture, xCloudAnInt, yCloudAnInt);

		batch.end();

		//Move Cloud ไว้นอก Class
		moveCloud();

	}

	private void moveCloud() {
		if (cloudABoolean==true) {
			if (xCloudAnInt < 937) {
				xCloudAnInt += 100 * Gdx.graphics.getDeltaTime();
			} else {
				cloudABoolean = !cloudABoolean;
			}
		} else {
			if (xCloudAnInt > 0) {
				xCloudAnInt -= 100 * Gdx.graphics.getDeltaTime();
			} else {
				cloudABoolean = !cloudABoolean;
			}
		}

	}
}
