package net.infobosccoma.mp08.programamefinal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import net.infobosccoma.mp08.programame.model.LlistaImatges;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GaleriaActivity extends Activity {

	private ArrayList<String> imatges;
	private ArrayList<Bitmap> bitmaps;
	private GridView gridview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_galeria);

		initComponents();

	}

	private void initComponents() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// Orientació vertical
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		inicialitzarImatges();

		gridview = (GridView) findViewById(R.id.gridview);

		// Gestionar el clic als diferents elements
		gridview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				Intent it = new Intent(GaleriaActivity.this,
						ImatgeActivity.class);
				it.putExtra("position", position);
				LlistaImatges.setBitmaps(bitmaps);
				
				startActivity(it);
			}
		});
		bitmaps = new ArrayList<Bitmap>();
		new DownloadImageTask().execute();
	}

	private void inicialitzarImatges() {
		imatges = new ArrayList<String>();
		imatges.add("https://lh6.googleusercontent.com/cfYRvSQsjXo-7BIrl4M4TpdJVmRxFUD1v-GR155Gcqs=w295-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/DHQG8RihNLhhzSNT4V1aoOmzTNI9eEqh7iCBCD8tWRs=w296-h196-p-no");
		imatges.add("https://lh5.googleusercontent.com/ghecO1Pwu5snr_TxzXYSSAM_tR0YND0um0gqAz9TBKQ=w296-h196-p-no");
		imatges.add("https://lh4.googleusercontent.com/JPcb8xlWFciDBsIAZ3lVC60CioESguRWOrzI4_kLOkY=w295-h196-p-no");
		imatges.add("https://lh6.googleusercontent.com/O7vVXGuVQBYY9V9uPpHvw36kam0abjiqlCuFFXukyLA=w295-h196-p-no");
		imatges.add("https://lh4.googleusercontent.com/aWaSZFq_Mbesoe7cWbCHUjoWgzNqAKtfZ4VYJac_Q88=w295-h196-p-no");
		imatges.add("https://lh6.googleusercontent.com/M-jt3Q-nnGeNY-cK-cQqiWt11uqcFQMaOzhBfG5NXuY=w296-h196-p-no");
		imatges.add("https://lh6.googleusercontent.com/GJvNQ-dJomW-_hanY0dTiQ6zmUAn_kQyGFjK2r-LwoI=w295-h196-p-no");
		imatges.add("https://lh6.googleusercontent.com/c9JJ7CoeQsFxnMsRjdGAEVrfeKZfNntCb6q7XwsPxyU=w295-h196-p-no");
		imatges.add("https://lh6.googleusercontent.com/cubpdkgZOQclagfRZyEmDniz-5FbOsz88Lu9tCnuxv4=w295-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/Qar2U1GBnSnpFZsp5uUmcmRlgF7BdXBFx4r4YlLKqV0=w296-h196-p-no");
		imatges.add("https://lh4.googleusercontent.com/kHKTfdcm42GxTESdFzjjDEp9mVbHn-NkY7oc3y1f3yE=w295-h196-p-no");
		imatges.add("https://lh5.googleusercontent.com/8tWy-vD7EwNoWqdO9pf8dw8dZKJzquc2bYFVkEKEx3o=w295-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/RHxxRN3-lDWsYdYOOuQcPtufOEVDBqikkVOeTuH-hnQ=w295-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/CSjY7bZ0xwvIDyk1kgQThEL5wsZ1fD6nCTSEiDJo_WE=w296-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/TlP7pNpOVjSDv7Sp3CQzg2ZecCBCJVGxXlMs0pXSCf0=w295-h196-p-no");
		imatges.add("https://lh4.googleusercontent.com/QMjSwYvGZNLXuDj5TASWlNZQD5TwDiTsF0MtTSt4Fm0=w295-h196-p-no");
		imatges.add("https://lh6.googleusercontent.com/j0Poi7R57EfBgTfDESWOUJ1dzFTWvczQAa3uPzV551s=w295-h196-p-no");
		imatges.add("https://lh4.googleusercontent.com/CtF-l0Ol0m6gZeYHMldv87q8IowYhPLeBsa-BbHefrE=w296-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/T94vQ0o20dy8jsXQTpL1JZNozGKQO5isGhJdaWqHwyc=w295-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/KfWBreFpJ-SQLsGp8YNFoqFWa9DOeWsedJ4F_DV02IQ=w295-h196-p-no");
		imatges.add("https://lh6.googleusercontent.com/a0lBzcDcEA2asUz3qe1UimAPS0PNPM31l05MIYeeSo8=w295-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/GRrmtTckCu_QP-H8pMoq0R2t-duCC52Qc4NyhQmlWWc=w295-h196-p-no");
		imatges.add("https://lh6.googleusercontent.com/3n52MwJpIuf00tyzfL_GqXVh-uDdvwQP164OQYMEup4=w295-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/iFQpEqCsrL1Gb7NBkQB8Ia2W7uUM2KR6zO7Mh3HpUds=w343-h228-p-no");
		imatges.add("https://lh6.googleusercontent.com/eMPuQvu6WGgeTRAPK356WCcLVep_MU5xphXsiKjAHps=w153-h228-p-no");
		imatges.add("https://lh6.googleusercontent.com/57lYqZlLzwZDBgQyh2SXKCnFgxMYjXqhW6CiEqyNxto=w295-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/MCJb9mXZ_cOeu8cK1DIE4aZ5y48qo3DhQS5z5cMxMQE=w296-h196-p-no");
		imatges.add("https://lh4.googleusercontent.com/V-1d_OnrNqrcF0eXs87o1ydQOMLzqfueKJvyDWV0AZ8=w295-h196-p-no");
		imatges.add("https://lh3.googleusercontent.com/M-YWqfSKvDYbvP3VH8_S1nISvNyRNgyFccZ-6g8cAts=w295-h196-p-no");

		Iterator<String> it = imatges.iterator();
		while (it.hasNext()) {
			new DownloadImageTask().execute(it.next());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.galeria, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class DownloadImageTask extends
			AsyncTask<String, Void, ArrayList<Bitmap>> {

		private ProgressDialog dialog = new ProgressDialog(GaleriaActivity.this);

		@Override
		protected void onPreExecute() {
			this.dialog.setMessage("Descarregant les imatges...");
			this.dialog.show();
		}

		protected ArrayList<Bitmap> doInBackground(String... urls) {
			// Obtenir totes les imatges d'Internet (via URL)
			for (String url : urls) {
				try {
					InputStream in = new java.net.URL(url).openStream();
					bitmaps.add(BitmapFactory.decodeStream(in));
				} catch (Exception e) {
					Log.e("Error", e.getMessage());
					e.printStackTrace();
				}
			}
			return bitmaps;
		}

		/**
		 * Al acabar la tasca:
		 */
		protected void onPostExecute(ArrayList<Bitmap> result) {
			if (this.dialog.isShowing()) {
				this.dialog.dismiss();
			}
			// Generar l'adaptador
			gridview.setAdapter(new ImageAdapter(GaleriaActivity.this, bitmaps));

		}
	}

}
