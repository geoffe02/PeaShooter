package com.example.peashooter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private EditText personNameEditText;
	private EditText passwordEditText;

	 /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        personNameEditText = (EditText) findViewByID(R.id.editTextPersonName);
        passwordEditText = (EditText) findViewByID(R.id.editTextPassword);
        
    }
}
