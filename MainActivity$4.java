// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.ryanburke.snapgrab:
//            MainActivity

class this._cls0
    implements android.widget.temClickListener
{

    final MainActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        MainActivity.access$2(MainActivity.this, i);
    }

    Listener()
    {
        this$0 = MainActivity.this;
        super();
    }
}
