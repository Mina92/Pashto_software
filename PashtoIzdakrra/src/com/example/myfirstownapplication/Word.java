package com.example.myfirstownapplication;


public class Word {
	private int word_id;
	private String English;
	private String Pashto;
	private int cat_id;
	private int Quiz_id;
	private String Pronunciation;
	
	  public void setWordId(int id) { // setter
	      this.word_id = id;
	   }

	   public int getId() { // getter
	      return this.word_id;
	   }

	   public void setEnglish(String eng) { // setter
		      this.English = eng;
		   }

		   public String getEnglish() { // getter
		      return this.English;
		   }

		   public void setPashto(String pashto) { // setter
			      this.Pashto = pashto;
			   }

		public String getPashto()
		{ // getter
	      return this.Pashto;
	    }
		
		  public void setCatId(int id) { // setter
		      this.cat_id = id;
		   }

		   public int getCatId() { // getter
		      return this.cat_id;
		   }
		   
		   
			  public void setQuizId(int id) { // setter
			      this.Quiz_id = id;
			   }

			   public int getQuizId() { // getter
			      return this.Quiz_id;
			   }
			   
			   
				  public void setPron(String pro) { // setter
				      this.Pronunciation = pro;
				   }

				   public String getPron() { // getter
				      return this.Pronunciation;
				   }
			   
				   @Override
				      public String toString() {
				          return English;
				      }

		
		


}
