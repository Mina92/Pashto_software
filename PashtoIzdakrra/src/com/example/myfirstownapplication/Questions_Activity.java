package com.example.myfirstownapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Questions_Activity extends Activity implements OnItemClickListener{

	
	ListView lv_Ques;
	ArrayList<Word> General = new ArrayList<Word>();

	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questions_layout);

		//Get Controls from XML
		lv_Ques=(ListView)findViewById(R.id.list_ques);
		GetWords Help = new GetWords(this);
		General = Help.getWords(3);
		try
		{
				
			String s = General.get(0).getEnglish();
			//Setting Adapter
			ArrayAdapter<Word> count_Adapter=new ArrayAdapter<Word>(this,R.layout.list_layout,General );

			lv_Ques.setAdapter(count_Adapter);	
			lv_Ques.setOnItemClickListener(this);

		}
		catch (Exception e) 
		{
			System.out.println("Done");
			e.printStackTrace();
		}
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Item "+position+" clicked!", 1000).show();
		Toast.makeText(this, "Item "+position+" clicked!", 1000).show();
		final Dialog finaldisplay = new Dialog(this);
		finaldisplay.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		finaldisplay.setContentView(R.layout.dialog);
		TextView eng = (TextView) finaldisplay.findViewById(R.id.Eng_word);		
		TextView pashto = (TextView) finaldisplay.findViewById(R.id.pashto_word);
		String engl = General.get(position).getEnglish();
		String pash = General.get(position).getPashto();
		eng.setText(engl);
		pashto.setText(pash);
		
		Button Exit = (Button) finaldisplay.findViewById(R.id.exit);
		// if button is clicked, close the custom dialog
		Exit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finaldisplay.dismiss();
			}
		});		
		finaldisplay.show();


	}

}
