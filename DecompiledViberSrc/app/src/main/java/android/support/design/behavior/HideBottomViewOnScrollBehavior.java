package android.support.design.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.a.a;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V>
{
  protected static final int ENTER_ANIMATION_DURATION = 225;
  protected static final int EXIT_ANIMATION_DURATION = 175;
  private static final int STATE_SCROLLED_DOWN = 1;
  private static final int STATE_SCROLLED_UP = 2;
  private ViewPropertyAnimator currentAnimator;
  private int currentState = 2;
  private int height = 0;

  public HideBottomViewOnScrollBehavior()
  {
  }

  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void animateChildTo(V paramV, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    this.currentAnimator = paramV.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        HideBottomViewOnScrollBehavior.access$002(HideBottomViewOnScrollBehavior.this, null);
      }
    });
  }

  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    this.height = paramV.getMeasuredHeight();
    return super.onLayoutChild(paramCoordinatorLayout, paramV, paramInt);
  }

  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.currentState != 1) && (paramInt2 > 0))
      slideDown(paramV);
    while ((this.currentState == 2) || (paramInt2 >= 0))
      return;
    slideUp(paramV);
  }

  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt)
  {
    return paramInt == 2;
  }

  protected void slideDown(V paramV)
  {
    if (this.currentAnimator != null)
    {
      this.currentAnimator.cancel();
      paramV.clearAnimation();
    }
    this.currentState = 1;
    animateChildTo(paramV, this.height, 175L, a.c);
  }

  protected void slideUp(V paramV)
  {
    if (this.currentAnimator != null)
    {
      this.currentAnimator.cancel();
      paramV.clearAnimation();
    }
    this.currentState = 2;
    animateChildTo(paramV, 0, 225L, a.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.behavior.HideBottomViewOnScrollBehavior
 * JD-Core Version:    0.6.2
 */