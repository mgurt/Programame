package net.infobosccoma.mp08.programamefinal;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

public class MenuIconic extends Activity {

	// l'objecte amb el qual es fa la reproducci� del fitxer
	private MediaPlayer mediaPlayer;
	private boolean volum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_iconic);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		encendreSo();
		volum = true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_iconic, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.menu_item_volum){
			if(volum){
				item.setIcon(android.R.drawable.ic_lock_silent_mode_off);
				volum = false;
				aturarSo();
			} else {
				item.setIcon(android.R.drawable.ic_lock_silent_mode);
				volum = true;
				encendreSo();
			}
		}
		return true;
	}
	

	private void encendreSo() {
		mediaPlayer = MediaPlayer.create(this, R.raw.overthere_stair);
		mediaPlayer.start();
		mediaPlayer.setLooping(true);		
	}

	private void aturarSo() {
		mediaPlayer.stop();
		mediaPlayer.release();
		mediaPlayer = null;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mediaPlayer != null) {
			mediaPlayer.release();
		}
	}

}
