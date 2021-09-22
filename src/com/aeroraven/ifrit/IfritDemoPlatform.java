package com.aeroraven.ifrit;

import com.aeroraven.ifrit.app.IfritApplication;
import com.aeroraven.ifrit.command.IfritCPAddIOEventHandler;
import com.aeroraven.ifrit.command.IfritCPSwitchRenderScene;
import com.aeroraven.ifrit.component.IfritSprite;
import com.aeroraven.ifrit.component.IfritWindow;
import com.aeroraven.ifrit.constant.*;
import com.aeroraven.ifrit.event.IfritEventHandler;
import com.aeroraven.ifrit.scene.IfritScene;
import com.aeroraven.ifrit.shape.IfritShapeFactory;

public class IfritDemoPlatform {
	static IfritScene  scene = new IfritScene();
	static IfritSprite sprite = new IfritSprite();
	static IfritWindow window = new IfritWindow();
	
	static IfritShapeFactory shapeFactory = new IfritShapeFactory();
	static IfritApplication app;
	
	public static void main(String[] args) throws Exception {
		IfritDemoPlatform x = new IfritDemoPlatform();
		x.runApp();
	}
	
	public void moveHandler(IfritEventName eventName, Object ...params) {
		if(((Integer)(params[0])).equals(app.getEnv().getAttr(IfritEnvAttribs.KEYCODE_UP))) {
			window.translate2d(0, -1);
		}
		if(((Integer)(params[0])).equals(app.getEnv().getAttr(IfritEnvAttribs.KEYCODE_DOWN))) {
			window.translate2d(0, 1);
		}
		if(((Integer)(params[0])).equals(app.getEnv().getAttr(IfritEnvAttribs.KEYCODE_LEFT))) {
			window.translate2d(-1, 0);
		}
		if(((Integer)(params[0])).equals(app.getEnv().getAttr(IfritEnvAttribs.KEYCODE_RIGHT))) {
			window.translate2d(1, 0);
		}
	}
	
	public void runApp() throws Exception {
		app = IfritApplication.createApplication();
		app.getGlobal().setFrameUpdateInterval(10);
		
		scene.setSceneSize(1000, 400);
		
		sprite.setZDepth(0);
		sprite.setTotalFrames(1);
		
		shapeFactory.textBuilder()
					.setBackColor(255, 0, 0)
					.setForeColor(255,255, 255)
					.createTextWithRectBorder("HelloWorld", 0, 0, 12, 5, 0)
					.store();
		
		sprite.addPrimitive(shapeFactory.getFinalShape());	
		window.addComponent("sprite", sprite);
		
		scene.addComponent("window", window);
		
		app.getMediator().addCommand(new IfritCPSwitchRenderScene(scene));
		app.getMediator().addCommand(new IfritCPAddIOEventHandler("ev1",(IfritEventHandler)this::moveHandler));
	}

}
