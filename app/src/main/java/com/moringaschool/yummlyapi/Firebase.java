
package com.moringaschool.yummlyapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Firebase {

    @SerializedName("noindex")
    @Expose
    private Boolean noindex;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Firebase() {
    }

    /**
     * 
     * @param noindex
     */
    public Firebase(Boolean noindex) {
        super();
        this.noindex = noindex;
    }

    public Boolean getNoindex() {
        return noindex;
    }

    public void setNoindex(Boolean noindex) {
        this.noindex = noindex;
    }

}
