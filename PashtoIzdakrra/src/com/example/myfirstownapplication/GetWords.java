package com.example.myfirstownapplication;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class GetWords 
{
	protected static final String TAG = "DataAdapter"; 
	 
    private final Context mContext; 
    private SQLiteDatabase mDb; 
    private DataBaseHelper mDbHelper; 
	

    public GetWords open() throws SQLException  
    { 
        try  
        { 
            mDbHelper.openDataBase(); 
            mDbHelper.close(); 
            mDb = mDbHelper.getReadableDatabase(); 
        }  
        catch (SQLException mSQLException)  
        { 
            Log.e(TAG, "open >>"+ mSQLException.toString()); 
            throw mSQLException; 
        } 
        return this; 
    } 
 
    public void close()  
    { 
        mDbHelper.close(); 
    } 
    
    public GetWords(Context context)
    {
    	this.mContext = context; 
    
    
    	mDbHelper = new DataBaseHelper(mContext);
    	try {
    		mDbHelper.createDataBase();
    	} catch (IOException mIOException)
    	{
    	
    	}
    }
    
    public GetWords createDatabase() throws SQLException  
    { 
        try  
        { 
            mDbHelper.createDataBase(); 
        }  
        catch (IOException mIOException)  
        { 
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase"); 
            throw new Error("UnableToCreateDatabase"); 
        } 
        return this; 
    } 
 
    
    

	public ArrayList<Word> getWords(int cat)
	{
		// open db connection		   
		// run query and get all words		   
	    // create Word object for each record and store in foos		   
		// close db
		   
		
		ArrayList<Word> words = new ArrayList<Word>();
		   
		   Word element;
		   Cursor c= null;		   
		   String select = "SELECT * FROM Word WHERE Cat_Id = " + cat;	   
		   try {			   	
			   	mDbHelper.openDataBase();
			 
			   	mDb = mDbHelper.getReadableDatabase();
			   	c = mDb.rawQuery(select, null);
			   	c.moveToFirst();
			   	if(!c.isAfterLast())
			   	{
			   		do { 
		            element = new Word(); 
		            element.setWordId(c.getInt(0)); 
		            element.setEnglish(c.getString(1));
		            element.setPashto(c.getString(2));
		            element.setPron(c.getString(3));

		            words.add(element); 
		         } while (c.moveToNext()); 
		      	}
			   	
		   		}
		   		catch( Exception e)
		   		{
		   			e.printStackTrace();
		   		}finally { 
		   			if (c != null) {
		   				c.close();
		   			}
		   		if (mDb != null && mDb.isOpen()) {
		   			mDb.close();
		   		  	mDbHelper.close();
		   		}
		   		}
		return words;
		
 	}	




	public ArrayList<User> getUsers()
	{
		// open db connection		   
		// run query and get all users		   
		// create User object for each record and store in users		   
		// close db
	   
	
		ArrayList<User> user = new ArrayList<User>();
	   
	   User value;
	   Cursor cur= null;		   
	   String select = "SELECT * FROM User";
	   try {			   	
		   	mDbHelper.openDataBase();
		   	mDbHelper.close();
		   	mDb = mDbHelper.getReadableDatabase();
		   	cur = mDb.rawQuery(select, null);
		   	cur.moveToFirst();
		   	if(!cur.isAfterLast())
		   	{
		   		do { 
	             value = new User(); 
	            value.setUserId(cur.getInt(0)); 
	            value.setName(cur.getString(1));
	            value.setUsername(cur.getString(2));
	            
	            user.add(value); 
	         } while (cur.moveToNext()); 
	      	}
		   	
	   		}
	   		catch( Exception e)
	   		{
	   			e.printStackTrace();
	   		}finally { 
	   			if (cur != null) {
	   				cur.close();
	   			}
	   		if (mDb != null && mDb.isOpen()) {
	   			mDb.close();
	   		}
	   		}
	   return user;
	
	}	


	public boolean SaveUser(String name, String username) 
	{
		try
		{
			
			mDbHelper.openDataBase();
			mDb=mDbHelper.getReadableDatabase();
			ContentValues values = new ContentValues();
			values.put("Name", name);
			values.put("Username", username);
			
			mDb.insert("User", null, values);

			//Log.d("SaveEmployee", "informationsaved");
			return true;
			
		}
		catch(Exception ex)
		{
			//Log.d("SaveEmployee", ex.toString());
			return false;
		}
	}

}