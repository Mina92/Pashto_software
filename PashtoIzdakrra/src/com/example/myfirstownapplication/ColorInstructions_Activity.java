package com.example.myfirstownapplication;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ColorInstructions_Activity extends Activity implements OnClickListener{

	Button proceed_color;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colorinstruction_layout);
		
		proceed_color = (Button)findViewById(R.id.colorproceed);
		proceed_color.setOnClickListener(this);
	
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
		case R.id.colorproceed: 
			Intent i = new Intent(this, colorGame_Activity.class);
			startActivity(i);
		}
	}

	
	
	
}
