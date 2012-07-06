package com.man_r.Twinfo;

import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.UserList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends Activity {

	TextView result;
    EditText username;
    Button get;
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.info);
        
        result = (TextView) findViewById(R.id.result);
        username = (EditText) findViewById(R.id.username);
        get = (Button) findViewById(R.id.get);
        
        get.setText("Get info");
        get.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), username.getText().toString(), Toast.LENGTH_LONG).show();
				Twitter twitter = new TwitterFactory().getInstance();
		        
				
		        User user;
		        PagableResponseList<UserList> lists;
		        
		        String results = "";
				try {
					user = twitter.showUser(username.getText().toString());
					
					results = results + "\n" + "Name: " + user.getName();
			        results = results + "\n" + "Description: " + user.getDescription();
			        results = results + "\n" + "FavouritesCount: " + user.getFavouritesCount();
			        results = results + "\n" + "FollowersCount: " + user.getFollowersCount();
			        results = results + "\n" + "FriendsCount: " + user.getFriendsCount();
			        results = results + "\n" + "Lang: " + user.getLang();
		        	results = results + "\n" + "Listed: " + user.getListedCount();
		        	results = results + "\n" + "Location: " + user.getLocation();
		        	results = results + "\n" + "ScreenName: " + user.getScreenName();
		        	results = results + "\n" + "StatusesCount: " + user.getStatusesCount();
		        	results = results + "\n" + "TimeZone: " + user.getTimeZone();
		        	results = results + "\n" + "UtcOffset: " + user.getUtcOffset();
		        	results = results + "\n" + "hashCode: " + user.hashCode();
		        	results = results + "\n" + "CreatedAt: " + user.getCreatedAt();
		        	results = results + "\n" + "ProfileImageURL: " + user.getProfileImageURL();
		        	results = results + "\n" + "URL: " + user.getURL();
					
					
		        	results = results + "\n\nList the User is in:\n";
		        	
		        	lists = twitter.getUserListMemberships(username.getText().toString(), -1);
		        	
		        	for (UserList list : lists)
		        		results = results + "\nname: " + list.getName() + "\ndescription: " + list.getDescription() + "\n";
		        	
		        	
		        	result.setText(results);
		        	
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			}
        	
        });
	}

}
