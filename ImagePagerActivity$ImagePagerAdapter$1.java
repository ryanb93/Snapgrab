// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.ryanburke.snapgrab:
//            ImagePagerActivity

class val.pos
    implements android.view.Adapter._cls1
{

    final this._cls1 this$1;
    private final int val$pos;

    public void onClick(View view)
    {
        if (ImagePagerActivity.access$2(cess._mth0(this._cls1.this))[val$pos].contains("mp4"))
        {
            view = new Intent();
            view.setAction("android.intent.action.VIEW");
            view.setDataAndType(Uri.parse(ImagePagerActivity.access$2(cess._mth0(this._cls1.this))[val$pos]), "video/mp4");
            cess._mth0(this._cls1.this).startActivity(view);
        }
    }

    ()
    {
        this$1 = final_;
        val$pos = I.this;
        super();
    }
}
