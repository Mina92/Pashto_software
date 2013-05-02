package com.example.myfirstownapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Start_Activity extends Activity implements OnClickListener    {
	
	//Private objects and controls
	//Button
	Button btnSignin,btnSignup;
	EditText txtUsername;
	ArrayList<User> users;
	GetWords modelWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Getting Controls
        btnSignin=(Button)findViewById(R.id.btnSignin);
        btnSignup=(Button)findViewById(R.id.btnSignup);
        txtUsername=(EditText)findViewById(R.id.txtUserName);
        
        //Setting onClick
        btnSignin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
        
        modelWords=new GetWords(this);
    }
    
	private void saveUserName(String username){
		  // We need an Editor object to make preference changes.
	      // All objects are from android.context.Context
	      SharedPreferences settings = getSharedPreferences("pashto_prefs", 0);
	      SharedPreferences.Editor editor = settings.edit();
	      editor.putString("username",username);

	      // Commit the edits!
	      editor.commit();
	}
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.btnSignin:
			
			String userName=txtUsername.getText().toString();
			if(userName.equals("")){
				Toast.makeText(this, "Please enter Username", Toast.LENGTH_LONG).show();
			}else{
				if(checkSignin(userName)){
					saveUserName(userName);
					Intent menuIntent=new Intent(this,MenuActivity.class);
					startActivity(menuIntent);
				}else{
					Toast.makeText(this, "Username does not exist, Please Sign up.", Toast.LENGTH_LONG).show();
				}
				
			}
		
			//Toast.makeText(this,"Sign in button press ho gaya ab kya karoon naachoon ?", 2000).show();
			break;
		case R.id.btnSignup:
			Intent signupIntent=new Intent(this,Signup_Activity.class);
			startActivity(signupIntent);
			//Toast.makeText(this, "Sign up ke liye bhaar main jayen", 2000).show();
			break;

		default:
			break;
		}
	}
	
	public boolean checkSignin(String username){
		boolean signedIn=false;
		
		users=modelWords.getUsers();
		
		if(!users.isEmpty()){
		for(int i=0;i<users.size(); i++){
			if(users.get(i).getUsername().equals(username)){
				signedIn=true;
				break;
			}
		}
		}
		
		return signedIn;
	}
	
	
    
}
