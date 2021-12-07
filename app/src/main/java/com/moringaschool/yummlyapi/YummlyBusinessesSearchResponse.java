
package com.moringaschool.yummlyapi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YummlyBusinessesSearchResponse {

    @SerializedName("seo")
    @Expose
    private Seo seo;
    @SerializedName("feed")
    @Expose
    private List<Object> feed = null;
    @SerializedName("parsedIngredients")
    @Expose
    private List<Object> parsedIngredients = null;
    @SerializedName("indexableMatches")
    @Expose
    private Object indexableMatches;
    @SerializedName("relatedPhrases")
    @Expose
    private RelatedPhrases relatedPhrases;
    @SerializedName("adTrackingCampaign")
    @Expose
    private Integer adTrackingCampaign;
    @SerializedName("criteria")
    @Expose
    private Criteria criteria;
    @SerializedName("ingredientMatchCount")
    @Expose
    private IngredientMatchCount ingredientMatchCount;
    @SerializedName("totalMatchCount")
    @Expose
    private Integer totalMatchCount;
    @SerializedName("noindex")
    @Expose
    private Boolean noindex;
    @SerializedName("adTargetingPhrase")
    @Expose
    private Object adTargetingPhrase;
    @SerializedName("unrelatedSearchResults")
    @Expose
    private List<Object> unrelatedSearchResults = null;
    @SerializedName("adTargetingKeywords")
    @Expose
    private List<Object> adTargetingKeywords = null;
    @SerializedName("relatedSearchResults")
    @Expose
    private Object relatedSearchResults;

    /**
     * No args constructor for use in serialization
     * 
     */
    public YummlyBusinessesSearchResponse() {
    }

    /**
     * 
     * @param indexableMatches
     * @param relatedSearchResults
     * @param noindex
     * @param unrelatedSearchResults
     * @param adTargetingKeywords
     * @param relatedPhrases
     * @param criteria
     * @param feed
     * @param parsedIngredients
     * @param adTrackingCampaign
     * @param ingredientMatchCount
     * @param seo
     * @param adTargetingPhrase
     * @param totalMatchCount
     */
    public YummlyBusinessesSearchResponse(Seo seo, List<Object> feed, List<Object> parsedIngredients, Object indexableMatches, RelatedPhrases relatedPhrases, Integer adTrackingCampaign, Criteria criteria, IngredientMatchCount ingredientMatchCount, Integer totalMatchCount, Boolean noindex, Object adTargetingPhrase, List<Object> unrelatedSearchResults, List<Object> adTargetingKeywords, Object relatedSearchResults) {
        super();
        this.seo = seo;
        this.feed = feed;
        this.parsedIngredients = parsedIngredients;
        this.indexableMatches = indexableMatches;
        this.relatedPhrases = relatedPhrases;
        this.adTrackingCampaign = adTrackingCampaign;
        this.criteria = criteria;
        this.ingredientMatchCount = ingredientMatchCount;
        this.totalMatchCount = totalMatchCount;
        this.noindex = noindex;
        this.adTargetingPhrase = adTargetingPhrase;
        this.unrelatedSearchResults = unrelatedSearchResults;
        this.adTargetingKeywords = adTargetingKeywords;
        this.relatedSearchResults = relatedSearchResults;
    }

    public Seo getSeo() {
        return seo;
    }

    public void setSeo(Seo seo) {
        this.seo = seo;
    }

    public List<Object> getFeed() {
        return feed;
    }

    public void setFeed(List<Object> feed) {
        this.feed = feed;
    }

    public List<Object> getParsedIngredients() {
        return parsedIngredients;
    }

    public void setParsedIngredients(List<Object> parsedIngredients) {
        this.parsedIngredients = parsedIngredients;
    }

    public Object getIndexableMatches() {
        return indexableMatches;
    }

    public void setIndexableMatches(Object indexableMatches) {
        this.indexableMatches = indexableMatches;
    }

    public RelatedPhrases getRelatedPhrases() {
        return relatedPhrases;
    }

    public void setRelatedPhrases(RelatedPhrases relatedPhrases) {
        this.relatedPhrases = relatedPhrases;
    }

    public Integer getAdTrackingCampaign() {
        return adTrackingCampaign;
    }

    public void setAdTrackingCampaign(Integer adTrackingCampaign) {
        this.adTrackingCampaign = adTrackingCampaign;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public IngredientMatchCount getIngredientMatchCount() {
        return ingredientMatchCount;
    }

    public void setIngredientMatchCount(IngredientMatchCount ingredientMatchCount) {
        this.ingredientMatchCount = ingredientMatchCount;
    }

    public Integer getTotalMatchCount() {
        return totalMatchCount;
    }

    public void setTotalMatchCount(Integer totalMatchCount) {
        this.totalMatchCount = totalMatchCount;
    }

    public Boolean getNoindex() {
        return noindex;
    }

    public void setNoindex(Boolean noindex) {
        this.noindex = noindex;
    }

    public Object getAdTargetingPhrase() {
        return adTargetingPhrase;
    }

    public void setAdTargetingPhrase(Object adTargetingPhrase) {
        this.adTargetingPhrase = adTargetingPhrase;
    }

    public List<Object> getUnrelatedSearchResults() {
        return unrelatedSearchResults;
    }

    public void setUnrelatedSearchResults(List<Object> unrelatedSearchResults) {
        this.unrelatedSearchResults = unrelatedSearchResults;
    }

    public List<Object> getAdTargetingKeywords() {
        return adTargetingKeywords;
    }

    public void setAdTargetingKeywords(List<Object> adTargetingKeywords) {
        this.adTargetingKeywords = adTargetingKeywords;
    }

    public Object getRelatedSearchResults() {
        return relatedSearchResults;
    }

    public void setRelatedSearchResults(Object relatedSearchResults) {
        this.relatedSearchResults = relatedSearchResults;
    }

}
