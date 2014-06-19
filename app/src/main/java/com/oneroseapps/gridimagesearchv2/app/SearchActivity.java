package com.oneroseapps.gridimagesearchv2.app;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
//test 1
//test 2

public class SearchActivity extends ActionBarActivity {

    EditText etQuery;
    Button btnSearch;
    GridView  gvResults;
    //create the array. this is the constructor and you can put any type into the array
    ArrayList<imageResults> imageResults1 = new ArrayList<imageResults>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //setting up views
        etQuery = (EditText) findViewById(R.id.etQuery);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        gvResults = (GridView) findViewById(R.id.gvResults);


    }
    public void onImageSearch(View V){
        //get text from editText and show a toast
        String query = etQuery.getText().toString();
        Toast.makeText(this, "Searching for " + query, Toast.LENGTH_LONG).show();
     // send an async request to get stuff from the API
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://ajax.googleapis.com/ajax/services/search/images?rsz=&&" + "start=" + 0 + "&v=1.0&q=" + Uri.encode(query),
                new JsonHttpResponseHandler(){
                    @Override
                    //what to do with the response you get from the google api
                public void onSuccess(JSONObject response){
                        // initializes the jsonarray
                    JSONArray imageJsonResults = null;
                        try{
                            //this will put the json response  into the array
                            imageJsonResults = response.getJSONObject("responseData").getJSONArray("results");
                            //this will clear the array
                            imageResults1.clear();
                            //this will add the results types of the json object to imageResults1 array
                            imageResults1.addAll(imageResults.fromJSONArray(imageJsonResults));
                        } catch (JSONException e){
                            e.printStackTrace();
                        }

                }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
