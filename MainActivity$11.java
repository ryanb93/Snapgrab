// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.content.DialogInterface;
import java.io.File;

// Referenced classes of package com.ryanburke.snapgrab:
//            MainActivity

class this._cls0
    implements android.content.OnClickListener
{

    final MainActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = MainActivity.access$5(MainActivity.this).listFiles();
        int j = dialoginterface.length;
        i = 0;
        do
        {
            if (i >= j)
            {
                MainActivity.access$3(MainActivity.this);
                return;
            }
            dialoginterface[i].delete();
            i++;
        } while (true);
    }

    Listener()
    {
        this$0 = MainActivity.this;
        super();
    }
}
