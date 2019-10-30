package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CRefreshPublicAccountTokenReplyMsg
{
  public final String authToken;
  public final String publicAccountID;
  public final int seq;
  public final int status;

  public CRefreshPublicAccountTokenReplyMsg(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.authToken = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 2;
    public static final int NOT_ADMIN = 4;
    public static final int NOT_IN_GROUP = 3;
    public static final int OK = 0;
    public static final int PUBLIC_ACCOUNT_BLOCKED = 6;
    public static final int PUBLIC_ACCOUNT_NOT_FOUND = 5;
    public static final int PUBLIC_ACCOUNT_SUSPENDED = 7;
    public static final int TIMEOUT = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCRefreshPublicAccountTokenReplyMsg(CRefreshPublicAccountTokenReplyMsg paramCRefreshPublicAccountTokenReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRefreshPublicAccountTokenReplyMsg
 * JD-Core Version:    0.6.2
 */