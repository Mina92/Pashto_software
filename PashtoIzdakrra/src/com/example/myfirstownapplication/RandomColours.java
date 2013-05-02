package com.example.myfirstownapplication;

import java.util.Random;

import android.app.AlertDialog;
import android.content.Context;
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
import android.widget.Toast;
import java.util.ArrayList;



public class RandomColours extends View 
{
	Random r = new Random();
	private Handler mHandler = new Handler();
	private int loopvar = 0;
	public ArrayList <String>ar = new ArrayList<String>();
    private int points = 0;
    Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.gameover);
	

    
	public RandomColours(Context context, AttributeSet attrs) 
	{
		super(context,attrs);
		Log.d("Constructer", "Called");
		ar.add("Tor"); //black
		ar.add("Sur"); // red
		ar.add("Oodi");//blue
		ar.add("Shin");//green
		ar.add("Naswari"); // brown
		ar.add("Zeyr"); // yellow
		ar.add("Kharr"); //grey
		ar.add("Ghulaabi"); //pink
		// TODO Auto-generated constructor stub
	}

	private Integer[] mBackgrounds =
		{ Color.GRAY, Color.RED,Color.GREEN,
			 Color.YELLOW, Color.BLACK, Color.BLUE }; // DONT EDIT THE ARRAY

	private int index;
	private int list_index = 0;
	String pushto_color;
	@Override
	
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(45);
		paint.setAntiAlias(true);

		//canvas.drawColor(Color.BLACK);
		
		index = r.nextInt(8);
		if (index <= 5)
		{
			canvas.drawColor(mBackgrounds[index]);
		}

		if (index == 6)
		{
			canvas.drawColor(Color.rgb(255, 20, 147)); // pink
		}

		if (index == 7)
		{
			canvas.drawColor(Color.rgb(139, 69, 19));//brown
		}

		if (loopvar < 5)
		{
		pushto_color = ar.get(list_index);
		canvas.drawText(pushto_color, 150, 100, paint);
		paint.setTextSize(35);
		canvas.drawText("Points : "+points, 5 , 40, paint);		
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
		mHandler.postDelayed(mUpdateTimeTask, 1200);
	    
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
	
/*	public void callback()
	{
		mHandler.removeCallbacks(mUpdateTimeTask);
	
	}

*/
	public int getcolor()
	{
		return mBackgrounds[index];
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

			if (index == 4 && pushto_color.equals("Tor") || index == 1 && pushto_color.equals("Sur")||index == 5 && pushto_color.equals("Asmaani Shin")||index == 2 && pushto_color.equals("Panay Shin")||index == 7 && pushto_color.equals("Naswari")||index == 3 && pushto_color.equals("Zeyr")||index == 0 && pushto_color.equals("Khar")||index == 6 && pushto_color.equals("Ghulaabi"))
			{
				points = points + 20;	
			}

			if (loopvar < 5)
			{
			ar.remove(list_index);
			list_index = r.nextInt(ar.size());	
			}

			if (loopvar >=5 && eventX >= 95 && eventX <= 410 && eventY >= 175 && eventY <=202 )
            {
            	Log.d("Choose Category", "Category was clicked");
            	
            }
			
            
            
            if (loopvar >=5 && eventX >= 140 && eventX <= 346 && eventY >= 240 && eventY <=271 )
            {
            	Log.d("Play Again", "Play again clicked");
            	
            }		
			
			//Toast.makeText(RandomColours.this, " " + loopvar, Toast.LENGTH_SHORT).show(); 
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
}

