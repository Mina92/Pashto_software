package com.example.myfirstownapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Animalsinstructions_Activity extends Activity implements OnClickListener{
	Button proceed_animal;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animalinst_layout);
		
		proceed_animal = (Button)findViewById(R.id.animalproceed);
		proceed_animal.setOnClickListener(this);
	
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.animalproceed: 
			Toast.makeText(this, "Start Game", 5000).show();
			Intent gameIntent=new Intent(this,AnimalGameActivity.class);
			startActivity(gameIntent);
		}
	}

}
