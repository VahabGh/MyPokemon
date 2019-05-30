package com.ghamari.vahab.pokemon.main.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by VahabGh on 5/28/2019.
 */
public class Pokemon {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    @SerializedName("base_experience")
    private String baseExperience;

    @SerializedName("height")
    private String height;

    @SerializedName("weight")
    private String weight;

    @SerializedName("abilities")
    private List<AbilityInfo> abilities;

    @SerializedName("sprites")
    private Spirites sptrites;

    @SerializedName("stats")
    private List<StatInfo> statInfos;

    public List<AbilityInfo> getAbilities() {
        return abilities;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public List<StatInfo> getStatInfos() {
        return statInfos;
    }

    public String getBaseExperience() {
        return baseExperience;
    }

    public Spirites getSptrites() {
        return sptrites;
    }
}
