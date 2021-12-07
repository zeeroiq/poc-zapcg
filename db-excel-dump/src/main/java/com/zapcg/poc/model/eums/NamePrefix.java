package com.zapcg.poc.model.eums;

public enum NamePrefix {
    Mr("Mr"),
    Ms("Ms"),
    Mrs("Mrs"),
    Hon("Hon"),
    Dr("Dr"),
    Drs("Drs"),
    Prof("Prof");

    private String prefix;
    NamePrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
