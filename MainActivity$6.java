// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.content.DialogInterface;
import android.content.SharedPreferences;

// Referenced classes of package com.ryanburke.snapgrab:
//            MainActivity

class val.prefs
    implements android.content..OnClickListener
{

    final MainActivity this$0;
    private final SharedPreferences val$prefs;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$prefs.edit().putBoolean("rated", true).commit();
        MainActivity.access$4(MainActivity.this);
    }

    or()
    {
        this$0 = final_mainactivity;
        val$prefs = SharedPreferences.this;
        super();
    }
}
