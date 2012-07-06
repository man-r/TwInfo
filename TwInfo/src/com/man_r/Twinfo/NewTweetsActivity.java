package com.man_r.Twinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class NewTweetsActivity extends Activity {

	TextView result;
    EditText username;
    Button get;
    ListView lv;
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.info2);
        
        result = (TextView) findViewById(R.id.result);
        lv = (ListView) findViewById(R.id.listview);
        username = (EditText) findViewById(R.id.username);
        get = (Button) findViewById(R.id.get);
	    
        get.setText("Get New Tweets");
        result.setText("");
        get.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Twitter twitter = new TwitterFactory().getInstance();
				
				
	            try {
	            	List<Status> statuses;
	                
	                String results;
	                results = "";
	                statuses = twitter.getUserTimeline(username.getText().toString());
	                
	                String[] from = new String[] {"status", "createdat"};
	                int[] to = new int[] { R.id.tweet, R.id.createdat};
	                
	                List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
	                
	                for (Status status : statuses) {
	                	results = results + "\n\n" + status.getText();
	                	
	                	HashMap<String, String> map = new HashMap<String, String>();
	                	
	                	map.put("status", status.getText());
	                	map.put("createdat", status.getCreatedAt().toLocaleString());
	                	
	                	fillMaps.add(map);
                    }
	                
	                //result.setText(results);
	                SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), fillMaps, R.layout.list_item, from, to);
	                lv.setAdapter(adapter);
	                
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
	}

}
