package com.rashad.nebula;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Timer extends Activity {

	private Button startButton;
	private Button pauseButton;

	private TextView timerValue;

	private long startTime = 0L;

	private Handler customHandler = new Handler();

	long timeInMilliseconds = 0L;
	long timeSwapBuff = 0L;
	long updatedTime = 0L;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		
		timerValue = (TextView) findViewById(R.id.timerValue);

		startButton = (Button) findViewById(R.id.startButton);

        pauseButton = (Button) findViewById(R.id.pauseButton);
        
        startButton.setOnClickListener(StartListener);
        pauseButton.setOnClickListener(PauseListener);
        
        
	}
	

	public OnClickListener StartListener = new OnClickListener(){

		@Override
		public void onClick(View v) {


				startTime = SystemClock.uptimeMillis();
				customHandler.postDelayed(updateTimerThread, 0);

		}
		
	};
	
	public OnClickListener PauseListener = new OnClickListener(){

		@Override
		public void onClick(View v) {

			timeSwapBuff += timeInMilliseconds;
			customHandler.removeCallbacks(updateTimerThread);
		}
		
	};
	
	private Runnable updateTimerThread = new Runnable() {

		public void run() {

			timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

			updatedTime = timeSwapBuff + timeInMilliseconds;

			int secs = (int) (updatedTime / 1000);
			int mins = secs / 60;
			secs = secs % 60;
			int milliseconds = (int) (updatedTime % 1000);
			timerValue.setText("" + mins + ":"
					+ String.format("%02d", secs) + ":"
					+ String.format("%03d", milliseconds));
			customHandler.postDelayed(this, 0);
		}

	};
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.timer, menu);
		return true;
	}

}
