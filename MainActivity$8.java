// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.ryanburke.snapgrab:
//            MainActivity

class this._cls0
    implements FilenameFilter
{

    final MainActivity this$0;

    public boolean accept(File file, String s)
    {
        file = new File(file, s);
        return file.isFile() && !file.isHidden() && (file.getName().contains("jpg") || file.getName().contains("mp4"));
    }

    ()
    {
        this$0 = MainActivity.this;
        super();
    }
}
