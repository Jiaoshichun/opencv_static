package org.sqlite.database.sqlite;

import java.io.Closeable;

public abstract class SQLiteClosable
  implements Closeable
{
  private int mReferenceCount = 1;

  public void acquireReference()
  {
    try
    {
      if (this.mReferenceCount <= 0)
        throw new IllegalStateException("attempt to re-open an already-closed object: " + this);
    }
    finally
    {
    }
    this.mReferenceCount = (1 + this.mReferenceCount);
  }

  public void close()
  {
    releaseReference();
  }

  protected abstract void onAllReferencesReleased();

  @Deprecated
  protected void onAllReferencesReleasedFromContainer()
  {
    onAllReferencesReleased();
  }

  public void releaseReference()
  {
    try
    {
      int i = -1 + this.mReferenceCount;
      this.mReferenceCount = i;
      if (i == 0);
      for (int j = 1; ; j = 0)
      {
        if (j != 0)
          onAllReferencesReleased();
        return;
      }
    }
    finally
    {
    }
  }

  @Deprecated
  public void releaseReferenceFromContainer()
  {
    try
    {
      int i = -1 + this.mReferenceCount;
      this.mReferenceCount = i;
      if (i == 0);
      for (int j = 1; ; j = 0)
      {
        if (j != 0)
          onAllReferencesReleasedFromContainer();
        return;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteClosable
 * JD-Core Version:    0.6.2
 */