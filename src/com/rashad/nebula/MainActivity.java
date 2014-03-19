package com.rashad.nebula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	Button camera;
	Button memo;
	Button recorder;
	Button about;
	Button torch;
	Button apps;
	Button calculator;
	Button timer;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		camera = (Button) findViewById(R.id.camera);
		torch = (Button) findViewById(R.id.torch);
		calculator = (Button) findViewById(R.id.calculator);
		timer = (Button) findViewById(R.id.timer1);
		
		camera.setOnClickListener(CameraListener);
		torch.setOnClickListener(torchListener);
		calculator.setOnClickListener(calculatorListener);
		timer.setOnClickListener(TimerListener);
		
		
		
	}
	

	
	public OnClickListener CameraListener = new OnClickListener(){

		@Override
		public void onClick(View v) {

			    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

			    startActivityForResult(intent, 0);

		}
		
	};
		


	

	
	
		

	
		
	public OnClickListener torchListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			
			Intent myIntent = new Intent(MainActivity.this, Torch.class);
			MainActivity.this.startActivity(myIntent);
			
		}
		
	};
		
		
	public OnClickListener calculatorListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			
			Intent myIntent = new Intent(MainActivity.this, Caclulator.class);
			MainActivity.this.startActivity(myIntent);
		}
		
	};
		
		

	
	
	
	
	
	
	
	

	
	
	
	public OnClickListener TimerListener = new OnClickListener(){
		@Override
		public void onClick(View v) {
			Intent myIntent = new Intent(MainActivity.this, Timer.class);
			MainActivity.this.startActivity(myIntent);
		}
		
	};
	
	
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		
		 menu.add(0, 1, 0, "about nebula");
		 menu.add(0, 2, 1, "Quit");
		 
		return true;
	}
		
	
		 public boolean onOptionsItemSelected(MenuItem item) {
			    switch (item.getItemId()) {
			    case 1:
			    	
			    	Intent myIntent = new Intent(MainActivity.this, About.class);
					MainActivity.this.startActivity(myIntent);
					
			        ;
			        return true;
			    case 2:
			        finish();
			        return true;
			    }
			    return false;
			}

}
