package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzi<TResult>
  implements zzq<TResult>
{
  private final Object mLock = new Object();
  private final Executor zzd;

  @GuardedBy("mLock")
  private OnCompleteListener<TResult> zzl;

  public zzi(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.zzd = paramExecutor;
    this.zzl = paramOnCompleteListener;
  }

  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzl = null;
      return;
    }
  }

  public final void onComplete(Task<TResult> paramTask)
  {
    synchronized (this.mLock)
    {
      if (this.zzl == null)
        return;
      this.zzd.execute(new zzj(this, paramTask));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzi
 * JD-Core Version:    0.6.2
 */