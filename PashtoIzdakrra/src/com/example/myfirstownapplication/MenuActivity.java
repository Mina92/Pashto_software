package com.example.myfirstownapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity implements OnClickListener {

	Button Basic, Counting, Animals, Relations, Body_Parts, Sentences, Nouns, Verbs, Adjectives, Colors, Questions, Logout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//Setting Design Layout
		setContentView(R.layout.grid_layout);

		//Creating buttons
		Basic=(Button)findViewById(R.id.basic);
		Counting=(Button)findViewById(R.id.counting);
		Animals=(Button)findViewById(R.id.animals);
		Relations=(Button)findViewById(R.id.relations);
		Body_Parts=(Button)findViewById(R.id.body_parts);
		Sentences=(Button)findViewById(R.id.sentences);
		Nouns=(Button)findViewById(R.id.nouns);
		Verbs=(Button)findViewById(R.id.verbs);
		Adjectives=(Button)findViewById(R.id.adjectives);
		Colors=(Button)findViewById(R.id.colors);
		Questions=(Button)findViewById(R.id.questions);
		Logout = (Button)findViewById(R.id.logout);
		
		//Activating OnClick
		Basic.setOnClickListener(this);
        Counting.setOnClickListener(this);
        Animals.setOnClickListener(this);
        Relations.setOnClickListener(this);
        Body_Parts.setOnClickListener(this);
        Sentences.setOnClickListener(this);
        Nouns.setOnClickListener(this);
        Verbs.setOnClickListener(this);
        Adjectives.setOnClickListener(this);
        Colors.setOnClickListener(this);
        Questions.setOnClickListener(this);
        Logout.setOnClickListener(this);
       
      
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		case R.id.basic:
			Intent basicIntent=new Intent(this,Basics_Activity.class);
			startActivity(basicIntent);
			break;
			
		case R.id.counting:
			Intent countingIntent=new Intent(this,Counting_Activity.class);
			startActivity(countingIntent);
			break;
			
		case R.id.relations:
			Intent relationsIntent=new Intent(this,Relations_Activity.class);
			startActivity(relationsIntent);
			break;
			
		case R.id.body_parts:
			Intent body_partsIntent=new Intent(this,BodyParts_Activity.class);
			startActivity(body_partsIntent);
			break;
		
		case R.id.animals:
			Intent animalsIntent=new Intent(this,AnimalsActivity.class);
			startActivity(animalsIntent);
			break;
			
		case R.id.nouns:
			Intent nounsIntent=new Intent(this,Nouns_Activity.class);
			startActivity(nounsIntent);
			break;
		
		case R.id.verbs:
			Intent verbsIntent=new Intent(this,Verbs_Activity.class);
			startActivity(verbsIntent);
			break;
			
		case R.id.adjectives:
			Intent adjIntent=new Intent(this,Adjectives_Activity.class);
			startActivity(adjIntent);
			break;
			
		case R.id.sentences:
			Intent sentIntent=new Intent(this,Sentences_Activity.class);
			startActivity(sentIntent);
			break;
			
		case R.id.colors:
			
			Intent colorIntent=new Intent(this,Colors_Activity.class);
			startActivity(colorIntent);
			break;
			
		case R.id.questions:
			Intent quesIntent=new Intent(this,Questions_Activity.class);
			startActivity(quesIntent);
			break;
			
		case R.id.logout:
			clearAppData();
			
			Intent mainIntent = new Intent(this,MainActivity.class);
			startActivity(mainIntent);
			this.finish();
		}
		
		
		
		
		
		
		
	}
	
	
	public void clearAppData(){
		
		Editor editor = 
				this.getSharedPreferences("pashto_prefs", Context.MODE_PRIVATE).edit();
				editor.clear();
				editor.commit();
	}
	
	

}
