// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package com.ryanburke.snapgrab:
//            MainActivity

class this._cls0
    implements ServiceConnection
{

    final MainActivity this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = (ocalBinder)ibinder;
        MainActivity.access$0(MainActivity.this, componentname.getService());
        MainActivity.access$1(MainActivity.this, true);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        MainActivity.access$1(MainActivity.this, false);
    }

    ocalBinder()
    {
        this$0 = MainActivity.this;
        super();
    }
}
