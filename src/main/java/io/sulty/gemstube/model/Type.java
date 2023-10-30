package io.sulty.gemstube.model;

public enum Type {
    VIDEO("video"),
    IMAGE("image");


    private final String value;

    Type(String value){
        this.value = value;
    }
    public String toString(){
        return value;
    }
}
