package com.aeroraven.ifrit.core;

import java.lang.Math;
import java.util.ArrayList;


public class IfritVector<T>
extends IfritVectorBase<T>
implements Cloneable{
	@SafeVarargs
	public IfritVector(T ... init_args){
		super(init_args);
	}
	public double getEculideanDist() {
		double r=0;
		for(T i:vector) {
			r+=(double)i*(double)i;
		}
		r=Math.sqrt(r);
		return r;
	}
	public double getHamiltonDist() {
		double r=0;
		for(T i:vector) {
			r+=(double)Math.abs((double)i);
		}
		return r;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		//Object clone = super.clone();
		return new ArrayList<>(vector);
	}
}
