package android.support.v4.view;

public abstract interface NestedScrollingChild
{
  public abstract boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean);

  public abstract boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2);

  public abstract boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);

  public abstract boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);

  public abstract boolean hasNestedScrollingParent();

  public abstract boolean isNestedScrollingEnabled();

  public abstract void setNestedScrollingEnabled(boolean paramBoolean);

  public abstract boolean startNestedScroll(int paramInt);

  public abstract void stopNestedScroll();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.NestedScrollingChild
 * JD-Core Version:    0.6.2
 */