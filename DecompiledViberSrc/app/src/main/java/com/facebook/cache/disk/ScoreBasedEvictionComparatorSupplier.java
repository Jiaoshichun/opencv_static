package com.facebook.cache.disk;

import com.facebook.common.internal.VisibleForTesting;

public class ScoreBasedEvictionComparatorSupplier
  implements EntryEvictionComparatorSupplier
{
  private final float mAgeWeight;
  private final float mSizeWeight;

  public ScoreBasedEvictionComparatorSupplier(float paramFloat1, float paramFloat2)
  {
    this.mAgeWeight = paramFloat1;
    this.mSizeWeight = paramFloat2;
  }

  @VisibleForTesting
  float calculateScore(DiskStorage.Entry paramEntry, long paramLong)
  {
    long l1 = paramLong - paramEntry.getTimestamp();
    long l2 = paramEntry.getSize();
    return this.mAgeWeight * (float)l1 + this.mSizeWeight * (float)l2;
  }

  public EntryEvictionComparator get()
  {
    return new EntryEvictionComparator()
    {
      long now = System.currentTimeMillis();

      public int compare(DiskStorage.Entry paramAnonymousEntry1, DiskStorage.Entry paramAnonymousEntry2)
      {
        float f1 = ScoreBasedEvictionComparatorSupplier.this.calculateScore(paramAnonymousEntry1, this.now);
        float f2 = ScoreBasedEvictionComparatorSupplier.this.calculateScore(paramAnonymousEntry2, this.now);
        if (f1 < f2)
          return 1;
        if (f2 == f1)
          return 0;
        return -1;
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier
 * JD-Core Version:    0.6.2
 */