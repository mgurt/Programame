package net.infobosccoma.mp08.programamefinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class LlistaDeVideosActivity extends Activity implements OnItemClickListener{
	
	private VideosAdapter adapter;
	private String[] anys;
	private ListView llista;
	
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_llista_de_videos);
		anys = new String[] { "2012", "2013", "2014" };
		adapter = new VideosAdapter(this, anys);
		llista = (ListView) findViewById(R.id.llistaVideos);
		llista.setAdapter(adapter);
		llista.setOnItemClickListener(this);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		Intent it = new Intent(this, VideoActivity.class);
		it.putExtra("any", anys[position]);
		startActivity(it);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.llista_de_videos, menu);
		return true;
	}
	
	

}
