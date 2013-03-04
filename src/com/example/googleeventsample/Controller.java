package com.example.googleeventsample;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import android.util.Log;



public class Controller {
  private ArrayList<Movie> mlist = new ArrayList<Movie>() ;
	
  public static JSONObject getJsonObj(String urlQuery) {
	  JSONObject jsonObject = null;
	  try {
	  Representation entity = new ClientResource(urlQuery).get();
	  String s = entity.getText();
	  JsonRepresentation jp = new JsonRepresentation(s);
	  jsonObject = jp.getJsonObject();
	  } catch (Exception ex) {
	  ex.printStackTrace();
	  }
	  return jsonObject;
	  }
  
  public void downloadMovies(){
	  JSONObject moviesObj = getJsonObj("http://api.themoviedb.org/3/movie/top_rated?api_key=845b6e3996736ba1a408defa43b279bb&page=1");
	  try {
		JSONObject results = moviesObj.getJSONObject("results");
		Log.d("result", results.toString());
		
	} catch (JSONException e) {
		e.printStackTrace();
	}
  }
  
	public void addMovie(Movie m){
		mlist.add(m);
	}
	
	public ArrayList<Movie> getMoviesbyYear(String year){
		ArrayList<Movie> mlistByYear = new ArrayList<Movie>(); 
		for(int i=0 ; i < mlist.size() ; i++){
		if(mlist.get(i).getRelease_date().startsWith(year))
			{
			mlistByYear.add(mlist.get(i));
			}
		}
	
	return mlistByYear;
	}
}
