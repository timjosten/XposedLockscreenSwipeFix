package ru.timjosten.lockscreenswipefix;

import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.*;

public class LockscreenSwipeFix implements IXposedHookInitPackageResources
{
  private static final String TAG = LockscreenSwipeFix.class.getSimpleName() + ": ";

  public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam resparam)
  throws Throwable
  {
    if(!resparam.packageName.equals("com.android.systemui"))
      return;

    try
    {
      resparam.res.setReplacement("com.android.systemui", "bool", "config_lockscreenAntiFalsingClassifierEnabled", false);
    }
    catch(Throwable t)
    {
      XposedBridge.log(TAG + t);
    }
  }
}
