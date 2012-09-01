package com.Turntris;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


public class Turntris implements ApplicationListener {
	
	Texture dropImage;
	Texture bucketImage;
	Sound dropSound;
	Music rainMusic;
	OrthographicCamera camera;
	SpriteBatch batch;
	Rectangle bucket;
	Array<Raindrop> raindrops;
	long lastDropTime;
	Texture SquareImage;
	Rectangle Square;
	
	Texture SpriteSheet;
	
	Sprite pail;
	Array<Block> blocks;
	

	@Override
	public void create() {
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1000, 1000);
		batch = new SpriteBatch();
		
		 // load the images for the droplet and the bucket, 48x48 pixels each
		  bucketImage = new Texture(Gdx.files.internal("assets/bucket.png"));
	      dropImage = new Texture(Gdx.files.internal("assets/water-droplet.png"));
	     
	      
	      // load the drop sound effect and the rain background "music"
	      dropSound = Gdx.audio.newSound(Gdx.files.internal("assets/rainmusic 2.mp3"));
	     // rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
	      
	      // start the playback of the background music immediately
	    //  rainMusic.setLooping(true);
	    // rainMusic.play();
	      bucket = new Rectangle();
	      bucket.x = 800 / 2 - 48 / 2;
	      bucket.y = 20;
	      bucket.width = 48;
	      bucket.height = 48;

	      raindrops = new Array<Raindrop>();
	      spawnRaindrop();
	      //***************************Turntris Code****************
	      
	      //SquareImage = new Texture(Gdx.files.internal("assets/Square100.png"));
	      Square = new Rectangle();
	      Square.x = 1000/2-10/2;
	      Square.y = 20;
	      Square.width = 100;
	      Square.height = 100;
	      
	      
	      SpriteSheet = new Texture(Gdx.files.internal("assets/TurntrisSprites.png"));
	      pail = new Sprite(SpriteSheet, 200, 1,98,98);
	      //block = new Sprite(SpriteSheet, 0, 1,98,98);
	      
	      blocks= new Array<Block>();
	      
	      for(int i = 0;i<10;i++)
	      {
	    	  blocks.add(new Block());
	    	  blocks.get(i).setPositionX(i*100);
	    	  blocks.get(i).setPositionY(200);
	      }
	      
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		 // clear the screen with a dark blue color. The
	      // arguments to glClearColor are the red, green
	      // blue and alpha component in the range [0,1]
	      // of the color to be used to clear the screen.
	      Gdx.gl.glClearColor(0.5f, 0.1f, 0.6f, 1);
	      Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	      camera.update();
	     
	      

	      
	      
	      batch.setProjectionMatrix(camera.combined);
	      batch.begin();
	      //batch.draw(bucketImage, bucket.x, bucket.y);
	      //batch.draw(SquareImage, Square.x,Square.y);
	     
	      pail.setPosition(Square.x, Square.y);
	      pail.draw(batch);
	      
	      //block.draw(batch);
	      
	      
	      for(Raindrop drop: raindrops) 
	      { 
	          drop.draw(batch);
	      }
	      
	      
	      
	      for(Block block: blocks)
	      {
	    	  block.draw(batch);
	      }
	      
	      batch.end();
	      
	      if(Gdx.input.isTouched()) {
	          Vector3 touchPos = new Vector3();
	          touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
	          camera.unproject(touchPos);
	          Square.x = touchPos.x - 100 / 2;
	          //pail.setPosition(Square.x, Square.y);
	       }
	      
	      if(Gdx.input.isKeyPressed(Keys.LEFT)) Square.x -= 200 * Gdx.graphics.getDeltaTime();
	      if(Gdx.input.isKeyPressed(Keys.RIGHT)) Square.x += 200 * Gdx.graphics.getDeltaTime();
	      
	      if(Square.x < 0) Square.x = 0;
	      if(Square.x > 1000 - 10) Square.x = 1000 - 10;

	      if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();
	      Iterator<Raindrop> iter = raindrops.iterator();
	      while(iter.hasNext()) {
	         Raindrop raindrop = iter.next();
	         if (raindrop.update(Square) == false)
	         {
	        	 iter.remove();
	         }
	          
	      }
	      
	      //*********TurnTris Code************
	      
	     
	      
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
//		 TODO Auto-generated method stub
		 dropImage.dispose();
	     bucketImage.dispose();
	     dropSound.dispose();
	     //rainMusic.dispose();
	     batch.dispose();
	     SquareImage.dispose();
	    

	}
	 private void spawnRaindrop() {
	      raindrops.add(new Raindrop());
	      lastDropTime = TimeUtils.nanoTime();
	      
	      
	   }


}
