package com.yuyi.binderservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AIdlService extends Service {
    private ArrayList<Person> personArrayList;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        personArrayList=new ArrayList<>();
        return iBinder;
    }

    private IBinder iBinder=new MyAIdl.Stub() {
        @Override
        public void addPerson(Person person) throws RemoteException {
            personArrayList.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return personArrayList;
        }
    };
}
