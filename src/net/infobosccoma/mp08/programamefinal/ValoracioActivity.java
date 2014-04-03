package net.infobosccoma.mp08.programamefinal;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.ActionBar;
import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ValoracioActivity extends Activity {

	private Button btnGuardar;
	private MediaRecorder recorder;
	private String desti;
	private boolean grabar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_valoracio);
		grabar = false;
		initComponents();
	}

	/**
	 * 
	 */
	private void initComponents() {
		/* ACTION BAR */
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		/* INICIALITZAR I ASSIGNAR ACCIÓ AL BOTÓ DE GUARDAR ÀUDIO */
		btnGuardar = (Button) findViewById(R.id.btnGuardar);
		btnGuardar.setText("Iniciar gravació");
		btnGuardar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// GRAVAR
				if(!grabar){
					btnGuardar.setText("Parar gravació");
					try {
						startRecording();
					} catch (IOException e) {
						Toast.makeText(ValoracioActivity.this, "No s'ha trobat l'emmagatzamament extern", Toast.LENGTH_SHORT).show();
					}
					grabar = true;
					// GUARDAR GRAVACIÓ
				} else {
					btnGuardar.setText("Iniciar gravació");
					stopRecording();
					grabar = false;
				}

			}
		});
	}
	
	/**
	 * Començar la gravació d'àudio
	 * @throws IOException
	 */
	public void startRecording() throws IOException {

		recorder = new MediaRecorder();
		// D'on ha de gravar
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		// Codec d'audio
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		// Format
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		// Fitxer de sortida
		desti = getNomFitxer().getAbsolutePath();
		recorder.setOutputFile(desti);
		// Preparar
		recorder.prepare();
		// Començar la gravacio
		recorder.start();
	}

	public void stopRecording() {
		recorder.stop();
		recorder.release();
		recorder = null;
		
		Toast.makeText(this, "Valoració guardada a " + desti, Toast.LENGTH_SHORT).show();
	}
	
	/*
	 * Establir el nom del fitxer on es desarà el vídeo
	 */
	private File getNomFitxer() {
		// Create an image file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date());
		String recordFileName = "valoracio_" + timeStamp + ".3gp";
		File path = new File(Environment.getExternalStorageDirectory(),
				"Programame");
		if (!path.exists())
			path.mkdirs();

		return new File(path, recordFileName);
	}

}