// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.widget.GridView;

// Referenced classes of package com.ryanburke.snapgrab:
//            MainActivity

class this._cls0
    implements Runnable
{

    final MainActivity this$0;

    public void run()
    {
        ((GridView)listView).setAdapter(new ageAdapter(MainActivity.this));
    }

    ageAdapter()
    {
        this$0 = MainActivity.this;
        super();
    }
}
