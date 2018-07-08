package android.support.v7.p005a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.p018b.C0298b;
import android.util.TypedValue;
import android.view.KeyEvent;

public class C0294s extends as implements DialogInterface {
    private C0280e f1429a = new C0280e(getContext(), this, getWindow());

    C0294s(Context context, int i, boolean z) {
        super(context, C0294s.m3206a(context, i));
    }

    static int m3206a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0298b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1429a.m3189a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f1429a.m3195a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f1429a.m3199b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1429a.m3194a(charSequence);
    }
}
