// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.content.Intent;
import android.widget.Button;

// Referenced classes of package com.ryanburke.snapgrab:
//            MainActivity, FinderService

class this._cls0
    implements Runnable
{

    final MainActivity this$0;

    public void run()
    {
        Intent intent = new Intent(MainActivity.this, com/ryanburke/snapgrab/FinderService);
        stopService(intent);
        ((Button)findViewById(0x7f040033)).setText(0x7f090013);
    }

    ()
    {
        this$0 = MainActivity.this;
        super();
    }
}
