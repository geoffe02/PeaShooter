package com.example.peashooter;







import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {

	/** Status Codes to pass through functions **/
	public static final int OK_PRESSED = 0;
	public static final int CANCEL_PRESSED = 1;
	public static final String LABEL = "LABEL";
	//public static final String INPUTTED_TEXT = "INPUTTED_TEXT";
	public static final String USERFIELD = "USERNAME";
	public static final String EMAILFIELD = "EMAIL";
    public static final String PASSFIELD = "PASSWORD";
	
	 /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        TextView formType = (TextView) findViewById(R.id.formTypeLabel);

        Intent intent = getIntent();
        formType.setText(intent.getStringExtra(LABEL));
    
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
    	
        EditText fullname = (EditText) findViewById(R.id.editTextFullName);
        EditText email = (EditText) findViewById(R.id.editTextEmail);
        EditText password = (EditText) findViewById(R.id.editTextPassword);
    	
        		data.putExtra(USERFIELD, fullname.getText().toString());
        		data.putExtra(EMAILFIELD, email.getText().toString());
        		data.putExtra(PASSFIELD, password.getText().toString());
        	
    	        
    	setResult(resultCode, data);
    	finish();
    }

}


