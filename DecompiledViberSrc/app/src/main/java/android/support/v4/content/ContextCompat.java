package android.support.v4.content;

import android.accessibilityservice.AccessibilityService;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import java.io.File;
import java.util.HashMap;

public class ContextCompat
{
  private static final String TAG = "ContextCompat";
  private static final Object sLock = new Object();
  private static TypedValue sTempValue;

  private static File buildPath(File paramFile, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    int j = 0;
    Object localObject1 = paramFile;
    String str;
    Object localObject2;
    if (j < i)
    {
      str = paramArrayOfString[j];
      if (localObject1 == null)
        localObject2 = new File(str);
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break;
      if (str != null)
      {
        localObject2 = new File((File)localObject1, str);
        continue;
        return localObject1;
      }
      else
      {
        localObject2 = localObject1;
      }
    }
  }

  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("permission is null");
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }

  public static Context createDeviceProtectedStorageContext(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
      return paramContext.createDeviceProtectedStorageContext();
    return null;
  }

  private static File createFilesDir(File paramFile)
  {
    try
    {
      if ((!paramFile.exists()) && (!paramFile.mkdirs()))
      {
        boolean bool = paramFile.exists();
        if (!bool)
          break label31;
      }
      while (true)
      {
        return paramFile;
        label31: Log.w("ContextCompat", "Unable to create files subdir " + paramFile.getPath());
        paramFile = null;
      }
    }
    finally
    {
    }
  }

  public static File getCodeCacheDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramContext.getCodeCacheDir();
    return createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "code_cache"));
  }

  public static int getColor(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramContext.getColor(paramInt);
    return paramContext.getResources().getColor(paramInt);
  }

  public static ColorStateList getColorStateList(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramContext.getColorStateList(paramInt);
    return paramContext.getResources().getColorStateList(paramInt);
  }

  public static File getDataDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
      return paramContext.getDataDir();
    String str = paramContext.getApplicationInfo().dataDir;
    if (str != null)
      return new File(str);
    return null;
  }

  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramContext.getDrawable(paramInt);
    if (Build.VERSION.SDK_INT >= 16)
      return paramContext.getResources().getDrawable(paramInt);
    synchronized (sLock)
    {
      if (sTempValue == null)
        sTempValue = new TypedValue();
      paramContext.getResources().getValue(paramInt, sTempValue, true);
      int i = sTempValue.resourceId;
      return paramContext.getResources().getDrawable(i);
    }
  }

  public static File[] getExternalCacheDirs(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramContext.getExternalCacheDirs();
    File[] arrayOfFile = new File[1];
    arrayOfFile[0] = paramContext.getExternalCacheDir();
    return arrayOfFile;
  }

  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramContext.getExternalFilesDirs(paramString);
    File[] arrayOfFile = new File[1];
    arrayOfFile[0] = paramContext.getExternalFilesDir(paramString);
    return arrayOfFile;
  }

  public static File getNoBackupFilesDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramContext.getNoBackupFilesDir();
    return createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
  }

  public static File[] getObbDirs(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramContext.getObbDirs();
    File[] arrayOfFile = new File[1];
    arrayOfFile[0] = paramContext.getObbDir();
    return arrayOfFile;
  }

  public static <T> T getSystemService(Context paramContext, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramContext.getSystemService(paramClass);
    String str = getSystemServiceName(paramContext, paramClass);
    if (str != null)
      return paramContext.getSystemService(str);
    return null;
  }

  public static String getSystemServiceName(Context paramContext, Class<?> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramContext.getSystemServiceName(paramClass);
    return (String)LegacyServiceMapHolder.SERVICES.get(paramClass);
  }

  public static boolean isDeviceProtectedStorage(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
      return paramContext.isDeviceProtectedStorage();
    return false;
  }

  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }

  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
      paramContext.startActivities(paramArrayOfIntent, paramBundle);
    while (true)
    {
      return true;
      paramContext.startActivities(paramArrayOfIntent);
    }
  }

  public static void startActivity(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramContext.startActivity(paramIntent, paramBundle);
      return;
    }
    paramContext.startActivity(paramIntent);
  }

  public static void startForegroundService(Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramContext.startForegroundService(paramIntent);
      return;
    }
    paramContext.startService(paramIntent);
  }

  private static final class LegacyServiceMapHolder
  {
    static final HashMap<Class<?>, String> SERVICES = new HashMap();

    static
    {
      if (Build.VERSION.SDK_INT > 22)
      {
        SERVICES.put(SubscriptionManager.class, "telephony_subscription_service");
        SERVICES.put(UsageStatsManager.class, "usagestats");
      }
      if (Build.VERSION.SDK_INT > 21)
      {
        SERVICES.put(AppWidgetManager.class, "appwidget");
        SERVICES.put(BatteryManager.class, "batterymanager");
        SERVICES.put(CameraManager.class, "camera");
        SERVICES.put(JobScheduler.class, "jobscheduler");
        SERVICES.put(LauncherApps.class, "launcherapps");
        SERVICES.put(MediaProjectionManager.class, "media_projection");
        SERVICES.put(MediaSessionManager.class, "media_session");
        SERVICES.put(RestrictionsManager.class, "restrictions");
        SERVICES.put(TelecomManager.class, "telecom");
        SERVICES.put(TvInputManager.class, "tv_input");
      }
      if (Build.VERSION.SDK_INT > 19)
      {
        SERVICES.put(AppOpsManager.class, "appops");
        SERVICES.put(CaptioningManager.class, "captioning");
        SERVICES.put(ConsumerIrManager.class, "consumer_ir");
        SERVICES.put(PrintManager.class, "print");
      }
      if (Build.VERSION.SDK_INT > 18)
        SERVICES.put(BluetoothManager.class, "bluetooth");
      if (Build.VERSION.SDK_INT > 17)
      {
        SERVICES.put(DisplayManager.class, "display");
        SERVICES.put(UserManager.class, "user");
      }
      if (Build.VERSION.SDK_INT > 16)
      {
        SERVICES.put(InputManager.class, "input");
        SERVICES.put(MediaRouter.class, "media_router");
        SERVICES.put(NsdManager.class, "servicediscovery");
      }
      SERVICES.put(AccessibilityService.class, "accessibility");
      SERVICES.put(AccountManager.class, "account");
      SERVICES.put(ActivityManager.class, "activity");
      SERVICES.put(AlarmManager.class, "alarm");
      SERVICES.put(AudioManager.class, "audio");
      SERVICES.put(ClipboardManager.class, "clipboard");
      SERVICES.put(ConnectivityManager.class, "connectivity");
      SERVICES.put(DevicePolicyManager.class, "device_policy");
      SERVICES.put(DownloadManager.class, "download");
      SERVICES.put(DropBoxManager.class, "dropbox");
      SERVICES.put(InputMethodManager.class, "input_method");
      SERVICES.put(KeyguardManager.class, "keyguard");
      SERVICES.put(LayoutInflater.class, "layout_inflater");
      SERVICES.put(LocationManager.class, "location");
      SERVICES.put(NfcManager.class, "nfc");
      SERVICES.put(NotificationManager.class, "notification");
      SERVICES.put(PowerManager.class, "power");
      SERVICES.put(SearchManager.class, "search");
      SERVICES.put(SensorManager.class, "sensor");
      SERVICES.put(StorageManager.class, "storage");
      SERVICES.put(TelephonyManager.class, "phone");
      SERVICES.put(TextServicesManager.class, "textservices");
      SERVICES.put(UiModeManager.class, "uimode");
      SERVICES.put(UsbManager.class, "usb");
      SERVICES.put(Vibrator.class, "vibrator");
      SERVICES.put(WallpaperManager.class, "wallpaper");
      SERVICES.put(WifiP2pManager.class, "wifip2p");
      SERVICES.put(WifiManager.class, "wifi");
      SERVICES.put(WindowManager.class, "window");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompat
 * JD-Core Version:    0.6.2
 */