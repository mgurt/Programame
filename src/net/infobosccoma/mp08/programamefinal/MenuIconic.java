package net.infobosccoma.mp08.programamefinal;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MenuIconic extends Activity implements OnClickListener {

	// l'objecte amb el qual es fa la reproducci� del fitxer
	private MediaPlayer mediaPlayer;
	private boolean volum;
	private ImageButton btnArticle, btnVideo, btnValor, btnVeuVar, btnGaleria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_iconic);

		btnArticle = (ImageButton) findViewById(R.id.imgArticle);
		btnArticle.setOnClickListener(this);
		btnVideo = (ImageButton) findViewById(R.id.imgVideo);
		btnVideo.setOnClickListener(this);
		btnValor = (ImageButton) findViewById(R.id.imgValor);
		btnValor.setOnClickListener(this);
		btnVeuVar = (ImageButton) findViewById(R.id.imgVeuVar);
		btnVeuVar.setOnClickListener(this);
		btnGaleria = (ImageButton) findViewById(R.id.imgGaleria);
		btnGaleria.setOnClickListener(this);

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
		if (item.getItemId() == R.id.menu_item_volum) {
			if (volum) {
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
		mediaPlayer = MediaPlayer.create(this, R.raw.elevatorar);
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
		if(volum){
			aturarSo();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case (R.id.imgArticle):
			startActivity(new Intent(this, ArticleActivity.class));
			break;
		case (R.id.imgVideo):
			if (volum) {
				volum = false;
				aturarSo();
			}
			startActivity(new Intent(this, LlistaDeVideosActivity.class));
			break;
		case (R.id.imgValor):
			if (volum) {
				volum = false;
				aturarSo();
			}
			startActivity(new Intent(this, ValoracioActivity.class));
			break;
		case (R.id.imgVeuVar):
			if (volum) {
				volum = false;
				aturarSo();
			}
			startActivity(new Intent(this, EscoltarValoracionsActivity.class));
			break;
		case (R.id.imgGaleria):
			if (volum) {
				volum = false;
				aturarSo();
			}
			startActivity(new Intent(this, GaleriaActivity.class));
			break;
		default:
			break;

		}

	}

	@Override
	protected void onResume() {
		super.onResume();
		if (!volum) {
			volum = true;
			encendreSo();
		}
	}

}
