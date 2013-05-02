package com.example.myfirstownapplication;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow.LayoutParams;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;


public class colorGame_Activity extends Activity 
{

	private RandomColours randomcolor;
   
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        
		super.onCreate(savedInstanceState);
	    /*
		LinearLayout  lly = new LinearLayout(this);
		LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT ,
                LinearLayout.LayoutParams.WRAP_CONTENT ); 
		
		Button btn = new Button(this);
		btn.setText("Colors 0_0");
		*/
		//RelativeLayout.LayoutParams rel_btn = new RelativeLayout.LayoutParams(
        //LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		//rel_btn.addRule(RelativeLayout.CENTER_VERTICAL);
		//rel_btn.addRule(RelativeLayout.CENTER_IN_PARENT);
		
		//btn.setLayoutParams(rel_btn);		
		
		//btn.setOnClickListener(this);
		//lly.addView(btn,lParams);
		 
		 setContentView(R.layout.colorgame_layout);
		 /*
		 AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		 alertDialog.setTitle("Reset...");
		 alertDialog.setMessage("R u sure?");
		 alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		      public void onClick(DialogInterface dialog, int which) {
		 
		       //here you can add functions
		 
		    } }); 
		 alertDialog.setIcon(R.drawable.ic_launcher);
		 if(randomanimal.getloopvar() > 5)
		 {
			 alertDialog.show();
			 
		 }
		 */
		//TextView text = (TextView) findViewById(R.id.tv);
		//randomcolor = new RandomColours(this, null);
        //lly.addView(randomcolor);
     //   final Button button = (Button) findViewById(R.id.ButtonCount);
       
        // button.setBackgroundColor(Color.RED);
        /*
   

        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) 
			{
				//Integer a = randomcolor.getcolor();
				int loopvar = randomcolor.getloopvar();
				loopvar = loopvar + 1;
				randomcolor.setloopvar(loopvar);
				Toast.makeText(MainActivity.this, " " + loopvar, Toast.LENGTH_SHORT).show();  	
			    
				// TODO Auto-generated method stub
			}
        });
    */
 
	}	
}     