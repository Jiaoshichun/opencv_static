package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class VisibilityAwareImageButton extends ImageButton
{
  private int userSetVisibility = getVisibility();

  public VisibilityAwareImageButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public final int getUserSetVisibility()
  {
    return this.userSetVisibility;
  }

  public final void internalSetVisibility(int paramInt, boolean paramBoolean)
  {
    super.setVisibility(paramInt);
    if (paramBoolean)
      this.userSetVisibility = paramInt;
  }

  public void setVisibility(int paramInt)
  {
    internalSetVisibility(paramInt, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.VisibilityAwareImageButton
 * JD-Core Version:    0.6.2
 */