package com.example.googleeventsample;

import java.util.ArrayList;


public class Controller {
  private ArrayList<Movie> mlist = new ArrayList<Movie>() ;
	
	public void addMovie(Movie m){
		mlist.add(m);
	}
	
	public ArrayList<Movie> getMoviesbyYear(String year){
		ArrayList<Movie> mlistByYear = new ArrayList<Movie>(); 
		for(int i=0 ; i < mlist.size() ; i++){
		if(mlist.get(i).getRelease_date().startsWith(year))
			{
			mlistByYear.add(mlist.get(i));
			}}
	
	return mlistByYear;
	}
}
