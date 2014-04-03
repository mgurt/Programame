package net.infobosccoma.mp08.programamefinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VideosAdapter extends ArrayAdapter<String> {
  private final Context context;
  private final String[] values;

  public VideosAdapter(Context context, String[] values) {
    super(context, R.layout.item_llista_videos, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.item_llista_videos, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.txtItemVideo);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.imgItemVideo);
    textView.setText(values[position]);
    imageView.setImageResource(R.drawable.programame);


    return rowView;
  }
} 