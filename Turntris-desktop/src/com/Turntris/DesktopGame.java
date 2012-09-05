package com.Turntris;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopGame {
        public static void main (String[] args) 
        {
              //  new LwjglApplication(new Turntris(), "Turntris", 480, 320, false);
        	
        	 LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
             cfg.title = "Turntris";
             cfg.useGL20 = true;
             cfg.width = 1000;
             cfg.height = 1100;
             new LwjglApplication(new Turntris(), cfg);
        	
        	
        }
}
