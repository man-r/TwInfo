package com.man_r.Twinfo;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class TwInfoActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Reusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, InfoActivity.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("info").setIndicator("Info",
                          res.getDrawable(R.drawable.info_tab))
                      .setContent(intent);
        tabHost.addTab(spec);

        
        intent = new Intent().setClass(this, OldTweetsActivity.class);
        spec = tabHost.newTabSpec("oldTweets").setIndicator("Old Tweets",
                          res.getDrawable(R.drawable.newtweet_tab))
                      .setContent(intent);
        tabHost.addTab(spec);

       
        intent = new Intent().setClass(this, NewTweetsActivity.class);
        spec = tabHost.newTabSpec("newTweets").setIndicator("New Tweets",
                          res.getDrawable(R.drawable.oldtweet_tab))
                      .setContent(intent);
        tabHost.addTab(spec);
       
    }
}