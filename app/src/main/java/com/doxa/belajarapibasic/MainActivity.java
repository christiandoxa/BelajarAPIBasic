package com.doxa.belajarapibasic;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String urlData = "https://private-109fde-tutorialdummydata.apiary-mock.com/listmakanan";
    private RecyclerView recyclerViewMakanan;
    private MakananAdapter mAdapter;
    private ProgressDialog mProgressDialog;
    private List<MakananModel> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMakanan = (RecyclerView) findViewById(R.id.recyclerview);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading ...");
        mProgressDialog.show();

        mListData = new ArrayList<>();

        getDataVolley();
    }

    private void getDataVolley() {

        final StringRequest request = new StringRequest(Request.Method.GET, urlData,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        mProgressDialog.dismiss();
                        iniData(response);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void iniData(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);

            //ini toast untuk menampilkan pesan sukses dari json
            Toast.makeText(this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

            // ini utk mengambil attribute array yg ada di json (yaitu attribute data)
            JSONArray jsonArray = jsonObject.getJSONArray("data");

            //looping utk array
            for (int i = 0; i < jsonArray.length(); i++) {
                //get json berdasarkan banyaknya data (index i)
                JSONObject objectMakanan = jsonArray.getJSONObject(i);

                //get data berdasarkan attribte yang ada dijsonnya (harus sama)
                String namaMakanan = objectMakanan.getString("nama_makanan");
                String harga = objectMakanan.getString("harga");
                String stok = objectMakanan.getString("stok_barang");
                String sisa = objectMakanan.getString("sisa_barang");
                String owner = objectMakanan.getString("owner");

                //add data ke modelnya
                MakananModel makananModel = new MakananModel();
                makananModel.setNamaMakanan(namaMakanan);
                makananModel.setHarga(harga);
                makananModel.setStok(stok);
                makananModel.setSisa(sisa);
                makananModel.setOwner(owner);

                //add model ke list
                mListData.add(makananModel);

                //passing data list ke adapter
                mAdapter = new MakananAdapter(mListData, MainActivity.this);
                mAdapter.notifyDataSetChanged();
                recyclerViewMakanan.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerViewMakanan.setItemAnimator(new DefaultItemAnimator());
                recyclerViewMakanan.setAdapter(mAdapter);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
