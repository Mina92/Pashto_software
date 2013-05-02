package com.example.myfirstownapplication;


public class User {
	private int User_id;
	private String Name;
	private String Username;
	private int Level_id;
	private int Quiz_id;
	
	public void setUserId(int id)
		{ // setter
	      this.User_id = id;
		}

	public int getId() 
		{ // getter
	      return this.User_id;
		}

	public void setName(String name)
		{ // setter
		  this.Name = name;
		}

	public String getName()
		{ // getter
		   return this.Name;
		}

	public void setUsername(String username)
		{ // setter
		   this.Username = username;
		}

	public String getUsername()
		{ // getter
	       return this.Username;
	    }
		
	public void setLevelId(int level_id) 
		{ // setter
			this.Level_id = level_id;
		}

	public int getLevelId()
		{ // getter
	      return this.Level_id;
	    }
		   
		   
	public void setQuizId(int id) 
		{ // setter
	      this.Quiz_id = id;
		}

	public int getQuizId()
		{ // getter
		 return this.Quiz_id;
		}
	

}