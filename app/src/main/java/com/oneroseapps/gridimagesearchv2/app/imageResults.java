package com.oneroseapps.gridimagesearchv2.app;

import org.json.JSONException;
import org.json.JSONObject;

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
