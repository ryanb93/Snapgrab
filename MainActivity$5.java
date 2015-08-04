// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ryanburke.snapgrab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import java.io.File;
import java.io.PrintStream;

// Referenced classes of package com.ryanburke.snapgrab:
//            MainActivity

class this._cls0
    implements android.widget.temLongClickListener
{

    final MainActivity this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, final int pos, long l)
    {
        adapterview = (new android.app.lder(MainActivity.this)).create();
        if (imageUrls[pos].contains("mp4"))
        {
            adapterview.setMessage(getText(0x7f090023));
        } else
        {
            adapterview.setMessage(getText(0x7f090023));
        }
        adapterview.setTitle(0x7f090022);
        adapterview.setIcon(0x7f020075);
        adapterview.setButton(-2, "No", null);
        adapterview.setButton(-1, "Yes", new android.content.DialogInterface.OnClickListener() {

            final MainActivity._cls5 this$1;
            private final int val$pos;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = fileNames[pos].replace("file://", "");
                System.out.println(dialoginterface);
                if ((new File(dialoginterface)).delete())
                {
                    dialoginterface = Toast.makeText(this$0, "Image deleted.", 0);
                } else
                {
                    dialoginterface = Toast.makeText(this$0, "Image not deleted.", 0);
                }
                dialoginterface.setGravity(17, 0, 0);
                dialoginterface.show();
                MainActivity.access$3(this$0);
            }

            
            {
                this$1 = MainActivity._cls5.this;
                pos = i;
                super();
            }
        });
        adapterview.show();
        return false;
    }


    _cls1.val.pos()
    {
        this$0 = MainActivity.this;
        super();
    }
}
