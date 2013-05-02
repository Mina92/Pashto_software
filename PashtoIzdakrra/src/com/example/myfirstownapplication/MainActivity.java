package com.example.myfirstownapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener    {

	Button learn;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		learn = (Button)findViewById(R.id.learn);
		learn.setOnClickListener(this);		
		
	}
	
	public String getUserName(){
		SharedPreferences settings = getSharedPreferences("pashto_prefs", 0);
	       String userName = settings.getString("username", "");
	       return userName;

	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	/*	switch (v.getId()){
		case R.id.learn:
			Intent learn = new Intent(this,Start_Activity.class);
			startActivity(learn);
		}*/
		
		
		
		
		switch (v.getId()){
		case R.id.learn:
			if(getUserName().equals("")){
			Intent learn = new Intent(this,Start_Activity.class);
			startActivity(learn);
			this.finish();
			}else{
				Intent menuIntent=new Intent(this,MenuActivity.class);
				startActivity(menuIntent);
				this.finish();
			}
			break;
			
			default:
				break;
		}
		
	}
	
}