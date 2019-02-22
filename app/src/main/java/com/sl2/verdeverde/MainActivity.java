package com.sl2.verdeverde;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sl2.verdeverde.entidades.DaoMaster;
import com.sl2.verdeverde.entidades.DaoSession;
import com.sl2.verdeverde.entidades.Usuario;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etUserEmail;
    private EditText etPassword;
    public String username;
    private String password;
    String storedPassword;
    Context context=this;

    private DaoSession mDaoSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mDaoSession = new DaoMaster(
        //        new DaoMaster.DevOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();

        /*
        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "greendao_demo1.db").getWritableDb()).newSession();

        // USER CREATION FOR DEMO PURPOSE
        if(mDaoSession.getUsuarioDao().loadAll().size() == 0){
            mDaoSession.getUsuarioDao().insert(new Usuario(1L, "Jorge Tufiño","Primero", "jorge@set.com","jorgeltl85","jorgeluis","",""));
        }*/

        etUserEmail = (EditText) findViewById(R.id.Email);
        etPassword = (EditText) findViewById(R.id.Password);
    }

    public void SignIN(View view) {
        try {
          //  loginDataBaseAdapter = loginDataBaseAdapter.open();
            username = etUserEmail.getText().toString();
            password = etPassword.getText().toString();
            if (username.equals("") || password.equals("")) {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("ALERT!");
                alertDialog.setMessage("Fill All Fields");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alertDialog.show();
            }
            // fetch the Password form database for respective user name
            if (!username.equals("")) {
                //storedPassword = loginDataBaseAdapter.getSinlgeEntry(username);



                storedPassword = getSinlgeEntry(username);
                // check if the Stored password matches with Password entered by user
                if (password.equals(storedPassword)) {
                    Intent intent1 = new Intent(MainActivity.this, DisplayInfoActivity.class);
                    startActivity(intent1);
                    // finish();
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                    alertDialog.setTitle("ALERT!");
                    alertDialog.setMessage("Incorrect Username OR Password");
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alertDialog.show();
                }
            }
        }
        catch (Exception ex)
        {
            Log.e("Error", "error login");
        }
    }

    public void SignUP(View view)
    {
        Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
        // Close The Database
        //loginDataBaseAdapter.close();
    }

    public String getSinlgeEntry(String userName)
    {
        Usuario us = new Usuario();

        mDaoSession = ((Principal) this.getApplication()).getDaoSession();
        //mDaoSession = new DaoMaster(
          //      new DaoMaster.DevOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();

       // Principal pri = new Principal();

        //DaoSession mDaoSession = pri.getDaoSession();

        List<Usuario> userList = mDaoSession.getUsuarioDao().loadAll();

        for(Usuario user : userList){

            if(user.getUsuario().equals(userName)){
                us = user;
            }
        }
        return us.getClave();
        /*
        //db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query("LOGIN", null, "USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
            return "NOT EXIST";
        cursor.moveToFirst();
        getPassword= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        getPrimerNombre= cursor.getString(cursor.getColumnIndex("FIRSTNAME"));
        getSegundoNombre= cursor.getString(cursor.getColumnIndex("LASTNAME"));
        getEmail= cursor.getString(cursor.getColumnIndex("USERNAME"));
        getId= cursor.getInt(cursor.getColumnIndex("ID"));
        return getPassword;
        */
    }
}
