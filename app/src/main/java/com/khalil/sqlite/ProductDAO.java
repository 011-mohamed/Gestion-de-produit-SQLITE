package com.khalil.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductDAO {

    public static final String CREATE_TABLE = "create table product ( id INTEGER PRIMARY KEY, name TEXT, quantite INTEGER);" ;
    public static final String DROP_TABLE="DROP TABLE IF EXISTS product ";
    public DataBaseHandler dbHandler;

    public ProductDAO(Context context) {
        dbHandler = new DataBaseHandler(context,"product", null,1);
    }
    public void insertdata (Product p)  {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id" , p.getId());
        values.put("name", p.getNom());
        values.put("quantite", p.getQuantite());

        db.insert("product", null, values);
        db.close();

    }

    public void deletedata(Integer first){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete("product","id='"+first+"'",null);
    }

    public Cursor showdata(){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String req="SELECT * FROM product";
        Cursor c=db.rawQuery(req,null);
        return c;
    }





}
