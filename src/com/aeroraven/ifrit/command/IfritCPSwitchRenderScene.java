package com.aeroraven.ifrit.command;

import java.util.HashMap;

import com.aeroraven.ifrit.core.IfritDefs;
import com.aeroraven.ifrit.exception.IfritCommandException;
import com.aeroraven.ifrit.parallel.IfritThreadBase;
import com.aeroraven.ifrit.parallel.IfritThreadMediator;
import com.aeroraven.ifrit.parallel.IfritThreadRender;
import com.aeroraven.ifrit.scene.IfritScene;

public final class IfritCPSwitchRenderScene
extends IfritCommandBase{
	public IfritCPSwitchRenderScene(Object ...objects) {
		super(objects);
	}
	@Override
	//Execute Argument: ThreadMediator, ThreadList
	public void execute(Object... objects) throws IfritCommandException {
		if(objects[0] instanceof IfritThreadMediator) {
			HashMap<String,IfritThreadBase> threadList = (HashMap<String,IfritThreadBase>)objects[1];
			IfritThreadRender renderThread = (IfritThreadRender)threadList.get(IfritDefs.IfritRenderThreadName);
			if(!(paramList.get(0) instanceof IfritScene)) {
				throw new IfritCommandException("CPSwitchRenderScene: Param 0 should be an instance of "+IfritScene.class.getName());
			}
			renderThread.setActiveScene((IfritScene)paramList.get(0));
		}else {
			throw new IfritCommandException("CPSwitchRenderScene: Should only be executed by the mediator");
		}
	}
	@Override
	public void undo() {
		
	}
}
