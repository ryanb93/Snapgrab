// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.widget.Toast;

// Referenced classes of package com.ryanburke.snapgrab:
//            FinderService

class this._cls0
    implements Runnable
{

    final FinderService this$0;

    public void run()
    {
        Toast toast = Toast.makeText(getApplicationContext(), "", 1);
        if (FinderService.access$1(FinderService.this))
        {
            toast.setText("Video was found.");
        } else
        {
            toast.setText("No video was found.");
        }
        toast.setGravity(17, 0, 0);
        toast.show();
        FinderService.access$3(FinderService.this, true);
    }

    ()
    {
        this$0 = FinderService.this;
        super();
    }
}
