package com.example.peashooter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends Activity {
	public static final String LABEL = "LABEL";
	public static final int OK_PRESSED = 0;
	public static final int CANCEL_PRESSED = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		
		
		
		Button done = (Button) findViewById(R.id.buttonOK);
	    done.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				close(OK_PRESSED);
			}
		});
	    
	    Button cancel = (Button) findViewById(R.id.buttonCancel);
	    cancel.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				close(CANCEL_PRESSED);				
			}
		});
	}
	
    private void close(int resultCode)
    {
    	Intent data = getIntent();
    	        
    	setResult(resultCode, data);
    	finish();
    }
}
