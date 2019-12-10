package com.example.session1v2.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.session1v2.R;
import com.example.session1v2.model.Asset;

import java.util.List;

public class AssetAdapter extends ArrayAdapter<Asset> {
    Activity context;
    int resource;
    List<Asset> object;
    TextView txtAssetSN,txtAssetName,txtDepartment;

    public AssetAdapter(Activity conText,int reSource,List<Asset> obJect) {
        super(conText,reSource,obJect);
        this.context=conText;
        this.resource=reSource;
        this.object=obJect;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater Inflater=this.context.getLayoutInflater();
        View row=Inflater.inflate(resource,null);

        txtAssetName=row.findViewById(R.id.txtAssetName);
        txtAssetSN=row.findViewById(R.id.txtAssetSN);
        txtDepartment=row.findViewById(R.id.txtDepartment);

        Asset asset=object.get(position);

        txtAssetName.setText(asset.getAssetName());
        txtAssetSN.setText(asset.getAssetSN());
        txtDepartment.setText(asset.getDepartmentName());

        return row;
    }
}
