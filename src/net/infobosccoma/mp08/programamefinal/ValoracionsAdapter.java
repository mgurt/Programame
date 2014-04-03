package net.infobosccoma.mp08.programamefinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ValoracionsAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;

	public ValoracionsAdapter(Context context, String[] values) {
		super(context, R.layout.item_llista_videos, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.item_llista_valoracions, parent,
				false);
		TextView textView = (TextView) rowView.findViewById(R.id.imgItemValoracions);
		ImageView imageView = (ImageView) rowView
				.findViewById(R.id.imgItemValoracions);
		textView.setText(values[position]);
		imageView.setImageResource(android.R.drawable.ic_btn_speak_now);

		return rowView;
	}
}