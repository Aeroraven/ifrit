package com.aeroraven.ifrit.component;

import java.util.ArrayList;

import com.aeroraven.ifrit.exception.IfritComponentException;
import com.aeroraven.ifrit.primitive.*;


public interface IfritComponentInterface {
	public abstract void setZDepth(int x);
	public abstract int getZDepth();
	public abstract ArrayList<IfritPrimitiveBase> getPrimitives();
	public abstract void addPrimitive(IfritPrimitiveBase x) throws IfritComponentException;
	public abstract void addPrimitive(IfritPrimitiveBase x,int frameIdx) throws IfritComponentException;
	public abstract void frameAdvance();
	public abstract void setTotalFrames(int cnt) throws IfritComponentException;
	public abstract void translate2d(double x,double y);
	
	public abstract double getLeftMargin();
	public abstract ArrayList<IfritComponentBase> getChildComponents();
	public abstract void hide();
	public abstract void show();
	public abstract boolean isVisible();
	public abstract void enable();
	public abstract void disable();
	public abstract boolean isDisabled();
}
