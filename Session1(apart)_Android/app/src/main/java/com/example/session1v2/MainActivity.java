package com.example.session1v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.session1v2.Adapter.AssetAdapter;
import com.example.session1v2.model.Asset;
import com.example.session1v2.model.AssetGroup;
import com.example.session1v2.model.Department;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Asset> dsAsset;
    List<AssetGroup> dsAssetGroup;
    List<Department> dsDepartment;

    AssetAdapter assetAdapter;
    ArrayAdapter<AssetGroup> assetGroupAdapter;
    ArrayAdapter<Department> departmentAdapter;

    Spinner spnAssetGroup,spnDepartment;
    ListView lvAsset;
    FloatingActionButton btnAdd;
    ImageButton btnSearch;
    CheckBox ckbDepartment,ckbAssetGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnAssetGroup=findViewById(R.id.spnAssetGroup);
        spnDepartment=findViewById(R.id.spnDepartment);
        lvAsset=findViewById(R.id.lstAssets);
        btnAdd=findViewById(R.id.btnAdd);
        btnSearch=findViewById(R.id.btnSearch);
        ckbDepartment=findViewById(R.id.ckbDepartment);
        ckbAssetGroup=findViewById(R.id.ckbAssetGroup);

        dsAsset=new ArrayList<>();
        dsAssetGroup=new ArrayList<>();
        dsDepartment=new ArrayList<>();

        assetAdapter=new AssetAdapter(MainActivity.this,R.layout.list_asset_main,dsAsset);
        assetGroupAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,dsAssetGroup);
        departmentAdapter=new ArrayAdapter<>(MainActivity.this ,R.layout.support_simple_spinner_dropdown_item,dsDepartment);

        spnAssetGroup.setAdapter(assetGroupAdapter);
        lvAsset.setAdapter(assetAdapter);
        spnDepartment.setAdapter(departmentAdapter);

        new LoadAsset().execute("http://10.0.3.2:8080/test1/Session1/getAssets.php");
        new LoadDepartment().execute("http://10.0.3.2:8080/test1/Session1/getDepartments.php");
        new LoadAssetGroup().execute("http://10.0.3.2:8080/test1/Session1/getAssetGroups.php");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Add_Activity.class);
                startActivityForResult(i,2);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ckbDepartment.isChecked()==true && ckbAssetGroup.isChecked()==false){
                    int position=spnDepartment.getSelectedItemPosition();
                    int id=dsDepartment.get(position).getID();
                    new LoadAsset().execute("http://10.0.3.2:8080/test1/Session1/getAssetByDepartment.php?id="+id);

                }
                if (ckbDepartment.isChecked()==false && ckbAssetGroup.isChecked()==true){
                    int position=spnAssetGroup.getSelectedItemPosition();
                    int id=dsAssetGroup.get(position).getID();
                    new LoadAsset().execute("http://10.0.3.2:8080/test1/Session1/getAssetByAssetGroup.php?id="+id);
                }
            }
        });

    }
    class LoadAsset extends AsyncTask<String,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dsAsset.clear();
        }

        @Override
        protected Void doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                InputStreamReader input=new InputStreamReader(url.openStream(),"utf-8");
                BufferedReader buffer=new BufferedReader(input);

                StringBuffer builder=new StringBuffer();
                String line=buffer.readLine();

                while (line!=null){
                    builder.append(line);
                    line=buffer.readLine();
                }

                String s=builder.toString();
                Gson gson=new Gson();
                Type collectionType=new TypeToken<List<Asset>>(){}.getType();

                List<Asset> res=gson.fromJson(s,collectionType);

                for (Asset item:res)
                {
                    dsAsset.add(item);
                }
                assetAdapter.notifyDataSetChanged();
            }
            catch (Exception e)
            {}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            assetAdapter.notifyDataSetChanged();
        }
    }
    class LoadDepartment extends AsyncTask<String,Void,Void>
    {
        @Override
        protected Void doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                InputStreamReader input=new InputStreamReader(url.openStream(),"utf-8");
                BufferedReader buffer=new BufferedReader(input);

                StringBuffer builder=new StringBuffer();
                String line=buffer.readLine();

                while (line!=null){
                    builder.append(line);
                    line=buffer.readLine();
                }

                String s=builder.toString();
                Gson gson=new Gson();
                Type collectionType=new TypeToken<List<Department>>(){}.getType();

                List<Department> res=gson.fromJson(s,collectionType);

                for (Department item:res)
                {
                    dsDepartment.add(item);
                }
                departmentAdapter.notifyDataSetChanged();
            }
            catch (Exception e)
            {}
            return null;
        }
    }
    class LoadAssetGroup extends AsyncTask<String,Void,Void>
    {
        @Override
        protected Void doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                InputStreamReader input=new InputStreamReader(url.openStream(),"utf-8");
                BufferedReader buffer=new BufferedReader(input);

                StringBuffer builder=new StringBuffer();
                String line=buffer.readLine();

                while (line!=null){
                    builder.append(line);
                    line=buffer.readLine();
                }

                String s=builder.toString();
                Gson gson=new Gson();
                Type collectionType=new TypeToken<List<AssetGroup>>(){}.getType();

                List<AssetGroup> res=gson.fromJson(s,collectionType);

                for (AssetGroup item:res)
                {
                    dsAssetGroup.add(item);
                }
                assetGroupAdapter.notifyDataSetChanged();
            }
            catch (Exception e)
            {}
            return null;
        }
    }
}
