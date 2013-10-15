package com.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityAsyncTask extends Activity implements android.view.View.OnClickListener{

	// VARIABLES
	public static final String TAG = "ActivityAsyncTask";
	TextView textview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_async_task);
		
		// get control
		Button btn = (Button) findViewById(R.id.button1);
		textview = (TextView) findViewById(R.id.textView2);
		
		btn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_async_task, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		super.onKeyDown(keyCode, event);
		
		if(keyCode ==KeyEvent.KEYCODE_BACK){
			System.exit(0);
		}
		
		return false;
		
	}
	private class AsyncTask1 extends AsyncTask<String, Void, Integer>{

		protected void onPreExecute(){
			Log.i(TAG, "onPreExecute");
		}
		
		protected Integer doInBackground(String... params) {
			Log.i(TAG, "doInBackground");
			
			String a = params[0];
			int soa = Integer.valueOf(a);
			for(int i = 0; i < 1000000; i++){
				soa ++;
			}
			
			// TODO Auto-generated method stub
			return soa;
		}
		
		protected void onPostExecute(Integer a){
			Log.i(TAG, "onPostExecute");
			Toast.makeText(getApplicationContext(), ""+a, Toast.LENGTH_LONG).show();
			textview.setText(""+a);
		}
		
		protected void onCancelled(){
			Log.i(TAG, "onCancelled");
		}
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view.getId() == R.id.button1){
			new AsyncTask1().execute("1");
		}
	}



	
}
