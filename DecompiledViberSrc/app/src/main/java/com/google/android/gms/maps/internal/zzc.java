package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzc extends IInterface
{
  public abstract void onCancel()
    throws RemoteException;

  public abstract void onFinish()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzc
 * JD-Core Version:    0.6.2
 */