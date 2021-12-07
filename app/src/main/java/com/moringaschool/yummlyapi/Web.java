
package com.moringaschool.yummlyapi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Web {

    @SerializedName("noindex")
    @Expose
    private Boolean noindex;
    @SerializedName("display-title")
    @Expose
    private String displayTitle;
    @SerializedName("canonical-term")
    @Expose
    private String canonicalTerm;
    @SerializedName("meta-tags")
    @Expose
    private MetaTags metaTags;
    @SerializedName("link-tags")
    @Expose
    private List<LinkTag> linkTags = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Web() {
    }

    /**
     * 
     * @param displayTitle
     * @param noindex
     * @param canonicalTerm
     * @param metaTags
     * @param linkTags
     */
    public Web(Boolean noindex, String displayTitle, String canonicalTerm, MetaTags metaTags, List<LinkTag> linkTags) {
        super();
        this.noindex = noindex;
        this.displayTitle = displayTitle;
        this.canonicalTerm = canonicalTerm;
        this.metaTags = metaTags;
        this.linkTags = linkTags;
    }

    public Boolean getNoindex() {
        return noindex;
    }

    public void setNoindex(Boolean noindex) {
        this.noindex = noindex;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getCanonicalTerm() {
        return canonicalTerm;
    }

    public void setCanonicalTerm(String canonicalTerm) {
        this.canonicalTerm = canonicalTerm;
    }

    public MetaTags getMetaTags() {
        return metaTags;
    }

    public void setMetaTags(MetaTags metaTags) {
        this.metaTags = metaTags;
    }

    public List<LinkTag> getLinkTags() {
        return linkTags;
    }

    public void setLinkTags(List<LinkTag> linkTags) {
        this.linkTags = linkTags;
    }

}
