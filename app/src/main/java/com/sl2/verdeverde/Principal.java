package com.sl2.verdeverde;

import android.app.Application;
import android.content.Context;


import com.sl2.verdeverde.entidades.DaoMaster;
import com.sl2.verdeverde.entidades.DaoSession;
import com.sl2.verdeverde.entidades.Usuario;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

//import static org.greenrobot.greendao.test.DbTest.DB_NAME;

public class Principal extends Application {
    private DaoSession mDaoSession;
    private String DB_NAME = "greendao_demo.db";

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, DB_NAME).getWritableDb()).newSession();

        // USER CREATION FOR DEMO PURPOSE
        if(mDaoSession.getUsuarioDao().loadAll().size() == 0){
            mDaoSession.getUsuarioDao().insert(new Usuario(1L, "Jorge Tufiño","Primero", "jorge@set.com","jorgeltl85","jorgeluis","",""));

        }
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public Database getDatabase(Context context) {
        context = this;
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }

        DatabaseOpenHelper mHelper;
        mHelper = new DaoMaster.DevOpenHelper(context.getApplicationContext(), DB_NAME);
        Database db = mHelper.getWritableDb();
        return db;
    }

    public Database getDatabaseSinContexto() {
        DatabaseOpenHelper mHelper;
        mHelper = new DaoMaster.DevOpenHelper(this.getApplicationContext(), DB_NAME);
        Database db = mHelper.getWritableDb();
        return db;
    }

}
