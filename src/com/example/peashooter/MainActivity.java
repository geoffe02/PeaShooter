package com.example.peashooter;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends Activity {
	public static final int CREATEUSER = 0; 
	public static final int WELCOMEUSER = 1;
	public String loginName;
	public String loginPass;
	


	 /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button createUser = (Button) findViewById(R.id.buttonNewUser);
        createUser.setOnClickListener(new OnClickListener() 
        {		
			public void onClick(View v) 
			{
				openRegister(CREATEUSER, "Create User");
			}
		});
        

        Button signIn = (Button) findViewById(R.id.buttonSignin);
        signIn.setOnClickListener(new OnClickListener() 
        {
        		public void onClick(View v)
        		{
        			// Checking for empty fields
        			
        			
        			
        			EditText userName = (EditText) findViewById(R.id.editTextUserName);
        			EditText passWord = (EditText) findViewById(R.id.editTextPassword);
        			if (fieldsOK(userName, passWord))
        			{
        				Context context = getApplicationContext();
        				CharSequence text = "Empty Fields";
        				int duration = Toast.LENGTH_SHORT;
        				    
        				Toast toast = Toast.makeText(context, text, duration);
        				toast.show();
        			}
        			else if ( (fieldsMatch(loginName, userName.toString()) && fieldsMatch(loginPass, passWord.toString())) )
        			{
        				Context context = getApplicationContext();
        				CharSequence text = "Invalid Credentials";
        				int duration = Toast.LENGTH_SHORT;
        				    
        				Toast toast = Toast.makeText(context, text, duration);
        				toast.show();
        			}
        			else
        			{
        				openWelcome(WELCOMEUSER, "Welcome User");
        			}
        		}

        });
        
}
    
    private void openRegister(int requestCode, String label)
    {  	
    	    Intent intent = new Intent(this, RegisterActivity.class);
    	    intent.putExtra(RegisterActivity.LABEL, label);
       	startActivityForResult(intent, requestCode);
    }
    
    private void openWelcome(int requestCode, String label)
    {  	
    	    Intent intent = new Intent(this, WelcomeActivity.class);
    	    intent.putExtra(WelcomeActivity.LABEL, label);
       	startActivityForResult(intent, requestCode);
    }
    public boolean fieldsOK(EditText Text1, EditText Text2) {
        return (Text1.getText().toString().trim().length() == 0) || (Text2.getText().toString().trim().length() == 0);
    }
    
    public boolean fieldsMatch(String Text1, String Text2) {
        return (Text1 == Text2);
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	if (resultCode == RegisterActivity.CANCEL_PRESSED)
    	{
    		System.out.println("CANCEL PRESSED");
    	}
    	else
    	{
    		TextView showUser;
    		TextView showEmail;
    		TextView showPassword;
    		String value1 = data.getStringExtra(RegisterActivity.USERFIELD);
    		String value2 = data.getStringExtra(RegisterActivity.EMAILFIELD);
    		String value3 = data.getStringExtra(RegisterActivity.PASSFIELD);
    		loginName = value2;
    		loginPass = value3;
    		switch (requestCode)
    		{
    			case CREATEUSER:
    				showUser = (TextView) findViewById(R.id.FullNameVal);
    				showUser.setText(value1);
    				showEmail = (TextView) findViewById(R.id.EmailVal);
    				showEmail.setText(value2);
    				showPassword = (TextView) findViewById(R.id.PassWordVal);
    				showPassword.setText(value3);
    				break;
    		}
    	}
    }
}
