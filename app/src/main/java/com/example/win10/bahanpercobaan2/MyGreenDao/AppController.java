package com.example.win10.bahanpercobaan2.MyGreenDao;

import android.app.Application;

import com.example.win10.bahanpercobaan2.TableDb.DaoMaster;
import com.example.win10.bahanpercobaan2.TableDb.DaoSession;

import org.greenrobot.greendao.database.Database;

public class AppController extends Application {

    public static final boolean ENCRYPTED = true;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();


        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "grocery-db");
        //The users-db here is the name of our database.
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}