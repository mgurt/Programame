package net.infobosccoma.mp08.programamefinal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class EscoltarValoracionsActivity extends Activity implements
		OnItemClickListener {

	private ListView llistaValoracions;
	private MediaPlayer mediaPlayer;
	private ArrayList<String> valoracions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escoltar_valoracions);

		initComponents();

	}

	private void initComponents() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
		llistaValoracions = (ListView) findViewById(R.id.llistaValoracions);

		if (teEmmagatzamamentExtern()) {
			valoracions = obtenirValoracions();
			ValoracionsAdapter adapter = new ValoracionsAdapter(this,
					valoracions);
			llistaValoracions.setAdapter(adapter);
		} else {
			Toast.makeText(this, "No hi ha emmagatzamament extern",
					Toast.LENGTH_SHORT).show();
		}
	}

	private ArrayList<String> obtenirValoracions() {
		ArrayList<String> valoracions = new ArrayList<String>();
		File valStorage = new File(Environment.getExternalStorageDirectory(),
				"Programame");
		File[] arxius = valStorage.listFiles();
		for (int i = 0; i < arxius.length; i++) {
			valoracions.add(arxius[i].getAbsolutePath());
		}
		return valoracions;
	}

	private boolean teEmmagatzamamentExtern() {
		boolean resp = false;
		String state = Environment.getExternalStorageState();

		if (Environment.MEDIA_MOUNTED.equals(state)) {
			// Llegir i escriure
			resp = true;
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			// Només llegir
			resp = false;
		} else {
			// No hi ha emmagatzamament extern
			resp = false;
		}

		return resp;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		reproduirSo(valoracions.get(position));

	}

	private void reproduirSo(String valoracio) {
		try {
			if(mediaPlayer.isPlaying()){
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			mediaPlayer.setDataSource(valoracio);
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
