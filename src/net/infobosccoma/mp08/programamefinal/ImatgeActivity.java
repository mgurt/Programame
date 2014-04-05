package net.infobosccoma.mp08.programamefinal;

import net.infobosccoma.mp08.programame.model.LlistaImatges;
import net.infobosccoma.mp08.programame.utils.BitmapUtils;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImatgeActivity extends Activity implements OnClickListener {

	private ImageButton btnAnterior, btnTancar, btnSeguent;
	private ImageView imgDeLaGaleria;
	private int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imatge);

		initComponents();
	}

	private void initComponents() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
		btnAnterior = (ImageButton) findViewById(R.id.btnAnterior);
		btnAnterior.setOnClickListener(this);
		btnTancar = (ImageButton) findViewById(R.id.btnTancar);
		btnTancar.setOnClickListener(this);
		btnSeguent = (ImageButton) findViewById(R.id.btnSeguent);
		btnSeguent.setOnClickListener(this);
		imgDeLaGaleria = (ImageView) findViewById(R.id.imgDeLaGaleria);

		// Obtenir les imatges de la llista i la posició seleccionada
		position = getIntent().getIntExtra("position", 0);
		// Assignar la imatge
		assignarImatge(position);
	}

	private void assignarImatge(int position) {
		if(position >= 0 && position < LlistaImatges.getBitmaps().size()){
			if (position == 0) {
				btnAnterior.setEnabled(false);
			} else if (position == LlistaImatges.getBitmaps().size()-1) {
				btnSeguent.setEnabled(false);
			} else {
				btnAnterior.setEnabled(true);
				btnSeguent.setEnabled(true);
			}
			
			// Obtenir les mides de la imatge
			int weight = LlistaImatges.getBitmaps().get(position).getWidth();
			int height = LlistaImatges.getBitmaps().get(position).getHeight();
			
			// Redimensionar segons conveniencia
			if(weight > height){
				imgDeLaGaleria.setImageBitmap(BitmapUtils.getResizedBitmap(LlistaImatges.getBitmaps().get(position), 600, 800));
			} else {
				imgDeLaGaleria.setImageBitmap(BitmapUtils.getResizedBitmap(LlistaImatges.getBitmaps().get(position), 800, 600));
			}
		}	

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.imatge, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAnterior:
			assignarImatge(position--);
			break;
		case R.id.btnSeguent:
			assignarImatge(position++);
			break;
		case R.id.btnTancar:
			finish();
			break;
		default:
			break;
		}
	}

}
