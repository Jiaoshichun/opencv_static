package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.List;

@SafeParcelable.Class(creator="GetConnectedNodesResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzea extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzea> CREATOR = new zzeb();

  @SafeParcelable.Field(id=2)
  public final int statusCode;

  @SafeParcelable.Field(id=3)
  public final List<zzfo> zzdx;

  @SafeParcelable.Constructor
  public zzea(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) List<zzfo> paramList)
  {
    this.statusCode = paramInt;
    this.zzdx = paramList;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzdx, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzea
 * JD-Core Version:    0.6.2
 */