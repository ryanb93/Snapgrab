// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.widget.Toast;

// Referenced classes of package com.ryanburke.snapgrab:
//            ImagePagerActivity

class val.finalLength
    implements Runnable
{

    final ImagePagerActivity this$0;
    private final int val$finalLength;
    private final String val$finalMessage;

    public void run()
    {
        Toast toast = Toast.makeText(ImagePagerActivity.this, val$finalMessage, val$finalLength);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    ()
    {
        this$0 = final_imagepageractivity;
        val$finalMessage = s;
        val$finalLength = I.this;
        super();
    }
}
