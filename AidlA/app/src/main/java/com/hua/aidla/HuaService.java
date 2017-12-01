package com.hua.aidla;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zhangZhenhua on 2017/11/30.
 */

public class HuaService extends Service {

    public HuaService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new HuaBinder();
    }

    class HuaBinder extends IHuaAidlInterface.Stub{

        @Override
        public String getName() throws RemoteException {
            return "Hua test";
        }

        @Override
        public People getPeople() throws RemoteException {
            return new People("zhangSan",1);
        }

        @Override
        public void setName(String name) throws RemoteException {
           //Toast.makeText(getApplicationContext(),"name is " + name, Toast.LENGTH_LONG);//error
           Log.i("HuaService","name is " + name);
        }
    }
}
