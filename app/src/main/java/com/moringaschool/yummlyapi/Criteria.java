
package com.moringaschool.yummlyapi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Criteria {

    @SerializedName("allowedAttribute")
    @Expose
    private List<String> allowedAttribute = null;
    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("requirePictures")
    @Expose
    private Boolean requirePictures;
    @SerializedName("ENERC_KCAL.min")
    @Expose
    private Integer eNERCKCALMin;
    @SerializedName("ENERC_KCAL.max")
    @Expose
    private Double eNERCKCALMax;
    @SerializedName("maxResult")
    @Expose
    private Integer maxResult;
    @SerializedName("start")
    @Expose
    private Integer start;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Criteria() {
    }

    /**
     * 
     * @param q
     * @param maxResult
     * @param eNERCKCALMin
     * @param start
     * @param requirePictures
     * @param allowedAttribute
     * @param eNERCKCALMax
     */
    public Criteria(List<String> allowedAttribute, String q, Boolean requirePictures, Integer eNERCKCALMin, Double eNERCKCALMax, Integer maxResult, Integer start) {
        super();
        this.allowedAttribute = allowedAttribute;
        this.q = q;
        this.requirePictures = requirePictures;
        this.eNERCKCALMin = eNERCKCALMin;
        this.eNERCKCALMax = eNERCKCALMax;
        this.maxResult = maxResult;
        this.start = start;
    }

    public List<String> getAllowedAttribute() {
        return allowedAttribute;
    }

    public void setAllowedAttribute(List<String> allowedAttribute) {
        this.allowedAttribute = allowedAttribute;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Boolean getRequirePictures() {
        return requirePictures;
    }

    public void setRequirePictures(Boolean requirePictures) {
        this.requirePictures = requirePictures;
    }

    public Integer getENERCKCALMin() {
        return eNERCKCALMin;
    }

    public void setENERCKCALMin(Integer eNERCKCALMin) {
        this.eNERCKCALMin = eNERCKCALMin;
    }

    public Double getENERCKCALMax() {
        return eNERCKCALMax;
    }

    public void setENERCKCALMax(Double eNERCKCALMax) {
        this.eNERCKCALMax = eNERCKCALMax;
    }

    public Integer getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

}
