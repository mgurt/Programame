package net.infobosccoma.mp08.programamefinal;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Bitmap> bitmaps;

	public ImageAdapter(Context context, ArrayList<Bitmap> bitmaps) {
		this.context = context;
		this.bitmaps = bitmaps;
	}

	@Override
	public int getCount() {
		return bitmaps.size();
	}

	@Override
	public Bitmap getItem(int position) {
		return bitmaps.get(position);
	}

	@Override
	public long getItemId(int position) {
		return bitmaps.get(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) { // si no està creada, inicialitzar els
									// atributs
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(240, 240));

			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageBitmap(bitmaps.get(position));
		return imageView;
	}

}
