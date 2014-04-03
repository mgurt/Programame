package net.infobosccoma.mp08.programamefinal;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;
import android.widget.Toast;

public class EscoltarValoracionsActivity extends Activity {

	private ListView llistaValoracions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escoltar_valoracions);

		initComponents();

	}

	private void initComponents() {
		llistaValoracions = (ListView) findViewById(R.id.llistaValoracions);
		
		if(teEmmagatzamamentExtern()){
			ArrayList<String> valoracions = obtenirValoracions();
			ValoracionsAdapter adapter = new ValoracionsAdapter(this, new String[] {});
			llistaValoracions.setAdapter(adapter);
		} else {
			Toast.makeText(this, "No hi ha emmagatzamament extern", Toast.LENGTH_SHORT).show();
		}
	}

	private ArrayList<String> obtenirValoracions() {
		ArrayList<String> valoracions = new ArrayList<String>();
		File valStorage = new File(Environment.getExternalStorageDirectory(),
				"Programame");
		File[] arxius = valStorage.listFiles();
		System.out.println(Arrays.toString(arxius));
		return null;
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

}
