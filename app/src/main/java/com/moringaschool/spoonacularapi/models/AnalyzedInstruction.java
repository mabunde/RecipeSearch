
package com.moringaschool.spoonacularapi.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel(Parcel.Serialization.BEAN)
public class AnalyzedInstruction {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AnalyzedInstruction() {
    }

    /**
     * 
     * @param name
     * @param steps
     */
    public AnalyzedInstruction(String name, List<Step> steps) {
        super();
        this.name = name;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

}
