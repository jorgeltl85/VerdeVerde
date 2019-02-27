package com.sl2.verdeverde;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sl2.verdeverde.entidades.DaoMaster;
import com.sl2.verdeverde.entidades.DaoSession;
import com.sl2.verdeverde.entidades.Usuario;
import com.sl2.verdeverde.entidades.UsuarioDao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etUserEmail;
    private EditText etPassword;
    public String username;
    private String password;
    String storedPassword;
    Context context=this;

    private DaoSession mDaoSession;
    private Database base;


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

        Usuario usuario =  buscarUnUsuario("jorgeltl85");


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

    public String obtenerUnDato(String userName)
    {
        Usuario us = new Usuario();

        mDaoSession = ((Principal) this.getApplication()).getDaoSession();
        base = ((Principal) this.getApplication()).getDatabaseSinContexto();

        //mDaoSession = new DaoMaster(
        //      new DaoMaster.DevOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();

        // Principal pri = new Principal();

        //DaoSession mDaoSession = pri.getDaoSession();

        List<Usuario> userList = mDaoSession.getUsuarioDao().loadAll();

        String tableName = "USUARIO";
        String sql =  "SELECT * FROM " + tableName + " limit 1";

        Cursor cursorEsteEs=base.rawQuery("SELECT * FROM " + tableName + " limit 1", null);
        if(cursorEsteEs.getCount()<1) // UserName Not Exist
            return "NOT EXIST";
        cursorEsteEs.moveToFirst();
        String password1= cursorEsteEs.getString(cursorEsteEs.getColumnIndex("PASSWORD"));
        String email1 = cursorEsteEs.getString(cursorEsteEs.getColumnIndex("USERNAME"));
        int id1 = cursorEsteEs.getInt(cursorEsteEs.getColumnIndex("ID"));

        //Usuario uuu = mDaoSession.getUsuarioDao().readEntity(base.rawQuery("SELECT * FROM USUARIO WHERE USUARIO"));
        Usuario uuu = mDaoSession.getUsuarioDao().load(1L);
        Usuario uuu1 = mDaoSession.getUsuarioDao().loadByRowId(1L);

        //Cursor cursor=mDaoSession.getUsuarioDao().getDatabase().q.query("LOGIN", null, "USERNAME=?", new String[]{userName}, null, null, null);

        //Usuario uu2 = mDaoSession.getUsuarioDao().readEntity(base.);


        //us = cursorEsteEs.getRow() (getEntiti); //para empatar con el de abajo

        //Cursor cursorJL = mDaoSession.getDatabase().rawQuery(query.getSql(), query.getParameters());
        //mDaoSession.getUsuarioDao().readEntity(


        return email1;
    }





/*
```
SELECT DISTINCT T.* FROM GENERAL_RECEIPT  as T
INNER join CUSTOMER as c
WHERE
c.C_NAME like "% JODAN %"  and  T.CUSTOMER_ID = c._id
or
T.RECEIPT_ID like "%JODAN%";
```

how to build a  QueryBuilder ?


```
QueryBuilder<GeneralReceipt> queryBuilder = daoSession
        .getGeneralReceiptDao()
        .queryBuilder();
queryBuilder.join(Customer.class, CustomerDao.Properties.Id)
        .where(CustomerDao.Properties.CName.like("%JODAN%"));
queryBuilder.whereOr(GeneralReceiptDao.Properties.ReceiptId.like("%JODAN%"))；
```
    queryBuilder.join(Customer.class, CustomerDao.Properties.Id)
            .whereOr(
            queryBuilder.and(CustomerDao.Properties.CName.like("%JODAN%"), GeneralReceiptDao.Properties.CustomerId.eq(customerId)),
            GeneralReceiptDao.Properties.ReceiptId.like("%JODAN%")
            );
*/

    private List<String> getColumns(Database db, String tableName) {
        List<String> columns = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + tableName + " limit 1", null);
            if (cursor != null) {
                columns = new ArrayList<>(Arrays.asList(cursor.getColumnNames()));
            }
        } catch (Exception e) {
            Log.v(tableName, e.getMessage(), e);
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return columns;
    }

    //https://www.programcreek.com/java-api-examples/?api=org.greenrobot.greendao.database.Database
    //rawquerry
    //https://www.programcreek.com/java-api-examples/?class=org.greenrobot.greendao.database.Database&method=rawQuery
    //EjemploDAOGreen
    //https://github.com/octa-george/Android-GreenDao-Sample/blob/master/app/src/main/java/ro/octa/greendaosample/dao/DBPhoneNumberDao.java
    //querrybuildercursor
    //https://groups.google.com/forum/#!topic/greendao/1Bv2-LwoS4U

    //multiples entidades
    //https://randomthoughtsgr.wordpress.com/2015/01/03/greendao-and-single-contentprovider-for-multiple-entities/

    //Investigar
    //Cursor cursor = daoSession.getDatabase().rawQuery(query.getSql(), query.getParameters());

    //mapeo a una entidad join
    //https://github.com/greenrobot/greenDAO/issues/806

    //querybuilder
    //https://www.programcreek.com/java-api-examples/?api=org.greenrobot.greendao.query.QueryBuilder

    //http://greenrobot.org/greendao/documentation/queries/
    //https://www.programcreek.com/java-api-examples/?api=android.database.sqlite.SQLiteQueryBuilder
    //https://www.codota.com/code/java/classes/android.database.sqlite.SQLiteQueryBuilder

    //Relaciones en DAO
    //http://greenrobot.org/greendao/documentation//relations/

    /**
     * Metodo para buscar un usuario con algunos métodos
     * @param valorBusqueda
     */
    private Usuario buscarUnUsuario(String valorBusqueda){

        mDaoSession = ((Principal) this.getApplication()).getDaoSession();
        base = ((Principal) this.getApplication()).getDatabaseSinContexto();

        //Obtener toda la lista de usuarios e imprimirla
        List<Usuario> users = mDaoSession.getUsuarioDao().loadAll();
        for (Usuario p : users) {
            System.out.println(p);
        }

        // Prueba con QueryBuilder
        //https://www.programcreek.com/java-api-examples/?api=de.greenrobot.dao.query.WhereCondition
        //https://developer.android.com/reference/android/database/sqlite/SQLiteQueryBuilder
        //ejemplo numero 2
        WhereCondition wc = UsuarioDao.Properties.Usuario.in(valorBusqueda);
        QueryBuilder<Usuario> queryBuilder = mDaoSession.getUsuarioDao().queryBuilder();
        queryBuilder.where(wc);

        Usuario usuarioEncontrado = queryBuilder.unique();
        System.out.println(usuarioEncontrado.getNombre());
        Log.i("salida",usuarioEncontrado.getNombre());


        return usuarioEncontrado;

    }

    //Importante
    //Query y queryraw
    //http://www.androidcurso.com/index.php/recursos/42-unidad-9-almacenamiento-de-datos/310-los-metodos-query-y-rawquery

    //queryraw
    //selectionArgs = new String[] { searchString + "%" };
    //Cursor c = db.rawQuery("SELECT column FROM table WHERE column=?", selectionArgs);

    //String[] seletionArguments = {"name"};
    //StringBuilder sb = new StringBuilder("SELECT * FROM TABLENAME TN WHERE TN.NAME = ?");
    //String sale = sb.toString();
    //Cursor cursor = base.rawQuery(sale,seletionArguments);
}
