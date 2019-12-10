package com.example.session1v2.model;

import java.io.Serializable;

public class AssetGroup implements Serializable {
    private int ID;
    private String Name;

    public AssetGroup() {
    }

    public AssetGroup(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return  Name ;
    }
}
