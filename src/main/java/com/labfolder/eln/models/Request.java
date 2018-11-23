package com.labfolder.eln.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Request {
    @NotNull
    private String[] entries;
    @NotNull
    private String keyword;

    public Request() {
    }

    public Request(String entries, String keyword) {
        this.entries = entries.trim().split("\\s");
        this.keyword = keyword.trim();
    }

    public String[] getEntries() {
        return entries;
    }

    @JsonProperty("entry")
    public void setEntries(String entry) {
        this.entries = entry.trim().split("\\s");
    }

    public String getKeyword() {
        return keyword;
    }

    @JsonProperty("keyword")
    public void setKeyword(String keyword) {
        this.keyword = keyword.trim();
    }

    @Override
    public String toString() {
        return "Entries:" + Arrays.toString(this.entries)+ " Keyword:"+ this.keyword;
    }
}
