package com.example.myfirstownapplication;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

public class RandomAnimal extends View 
{
	Random r = new Random();
	private Handler mHandler = new Handler();
	private int loopvar = 0;
	public ArrayList <String>ar = new ArrayList<String>();
	public ArrayList <Bitmap>bmap = new ArrayList<Bitmap>();
    private int points = 0;
    private Bitmap ant,bat,bear,bull,camel,cat,cow,crow,dog,donkey,frog,goat,hen,horse,jackal,lion,lizard,monkey,mouse,owl,scorpion,snake,spider;
    
  //  Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.gameover);

	public RandomAnimal(Context context, AttributeSet attrs) 
	{
		super(context,attrs);
		Log.d("Constructer", "Called");
		ar.add("Megay");//ant
		ar.add("Khaaperak"); //bat
		ar.add("Melu"); // bear
		ar.add("Saandda");//bull
		ar.add("Ookh");//camel
		ar.add("Peesho");//cat
		ar.add("Ghwa");// cow
		ar.add("Kaarghuhh");//crow
		ar.add("Spay"); // dog
		ar.add("Khar");//donkey
		ar.add("Cheendakh");//frog
		ar.add("Bizza");//goat
		ar.add("Chargah");//hen
		ar.add("Asss"); //horse
		ar.add("Geedarh"); //jackal
		ar.add("Azmaray"); //lion
		ar.add("Charmakhkaye"); // lizard
		ar.add("Shaado"); // monkey
		ar.add("Munggak"); // mouse
		ar.add("Goong");//owl
		ar.add("Larram");//Scorpion
		ar.add("Maar"); //snake
		ar.add("Jolah"); //spider
		
		ant = BitmapFactory.decodeResource(getResources(), R.drawable.ant);
		bat = BitmapFactory.decodeResource(getResources(), R.drawable.bat);
		bear = BitmapFactory.decodeResource(getResources(), R.drawable.bear);
		bull = BitmapFactory.decodeResource(getResources(), R.drawable.bull);
		camel = BitmapFactory.decodeResource(getResources(), R.drawable.camel);
		cat = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
		cow = BitmapFactory.decodeResource(getResources(), R.drawable.cow);
		crow = BitmapFactory.decodeResource(getResources(), R.drawable.crow);
		dog = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
		donkey = BitmapFactory.decodeResource(getResources(), R.drawable.donkey);
		frog = BitmapFactory.decodeResource(getResources(), R.drawable.frog);
		goat = BitmapFactory.decodeResource(getResources(), R.drawable.goat);
		hen = BitmapFactory.decodeResource(getResources(), R.drawable.hen);
		horse = BitmapFactory.decodeResource(getResources(), R.drawable.horse);
		jackal = BitmapFactory.decodeResource(getResources(), R.drawable.jackal);
		lion = BitmapFactory.decodeResource(getResources(), R.drawable.lion);
		lizard = BitmapFactory.decodeResource(getResources(), R.drawable.lizard);
		monkey = BitmapFactory.decodeResource(getResources(), R.drawable.monkey);
		mouse = BitmapFactory.decodeResource(getResources(), R.drawable.mouse);
		owl = BitmapFactory.decodeResource(getResources(), R.drawable.owl);
		scorpion = BitmapFactory.decodeResource(getResources(), R.drawable.scorpion);
		snake = BitmapFactory.decodeResource(getResources(), R.drawable.snake);
		spider = BitmapFactory.decodeResource(getResources(), R.drawable.spider);

		bmap.add(ant);
		bmap.add(bat);
		bmap.add(bear);
		bmap.add(bull);
		bmap.add(camel);
		bmap.add(cat);
		bmap.add(cow);
		bmap.add(crow);
		bmap.add(dog);
		bmap.add(donkey);
		bmap.add(frog);
		bmap.add(goat);
		bmap.add(hen);
		bmap.add(horse);
		bmap.add(jackal);
		bmap.add(lion);
		bmap.add(lizard);
		bmap.add(monkey);
		bmap.add(mouse);
		bmap.add(owl);
		bmap.add(scorpion);
		bmap.add(snake);
		bmap.add(spider);
		// TODO Auto-generated constructor stub
	}

	private int index;
	private int list_index = 0;
	String animal_name;
	@Override
	
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setTextSize(50);
		paint.setAntiAlias(true);

        canvas.drawColor(Color.WHITE);
        index = r.nextInt(bmap.size());
		canvas.drawBitmap(bmap.get(index), 50, 200, null);

		if (loopvar < 5)
		{
			animal_name = ar.get(list_index);
			canvas.drawText(animal_name, 80, 100, paint);

			paint.setTextSize(30);
			canvas.drawText("Points : "+points, 5 , 30, paint);
             
		}

		if (loopvar >= 5)
		{
			canvas.drawColor(Color.BLACK);
			paint.setTextSize(40);
			paint.setColor(Color.WHITE);

			if (points < 80)
			{	
			canvas.drawText ("Test Failed",150 , 100 , paint);	
			}
			
			if (points >= 80)
			{	
			canvas.drawText ("Test Passed :)",100 , 100 , paint);	
			}
			
			paint.setTextSize(40);
			paint.setColor(Color.RED);
			canvas.drawText ("Choose Category",100 , 200 , paint);	
			canvas.drawText ("Play Again?",140 , 270 , paint);	
			//float textsize = paint.measureText("Tryagain");
			
			//alertDialog.show();
		}
		//waitfunc();
		//mHandler.removeCallbacks(mUpdateTimeTask);
		mHandler.postDelayed(mUpdateTimeTask, 1000);
	}

	private Runnable mUpdateTimeTask = new Runnable()
	{
		public void run()
		{
		   // if (loopvar < 5)
			invalidate();
		     // mHandler.postDelayed(mUpdateTimeTask, 400);
		}
	};

	public void callback()
	{
		mHandler.removeCallbacks(mUpdateTimeTask);
	}

    public void setloopvar(int a)
    {
    	loopvar = a;
    }

    public int getloopvar()
    {
    	return loopvar;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
      float eventX = event.getX();
      float eventY = event.getY();

      switch (event.getAction())
      {
      	case MotionEvent.ACTION_DOWN:
    	  Log.d("hello","Action was DOWN");
    	    loopvar = loopvar + 1;
			setloopvar(loopvar);
			Log.d("hello","Action was DOWN and loopvar is " + loopvar);

			
			if (index == 0 && animal_name.equals("Megay") || index == 1	&& animal_name.equals("Khaaperak") || index == 2 && animal_name.equals("Melu") || index == 3 && animal_name.equals("Saandda") || index == 4 && animal_name.equals("Ookh") || index == 5 && animal_name.equals("Peesho") || index == 6 && animal_name.equals("Ghwa") || index == 7 && animal_name.equals("Kaarghuhh") || index == 8 && animal_name.equals("Spay") || index == 9 && animal_name.equals("Khar") || index == 10 && animal_name.equals("Cheendakh") || index == 11 && animal_name.equals("Bizza")|| index == 12 && animal_name.equals("Chargah")|| index == 13 && animal_name.equals("Asss")|| index == 14 && animal_name.equals("Geedarh")|| index == 15 && animal_name.equals("Azmaray")|| index == 16 && animal_name.equals("Charmakhkaye")|| index == 17 && animal_name.equals("Shaado")|| index == 18 && animal_name.equals("Munggak")|| index == 19 && animal_name.equals("Goong")|| index == 20 && animal_name.equals("Larram")|| index == 21 && animal_name.equals("Maar")|| index == 22 && animal_name.equals("Jolah")) 
			{
				points = points + 20;	
			}

            
			if (loopvar < 5)
			{
			ar.remove(list_index);
			list_index = r.nextInt(ar.size());	
			}

			/*
			if (loopvar >= 5)
			{
				Log.d("hi","x"+eventX);
				Log.d("hi","y"+eventY);	
			}
			*/
            if (loopvar >=5 && eventX >= 95 && eventX <= 410 && eventY >= 175 && eventY <=202 )
            {
            	Log.d("Choose Category", "Category was clicked");
            	//Intent i = new Intent(, MenuActivity.class);
            	//StartActivity(i);
            }
			
            
            
            if (loopvar >=5 && eventX >= 140 && eventX <= 346 && eventY >= 240 && eventY <=271 )
            {
            	Log.d("Play Again", "Play again clicked");
            	
            }
            
            
			//Toast.makeText(RandomAnimal.this, " " + loopvar, Toast.LENGTH_SHORT).show(); 
        return true;
      case MotionEvent.ACTION_MOVE:
        return false;
      case MotionEvent.ACTION_UP:
        // nothing to do
       return false;
      default : 
          return super.onTouchEvent(event);

      }
    }

	private void StartActivity(Intent i) {
		// TODO Auto-generated method stub
		
	}
}
