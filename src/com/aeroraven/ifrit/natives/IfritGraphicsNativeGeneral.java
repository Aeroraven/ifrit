package com.aeroraven.ifrit.natives;

import java.io.IOException;

import com.aeroraven.ifrit.constant.IfritColor16;
import com.aeroraven.ifrit.constant.IfritCursorMode;
import com.aeroraven.ifrit.misc.IfritEnumConverter;

abstract class IfritGraphicsNativeGeneral
extends IfritGraphicsNativeBase{

	@Override
	public void setTextColor(IfritColor16 bg, IfritColor16 fg) {
		System.out.print("\033["+IfritEnumConverter.Col16toBgANSI(bg)+"m");
		System.out.print("\033["+IfritEnumConverter.Col16toFgANSI(fg)+"m");
	}

	@Override
	public void setTextPos(short x, short y) {
		System.out.print("\033["+(y+1)+";"+(x+1)+"f");
	}

	@Override
	public void setCursorMode(IfritCursorMode arg) {
		if(arg==IfritCursorMode.HIDDEN) {
			System.out.print("\033[?25l");
		}
		if(arg==IfritCursorMode.NORMAL) {
			System.out.print("\033[?25h");
		}
		
	}

	@Override
	public abstract void setWindowSize(int x, int y);

	@Override
	public abstract void init() throws IOException;

	@Override
	public abstract char getch(Byte... ignoreList);

	@Override
	public abstract char kbhit();

	@Override
	public void cls() throws IOException {
		System.out.print("\033[H\033[2J");
		
	}
	
	@Override
	public void setConsoleTitle(String e) {
		System.out.print("\033]0;"+e+"| Build with Ifrit "+"\007");
	}

}
