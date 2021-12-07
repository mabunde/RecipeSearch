
package com.moringaschool.yummlyapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinkTag {

    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("hreflang")
    @Expose
    private String hreflang;
    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LinkTag() {
    }

    /**
     * 
     * @param hreflang
     * @param rel
     * @param href
     */
    public LinkTag(String rel, String hreflang, String href) {
        super();
        this.rel = rel;
        this.hreflang = hreflang;
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHreflang() {
        return hreflang;
    }

    public void setHreflang(String hreflang) {
        this.hreflang = hreflang;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
