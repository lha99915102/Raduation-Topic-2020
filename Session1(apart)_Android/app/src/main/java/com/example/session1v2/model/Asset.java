package com.example.session1v2.model;

import java.io.Serializable;

public class Asset implements Serializable {
    private int ID;
    private String AssetName;
    private String AssetSN;
    private int DepartmentLocationID;
    private int AssetGroupID;
    private int EmployeeID;
    private String Description;
    private String WarrantyDate;
    private String DepartmentName;

    public Asset() {
    }

    public Asset(int ID, String assetName, String assetSN, int departmentLocationID, int assetGroupID, int employeeID, String description, String warrantyDate, String departmentName) {
        this.ID = ID;
        AssetName = assetName;
        AssetSN = assetSN;
        DepartmentLocationID = departmentLocationID;
        AssetGroupID = assetGroupID;
        EmployeeID = employeeID;
        Description = description;
        WarrantyDate = warrantyDate;
        DepartmentName = departmentName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAssetName() {
        return AssetName;
    }

    public void setAssetName(String assetName) {
        AssetName = assetName;
    }

    public String getAssetSN() {
        return AssetSN;
    }

    public void setAssetSN(String assetSN) {
        AssetSN = assetSN;
    }

    public int getDepartmentLocationID() {
        return DepartmentLocationID;
    }

    public void setDepartmentLocationID(int departmentLocationID) {
        DepartmentLocationID = departmentLocationID;
    }

    public int getAssetGroupID() {
        return AssetGroupID;
    }

    public void setAssetGroupID(int assetGroupID) {
        AssetGroupID = assetGroupID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getWarrantyDate() {
        return WarrantyDate;
    }

    public void setWarrantyDate(String warrantyDate) {
        WarrantyDate = warrantyDate;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }
}
