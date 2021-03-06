package com.aeroraven.ifrit.component;

public abstract class IfritComponentBase
implements IfritComponentInterface,Comparable<IfritComponentBase>{
	private int zdepth;
	protected boolean isFinal;
	protected boolean isHidden=false;
	protected boolean isDisabled=false;
	public void setZDepth(int x) {
		zdepth=x;
	}
	public int getZDepth() {
		return zdepth;
	}
	public int compareTo(IfritComponentBase dest) {
		if(zdepth<dest.zdepth) {
			return -1;
		}else if(zdepth==dest.zdepth) {
			return 0;
		}else {
			return 1;
		}
	}
	public void hide() {
		isHidden=true;
	}
	public void show() {
		isHidden=false;
	}
	public  boolean isVisible() {
		return !isHidden;
	}
	public  void enable() {
		isDisabled = false;
	}
	
	public  void disable() {
		isDisabled = true;
	}
	public  boolean isDisabled() {
		return isDisabled;
	}
}
