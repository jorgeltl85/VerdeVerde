package com.sl2.verdeverde;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sl2.verdeverde.entidades.DaoMaster;
import com.sl2.verdeverde.entidades.DaoSession;
import com.sl2.verdeverde.entidades.Usuario;

public class RegistroActivity extends AppCompatActivity {

    Context context=this;
    private EditText et_first_name;
    private EditText et_last_name;
    private EditText et_ID;
    private EditText et_password;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    String receieveOk;

    private DaoSession mDaoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_first_name = (EditText) findViewById(R.id.tFirstName);
        et_last_name = (EditText) findViewById(R.id.tLastName);
        et_ID = (EditText) findViewById(R.id.tEmail);
        et_password = (EditText) findViewById(R.id.tPassword);
    }

    public void OK(View view)
    {
        firstName = et_first_name.getText().toString();
        lastName = et_last_name.getText().toString();
        userName = et_ID.getText().toString();
        password = et_password.getText().toString();
        if((firstName.equals(""))||(lastName.equals(""))||(userName.equals(""))||(password.equals("")))
        {
            //Display Message
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("ALERT!");
            alertDialog.setMessage("All fields must be filled");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        }
        else
        {
           // mDaoSession = new DaoMaster(
            //        new DaoMaster.DevOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();
            mDaoSession = ((Principal) this.getApplication()).getDaoSession();
            //Principal prin = new Principal();
            mDaoSession.getUsuarioDao().insert(new Usuario(null,firstName,lastName, "jorge@set.com",userName,password,"",""));
            //mDaoSession.getUsuarioDao().insert(new Usuario(1L, firstName,lastName, "jorge@set.com",userName,password,"",""));

            // USER CREATION FOR DEMO PURPOSE
            //if(mDaoSession.getUsuarioDao().loadAll().size() == 0){
            //    mDaoSession.getUsuarioDao().insert(new Usuario(1L, firstName,lastName, "jorge@set.com",userName,password,"",""));

            //}


            // Save the Data in Database
            // receieveOk=loginDataBaseAdapter.insertEntry(firstName,lastName,userName, password);

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("SUCCESSFUL!");
            // alertDialog.setMessage("SIGN IN NOW " + receieveOk);
            alertDialog.setMessage("SIGN IN NOW ");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    //Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            alertDialog.show();
            finish();
        }
    }
    @Override
    protected void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
        // loginDataBaseAdapter.close();
    }
}
