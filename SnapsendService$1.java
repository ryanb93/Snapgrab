// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.os.Handler;
import android.widget.Toast;
import java.io.File;
import java.io.PrintStream;

// Referenced classes of package com.ryanburke.snapgrab:
//            SnapsendService

class this._cls0
    implements Runnable
{

    final SnapsendService this$0;

    public void run()
    {
        File file = new File(SnapsendService.access$0(SnapsendService.this));
_L2:
        if (SnapsendService.access$1(SnapsendService.this))
        {
            return;
        }
        System.out.println("in loop");
        this;
        JVM INSTR monitorenter ;
        System.out.println("Looking for Snapchat Videos");
        Exception exception;
        try
        {
            if (file.exists() && file.listFiles().length != 0)
            {
                System.out.println("Found video");
                SnapsendService.access$2(SnapsendService.this, true);
                System.out.println("Found video = true");
                File file1 = file.listFiles()[0];
                System.out.println("original created");
                System.out.println((new StringBuilder("recplace path = ")).append(SnapsendService.access$3(SnapsendService.this)).toString());
                File file2 = new File(SnapsendService.access$3(SnapsendService.this));
                System.out.println("replace created");
                System.out.println(file1.delete());
                SnapsendService.access$4(file2, file1);
                SnapsendService.access$5(SnapsendService.this).post(new Runnable() {

                    final SnapsendService._cls1 this$1;

                    public void run()
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "", 1);
                        if (SnapsendService.access$1(this$0))
                        {
                            toast.setText("Video has been switched, you can send now.");
                        } else
                        {
                            toast.setText("No video was found.");
                        }
                        toast.setGravity(17, 0, 0);
                        toast.show();
                    }

            
            {
                this$1 = SnapsendService._cls1.this;
                super();
            }
                });
            }
            Thread.sleep(1000L);
        }
        catch (Exception exception1) { }
        this;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }


    _cls1.this._cls1()
    {
        this$0 = SnapsendService.this;
        super();
    }
}
