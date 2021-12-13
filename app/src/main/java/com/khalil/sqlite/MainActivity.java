package com.khalil.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {



    EditText id,nom,qt;

    TextView tv;
    ProductDAO DAO;
    DataBaseHandler dataBaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       DAO = new ProductDAO(this);

        id = findViewById(R.id.id);
        nom = findViewById(R.id.name);
        qt = findViewById(R.id.qt);
        tv = findViewById(R.id.productList);
    }

    public void ajouter (android.view.View view) {
        int qtt = Integer.parseInt(qt.getText().toString());
        int id1 = Integer.parseInt(id.getText().toString());

        Product p = new Product(id1, nom.getText().toString(), qtt);
        DAO.insertdata(p);
        Toast.makeText(getApplicationContext(), "produit ajouter avec succes ", Toast.LENGTH_SHORT).show();



    }


    public void lister (View view) {
        Cursor c = DAO.showdata();
        if (c.getCount() == 0) {
            tv.setText("Product List :");
            Toast.makeText(getApplicationContext(), "DB Product est vide  !!", Toast.LENGTH_SHORT).show();
        } else {
            while (c.moveToNext()) {
                tv.setText("le produit num :° "+c.getInt(0)+" , de nom : "
                            +c.getString(1)+" et sa quantité : "+c.getInt(2));

            }
        }
    }

    public void supprimer(View view) {
        int id2 = Integer.parseInt(id.getText().toString());

        DAO.deletedata(id2);

    }
}
