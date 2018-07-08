package android.support.v7.p005a;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.p006b.C0052x;

public class at extends C0052x {
    public Dialog mo157a(Bundle bundle) {
        return new as(m873k(), m896b());
    }

    public void mo158a(Dialog dialog, int i) {
        if (dialog instanceof as) {
            as asVar = (as) dialog;
            switch (i) {
                case 1:
                case 2:
                    break;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
                default:
                    return;
            }
            asVar.m802a(1);
            return;
        }
        super.mo158a(dialog, i);
    }
}
