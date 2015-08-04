// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package com.ryanburke.snapgrab:
//            ImagePagerActivity

class this._cls0
    implements ServiceConnection
{

    final ImagePagerActivity this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = (Binder)ibinder;
        ImagePagerActivity.access$0(ImagePagerActivity.this, componentname.getService());
        ImagePagerActivity.access$1(ImagePagerActivity.this, true);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        ImagePagerActivity.access$1(ImagePagerActivity.this, false);
    }

    Binder()
    {
        this$0 = ImagePagerActivity.this;
        super();
    }
}
