package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzfc extends zzea.zzb
{
  zzfc(zzea.zze paramzze, Activity paramActivity, zzea.zza paramzza)
  {
    super(paramzze.zzadv);
  }

  final void zzgd()
    throws RemoteException
  {
    zzea.zzb(this.zzafa.zzadv).onActivitySaveInstanceState(ObjectWrapper.wrap(this.val$activity), this.zzaea, this.zzaev);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfc
 * JD-Core Version:    0.6.2
 */