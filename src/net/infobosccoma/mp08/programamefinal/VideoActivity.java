package net.infobosccoma.mp08.programamefinal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoActivity extends Activity {

	private VideoView videoView;
	private MediaController mediaController;
	private TextView txtAny;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		reproduirVideo(getIntent().getExtras().getString("any"));
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		txtAny = (TextView) findViewById(R.id.txtItemVideo);
		txtAny.setText(getIntent().getExtras().getString("any"));
	}

	private void reproduirVideo(String any) {
		videoView = (VideoView) findViewById(R.id.reproductorVideo);// Obtenir VideoView
		mediaController = new MediaController(this); // Crear MediaController
		videoView.setMediaController(mediaController); // Assignar el media controller al component
		
		int res = 0;
		if(any.equals("2012")){
			res = R.raw.programame2012;
		} else if(any.equals("2013")){
			res = R.raw.programame2013;
		} else if(any.equals("2014")){
			res = R.raw.programame2014;
		}
		
		Uri path = Uri.parse("android.resource://net.infobosccoma.mp08.programame/" + res);
		videoView.setVideoURI(path);
		videoView.start();
		mediaController.show();
		videoView.requestFocus();		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.video, menu);
		return true;
	}

}
