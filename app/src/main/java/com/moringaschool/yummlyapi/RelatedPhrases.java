
package com.moringaschool.yummlyapi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedPhrases {

    @SerializedName("relatedPhrases")
    @Expose
    private List<Object> relatedPhrases = null;
    @SerializedName("unrelatedPhrases")
    @Expose
    private List<Object> unrelatedPhrases = null;
    @SerializedName("keywords")
    @Expose
    private List<String> keywords = null;
    @SerializedName("recipes")
    @Expose
    private List<Object> recipes = null;
    @SerializedName("phrase")
    @Expose
    private String phrase;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RelatedPhrases() {
    }

    /**
     * 
     * @param recipes
     * @param unrelatedPhrases
     * @param keywords
     * @param phrase
     * @param relatedPhrases
     */
    public RelatedPhrases(List<Object> relatedPhrases, List<Object> unrelatedPhrases, List<String> keywords, List<Object> recipes, String phrase) {
        super();
        this.relatedPhrases = relatedPhrases;
        this.unrelatedPhrases = unrelatedPhrases;
        this.keywords = keywords;
        this.recipes = recipes;
        this.phrase = phrase;
    }

    public List<Object> getRelatedPhrases() {
        return relatedPhrases;
    }

    public void setRelatedPhrases(List<Object> relatedPhrases) {
        this.relatedPhrases = relatedPhrases;
    }

    public List<Object> getUnrelatedPhrases() {
        return unrelatedPhrases;
    }

    public void setUnrelatedPhrases(List<Object> unrelatedPhrases) {
        this.unrelatedPhrases = unrelatedPhrases;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<Object> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Object> recipes) {
        this.recipes = recipes;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

}
