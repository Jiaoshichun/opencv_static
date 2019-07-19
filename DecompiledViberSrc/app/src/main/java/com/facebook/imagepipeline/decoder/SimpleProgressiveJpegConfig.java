package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Collections;
import java.util.List;

public class SimpleProgressiveJpegConfig
  implements ProgressiveJpegConfig
{
  private final DynamicValueConfig mDynamicValueConfig;

  public SimpleProgressiveJpegConfig()
  {
    this(new DefaultDynamicValueConfig(null));
  }

  public SimpleProgressiveJpegConfig(DynamicValueConfig paramDynamicValueConfig)
  {
    this.mDynamicValueConfig = ((DynamicValueConfig)Preconditions.checkNotNull(paramDynamicValueConfig));
  }

  public int getNextScanNumberToDecode(int paramInt)
  {
    List localList = this.mDynamicValueConfig.getScansToDecode();
    if ((localList == null) || (localList.isEmpty()))
      return paramInt + 1;
    for (int i = 0; i < localList.size(); i++)
      if (((Integer)localList.get(i)).intValue() > paramInt)
        return ((Integer)localList.get(i)).intValue();
    return 2147483647;
  }

  public QualityInfo getQualityInfo(int paramInt)
  {
    if (paramInt >= this.mDynamicValueConfig.getGoodEnoughScanNumber());
    for (boolean bool = true; ; bool = false)
      return ImmutableQualityInfo.of(paramInt, bool, false);
  }

  private static class DefaultDynamicValueConfig
    implements SimpleProgressiveJpegConfig.DynamicValueConfig
  {
    public int getGoodEnoughScanNumber()
    {
      return 0;
    }

    public List<Integer> getScansToDecode()
    {
      return Collections.EMPTY_LIST;
    }
  }

  public static abstract interface DynamicValueConfig
  {
    public abstract int getGoodEnoughScanNumber();

    public abstract List<Integer> getScansToDecode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig
 * JD-Core Version:    0.6.2
 */