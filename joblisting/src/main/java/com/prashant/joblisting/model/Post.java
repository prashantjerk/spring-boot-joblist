package com.prashant.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobPost")
public class Post {
    private String position;
    private String description;
    private int experience_years;
    private String[] tech_stacks;

    public Post() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExperience_years() {
        return experience_years;
    }

    public void setExperience_years(int experience_years) {
        this.experience_years = experience_years;
    }

    public String[] getTech_stacks() {
        return tech_stacks;
    }

    public void setTech_stacks(String[] tech_stacks) {
        this.tech_stacks = tech_stacks;
    }

}
