package com.example.myfirstownapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
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

public class Adjectives_Activity extends Activity implements OnItemClickListener{
	
	
	//Private Controls and Objects
	ListView lv_Adj;

	
	ArrayList<Word> General = new ArrayList<Word>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adjectives_layout);
		
		//Get Controls from XML
				lv_Adj=(ListView)findViewById(R.id.listadj);
				GetWords Help = new GetWords(this);
				General = Help.getWords(8);
				try
				{
						
					String s = General.get(0).getEnglish();
					//Setting Adapter
					ArrayAdapter<Word> count_Adapter=new ArrayAdapter<Word>(this,R.layout.list_layout,General );

					lv_Adj.setAdapter(count_Adapter);	
					lv_Adj.setOnItemClickListener(this);

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
		Button Pron = (Button)finaldisplay.findViewById(R.id.pronunciation);
		final String pronun = General.get(position).getPron();
		// if button is clicked, close the custom dialog
		Exit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finaldisplay.dismiss();
			}
		});		
		Pron.setOnClickListener(new OnClickListener() {


			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					System.out.println(pronun);
					AssetFileDescriptor afd = getAssets().openFd(pronun);
					
				    MediaPlayer player = new MediaPlayer();
				    
				    System.out.println(afd.getLength());
				    player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
				    afd.close();
				    //player.setDataSource(afd.getFileDescriptor());
				    
				    player.prepare();
				    
				    player.start();
				    } 
				catch (Exception e) { 
					e.printStackTrace();
				} 			
			}
		});
		finaldisplay.show();
	}

}
