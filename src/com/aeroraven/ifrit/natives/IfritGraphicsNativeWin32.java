package com.aeroraven.ifrit.natives;

import java.io.IOException;

import com.aeroraven.ifrit.constant.IfritCursorMode;
import com.aeroraven.ifrit.nativelib.IfritConsoleInterface;

final class IfritGraphicsNativeWin32
extends IfritGraphicsNativeGeneral{
	private long hstdIn,hstdOut,hstdErr;
	
	@Override
	public void setWindowSize(int x, int y) {
		Process tx;
		try {
			tx = new ProcessBuilder("cmd", "/C", "mode con cols="+y+" lines="+x).inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tx= null;
		System.gc();
	}

	@Override
	public void init() throws IOException {
		hstdIn = IfritConsoleInterface.ICI_GetStdHandle(-10);
		int modeIn = IfritConsoleInterface.ICI_GetConsoleMode(hstdIn);
		IfritConsoleInterface.ICI_SetConsoleMode(hstdIn, modeIn&(~0x0040));
		
		hstdOut = IfritConsoleInterface.ICI_GetStdHandle(-11);
		int modeOut = IfritConsoleInterface.ICI_GetConsoleMode(hstdOut);
		IfritConsoleInterface.ICI_SetConsoleMode(hstdOut, modeOut|0x0004);
		
		hstdErr = IfritConsoleInterface.ICI_GetStdHandle(-12);
		int modeErr = IfritConsoleInterface.ICI_GetConsoleMode(hstdErr);
		IfritConsoleInterface.ICI_SetConsoleMode(hstdErr, modeErr|0x0004);
		
		setCursorMode(IfritCursorMode.HIDDEN);
		setConsoleTitle("Demo ");
		cls();
		IfritConsoleInterface.ICI_DisableConsoleScale();
	}

	@Override
	public char getch(Byte... ignoreList) {
		return (char)IfritConsoleInterface.ICI_Getch();
	}

	@Override
	public char kbhit() {
		return (char)IfritConsoleInterface.ICI_Kbhit();
	}
	@Override
	public void cls() throws IOException {
		Process x = new ProcessBuilder("cmd", "/C", "cls").inheritIO().start();
		x= null;
		System.gc();
	}
	
}
