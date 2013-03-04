package com.example.googleeventsample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import android.util.Log;

public class MovieDownloader {
	URI movieDBurl;
	
	public MovieDownloader(){
		
			try {
				movieDBurl = new URI("http://api.themoviedb.org/3/movie/top_rated?api_key=845b6e3996736ba1a408defa43b279bb");
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

	}
	
	public void downloadMovies() {
		
		
		DefaultHttpClient   httpclient = new DefaultHttpClient(new BasicHttpParams());
		HttpPost httppost = new HttpPost(movieDBurl);
		// Depends on your web service
		httppost.setHeader("Content-type", "application/json");
		try{
		InputStream inputStream = null;
		String result = null;
		HttpResponse response = httpclient.execute(httppost);           
		HttpEntity entity = response.getEntity();

		inputStream = entity.getContent();
		// json is UTF-8 by default i beleive
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
		StringBuilder sb = new StringBuilder();

		String line = null;
		while ((line = reader.readLine()) != null)
		{
		    sb.append(line + "\n");
		}
		result = sb.toString();
		
		Log.d("Json", line);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
}
