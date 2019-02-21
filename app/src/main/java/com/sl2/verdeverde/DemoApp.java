package com.sl2.verdeverde;

import android.app.Application;

import com.sl2.verdeverde.entidades.DaoMaster;
import com.sl2.verdeverde.entidades.DaoSession;
import com.sl2.verdeverde.entidades.Usuario;

public class DemoApp extends Application {

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();

        // USER CREATION FOR DEMO PURPOSE
        if(mDaoSession.getUsuarioDao().loadAll().size() == 0){
            mDaoSession.getUsuarioDao().insert(new Usuario(1L, "Jorge Tufiño","Primero", "jorge@set.com","jorgeltl85","jorgeluis","",""));
        }
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

}
