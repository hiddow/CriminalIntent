package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Administrator on 2015/1/12.
 */
public class CrimeLab {
    //创建一个存放Crime单例的数组对象。
    private ArrayList<Crime> mCrimes;
    //定义一个静态变量
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    public CrimeLab(Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);//每隔一个设置为已经解决
            mCrimes.add(crime);
        }
    }
    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getmCrimes(){
        return mCrimes;
    }
    public Crime getCrime(UUID uuid){
        for (Crime crime :mCrimes){
            if (crime.getId().equals(uuid))
                return crime;
        }
        return null;
    }
}
