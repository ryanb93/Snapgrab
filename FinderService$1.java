// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.os.Environment;
import android.os.Handler;
import android.widget.Toast;
import java.io.File;
import java.io.PrintStream;

// Referenced classes of package com.ryanburke.snapgrab:
//            FinderService

class this._cls0
    implements Runnable
{

    final FinderService this$0;

    public void run()
    {
        File file;
        String s;
        file = new File(FinderService.access$0(FinderService.this));
        s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Snapgrab").toString();
_L5:
        if (FinderService.access$1(FinderService.this))
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        System.out.println("Looking for Snapchat Videos");
        if (!file.exists() || file.listFiles().length == 0) goto _L2; else goto _L1
_L1:
        File file1;
        File afile[];
        int j;
        file1 = new File(s);
        if (!file1.exists())
        {
            file1.mkdir();
        }
        afile = file.listFiles();
        j = afile.length;
        int i = 0;
_L6:
        if (i < j) goto _L4; else goto _L3
_L3:
        FinderService.access$3(FinderService.this, true);
        System.out.println("Found video");
        FinderService.access$4(FinderService.this).post(new Runnable() {

            final FinderService._cls1 this$1;

            public void run()
            {
                Toast toast = Toast.makeText(getApplicationContext(), "", 1);
                if (FinderService.access$1(this$0))
                {
                    toast.setText("Video saved, go back to Snapgrab to view.");
                } else
                {
                    toast.setText("No video was found.");
                }
                toast.setGravity(17, 0, 0);
                toast.show();
            }

            
            {
                this$1 = FinderService._cls1.this;
                super();
            }
        });
_L2:
        Thread.sleep(1000L);
_L7:
        this;
        JVM INSTR monitorexit ;
          goto _L5
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        File file2 = afile[i];
        String s1 = (new StringBuilder(String.valueOf(file1.getAbsolutePath()))).append("/").append(file2.getName().replace(".nomedia", "")).toString();
        FinderService.access$2(file2.getAbsoluteFile(), new File(s1));
        i++;
          goto _L6
        Exception exception1;
        exception1;
          goto _L7
    }


    _cls1.this._cls1()
    {
        this$0 = FinderService.this;
        super();
    }
}
