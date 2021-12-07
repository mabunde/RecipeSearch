
package com.moringaschool.yummlyapi;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seo {

    @SerializedName("web")
    @Expose
    private Web web;
    @SerializedName("firebase")
    @Expose
    private Firebase firebase;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Seo() {
    }

    /**
     * 
     * @param web
     * @param firebase
     */
    public Seo(Web web, Firebase firebase) {
        super();
        this.web = web;
        this.firebase = firebase;
    }

    public Web getWeb() {
        return web;
    }

    public void setWeb(Web web) {
        this.web = web;
    }

    public Firebase getFirebase() {
        return firebase;
    }

    public void setFirebase(Firebase firebase) {
        this.firebase = firebase;
    }

}
