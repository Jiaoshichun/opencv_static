package com.viber.voip.messages.conversation.adapter.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm.FormattedMessageConstraintHelper;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.ui.g.f;
import com.viber.voip.widget.AvatarWithInitialsView;
import com.viber.voip.widget.FormattedMessageLayout;

public class h
  implements f
{
  public final AvatarWithInitialsView a;
  public final TextView b;
  public final AnimatedLikesView c;
  public final TextView d;
  public final ImageView e;
  public final View f;
  public final TextView g;
  public final TextView h;
  public final TextView i;
  public final View j;
  public final View k;
  public final View l;
  public final View m;
  public final ImageView n;
  public final TextView o;
  public final FormattedMessageLayout p;
  public final FormattedMessageConstraintHelper q;
  public final ImageView r;
  public final ImageView s;
  public final TextView t;

  public h(View paramView)
  {
    this.a = ((AvatarWithInitialsView)paramView.findViewById(R.id.avatarView));
    this.b = ((TextView)paramView.findViewById(R.id.nameView));
    this.c = ((AnimatedLikesView)paramView.findViewById(R.id.likeView));
    this.d = ((TextView)paramView.findViewById(R.id.timestampView));
    this.e = ((ImageView)paramView.findViewById(R.id.locationView));
    this.f = paramView.findViewById(R.id.balloonView);
    this.g = ((TextView)paramView.findViewById(R.id.dateHeaderView));
    this.h = ((TextView)paramView.findViewById(R.id.newMessageHeaderView));
    this.i = ((TextView)paramView.findViewById(R.id.loadMoreMessagesView));
    this.j = paramView.findViewById(R.id.loadingMessagesLabelView);
    this.k = paramView.findViewById(R.id.loadingMessagesAnimationView);
    this.l = paramView.findViewById(R.id.headersSpace);
    this.m = paramView.findViewById(R.id.selectionView);
    this.n = ((ImageView)paramView.findViewById(R.id.adminIndicatorView));
    this.o = ((TextView)paramView.findViewById(R.id.referralView));
    this.p = ((FormattedMessageLayout)paramView.findViewById(R.id.formattedMessageView));
    this.q = ((FormattedMessageConstraintHelper)paramView.findViewById(R.id.formattedMessageHelperView));
    this.r = ((ImageView)paramView.findViewById(R.id.forwardView));
    this.s = ((ImageView)paramView.findViewById(R.id.offerClickerView));
    this.t = ((TextView)paramView.findViewById(R.id.editedView));
  }

  public View a()
  {
    return this.p;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c.h
 * JD-Core Version:    0.6.2
 */