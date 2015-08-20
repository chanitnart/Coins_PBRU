package appewtc.salt;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	//private Texture img;
	private Texture wallpaperTexture, cloudTexture, pigTexture;
	private OrthographicCamera objOrthographicCamera;
	private BitmapFont nameBitmapFont;
	private int xCloudAnInt, yCloudAnInt = 600; //cloud size 263*192 pixels
	private boolean cloudABoolean = true;
	private Rectangle pigRectangle; //ใช้เขียน Control
	private Vector3 objVector3;
	private Sound pigSound;

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

		//Setup Pig
		pigTexture = new Texture("pig.png");

		//Setup Rectangle
		pigRectangle = new Rectangle();
		pigRectangle.x = 600 - 32; //(1200/2) - (64/2)
		pigRectangle.y = 100;
		pigRectangle.width = 64;
		pigRectangle.height = 64;

		//Setup Pig Sound
		pigSound = Gdx.audio.newSound(Gdx.files.internal("pig.wav"));

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

		//Drawable Cloud
		batch.draw(cloudTexture, xCloudAnInt, yCloudAnInt);

		//Active When Touch Screen --> Active เมื่อกระแทกจอ
		activeTouchScreen();

		//Drawable BitMapFont
		nameBitmapFont.draw(batch, "C o i n s   P B R U", 400, 550);

		//Drawable Pig
		batch.draw(pigTexture, pigRectangle.x, pigRectangle.y);

		batch.end();

		//Move Cloud ไว้นอก Class
		moveCloud();

	}

	private void activeTouchScreen() {

		if (Gdx.input.isTouched()) { //เมื่อนิ้วโดนจอ Boolean = True

			//Pig Sound Effect
			pigSound.play();

			objVector3 = new Vector3(); //Vector3 จะเก็บ position X,y ที่นิ้วสัมผัส
			objVector3.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			if (objVector3.x < 1200 / 2) {
				//pigRectangle.x -= 10;
				if (pigRectangle.x < 0) {
					pigRectangle.x = 0;
				} else {
					pigRectangle.x -= 10;
				}//if
			} else {
				if (pigRectangle.x > 1200 - 64) {
					pigRectangle.x = 1200 - 64;
				} else {
					pigRectangle.x += 10;
				}  //if
			}

		}//if
	}//ActiveTouchScreen

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
