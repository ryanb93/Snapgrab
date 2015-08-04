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

class val.pos
    implements android.content.nClickListener
{

    final is._cls0 this$1;
    private final int val$pos;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = fileNames[val$pos].replace("file://", "");
        System.out.println(dialoginterface);
        if ((new File(dialoginterface)).delete())
        {
            dialoginterface = Toast.makeText(_fld0, "Image deleted.", 0);
        } else
        {
            dialoginterface = Toast.makeText(_fld0, "Image not deleted.", 0);
        }
        dialoginterface.setGravity(17, 0, 0);
        dialoginterface.show();
        MainActivity.access$3(_fld0);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$pos = I.this;
        super();
    }

    // Unreferenced inner class com/ryanburke/snapgrab/MainActivity$5

/* anonymous class */
    class MainActivity._cls5
        implements android.widget.AdapterView.OnItemLongClickListener
    {

        final MainActivity this$0;

        public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (new android.app.AlertDialog.Builder(MainActivity.this)).create();
            if (imageUrls[i].contains("mp4"))
            {
                adapterview.setMessage(getText(0x7f090023));
            } else
            {
                adapterview.setMessage(getText(0x7f090023));
            }
            adapterview.setTitle(0x7f090022);
            adapterview.setIcon(0x7f020075);
            adapterview.setButton(-2, "No", null);
            adapterview.setButton(-1, "Yes", i. new MainActivity._cls5._cls1());
            adapterview.show();
            return false;
        }


            
            {
                this$0 = MainActivity.this;
                super();
            }
    }

}
