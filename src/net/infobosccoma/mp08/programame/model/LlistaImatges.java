package net.infobosccoma.mp08.programame.model;

import java.util.ArrayList;

import android.graphics.Bitmap;

public class LlistaImatges {
	
	private static ArrayList<Bitmap> _bitmaps;

	public LlistaImatges(ArrayList<Bitmap> bitmaps) {
		_bitmaps = bitmaps;
	}

	public static ArrayList<Bitmap> getBitmaps() {
		return _bitmaps;
	}

	public static void setBitmaps(ArrayList<Bitmap> bitmaps) {
		_bitmaps = bitmaps;
	}
	
	
	
}
