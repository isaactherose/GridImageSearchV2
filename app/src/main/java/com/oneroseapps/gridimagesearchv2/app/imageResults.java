package com.oneroseapps.gridimagesearchv2.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class imageResults {

    private String fullUrl;
    private String thumbUrl;

    public String getFullUrl(){
        return fullUrl;
    }
    public String getThumbUrl(){
        return thumbUrl;
    }

    public String toString(){
        return this.thumbUrl;
    }

    //this function creates an arrayList and then fills that arraylist with the images of the JSONArray
    public static ArrayList<imageResults> fromJSONArray(
            JSONArray array){
        //creates the arrayList called results
        ArrayList<imageResults> results = new ArrayList<imageResults>();
        //fills up the results array
        for(int x = 0; x <array.length(); x++){
         try{
             results.add(new imageResults(array.getJSONObject(x)));
         } catch(JSONException e){
             e.printStackTrace();
         }
        }
        //produces the array
        return results;
    }

    //the constructor for the class that gets the object and gets the string
    public imageResults(JSONObject json){
        try{
            this.fullUrl = json.getString("url");
            this.thumbUrl = json.getString("tbUrl");
        }
        catch (JSONException e){
            this.fullUrl = null;
            this.thumbUrl = null;
        }
    }

}
//class comment test
//comment 2