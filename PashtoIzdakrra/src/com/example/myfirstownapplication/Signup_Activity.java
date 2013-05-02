package com.example.myfirstownapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup_Activity extends Activity implements OnClickListener{

	EditText Name, Username;
	Button Signin;
	ArrayList<User> Users = new ArrayList<User>();
	String name, username;
	boolean check;
    GetWords Match ;//= new GetWords(this); 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		//Setting Design Layout
		setContentView(R.layout.signup_layout);
		
 
        //Getting Controls
		Signin=(Button)findViewById(R.id.Signin);

		//OnClick
		Signin.setOnClickListener(this);
		
		   Log.i("yes1", "yes1");

	    Name = (EditText)findViewById(R.id.editname);
	    name = Name.getText().toString();
		   Log.i("yes2", "yes2");

	    Username = (EditText)findViewById(R.id.editusername);
	    username = Username.getText().toString();
	   Log.i("yes3", "yes3");
	
	     Match = new GetWords(this);

		Users = Match.getUsers();
	   
	    
	
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.Signin:
			if (!check)
			{
			    Log.i("yes5", "yes5");

			    Log.i("yes6", "yes6");

			   name=Name.getText().toString();
			   username=Username.getText().toString();
			 
			   //Checking if user already exist
			   check = false;
				if(!Users.isEmpty())
				{
					for(int i=0 ; i<Users.size(); i++ )
					{
						if(username.equals(Users.get(i).getUsername()))
						{
							check = true;
						}
				    Log.i("yes4", "yes4");

					}
			    
				}
			   if(!check){
				Match.SaveUser(name, username);
				Toast.makeText(this,"Data saved", 5000).show();
				Intent menuIntent=new Intent(this,MenuActivity.class);
				
				startActivity(menuIntent);
				this.saveUserName(name);
				Toast.makeText(this,"Welcome :)", 5000).show();
				this.finish();
			   }else{
				Toast.makeText(this, "User already exists.", Toast.LENGTH_LONG).show();
			   }

			
				break;

			}
			else
			{
				Toast.makeText(this,"Username already used. Please try again.", 5000).show();

			}
		}
	}
}	

