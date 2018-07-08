package android.support.v4.p006b;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class C0052x extends C0051y implements OnCancelListener, OnDismissListener {
    int f516a = 0;
    int f517b = 0;
    boolean f518c = true;
    boolean f519d = true;
    int f520e = -1;
    Dialog f521f;
    boolean f522g;
    boolean f523h;
    boolean f524i;

    public Dialog mo157a(Bundle bundle) {
        return new Dialog(m873k(), m896b());
    }

    public void m891a() {
        m895a(false);
    }

    public void mo148a(Activity activity) {
        super.mo148a(activity);
        if (!this.f524i) {
            this.f523h = false;
        }
    }

    public void mo158a(Dialog dialog, int i) {
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
        dialog.requestWindowFeature(1);
    }

    public void m894a(ak akVar, String str) {
        this.f523h = false;
        this.f524i = true;
        az a = akVar.mo178a();
        a.mo205a((C0051y) this, str);
        a.mo202a();
    }

    void m895a(boolean z) {
        if (!this.f523h) {
            this.f523h = true;
            this.f524i = false;
            if (this.f521f != null) {
                this.f521f.dismiss();
                this.f521f = null;
            }
            this.f522g = true;
            if (this.f520e >= 0) {
                m876m().mo181a(this.f520e, 1);
                this.f520e = -1;
                return;
            }
            az a = m876m().mo178a();
            a.mo204a(this);
            if (z) {
                a.mo206b();
            } else {
                a.mo202a();
            }
        }
    }

    public int m896b() {
        return this.f517b;
    }

    public void mo149b(Bundle bundle) {
        super.mo149b(bundle);
        this.f519d = this.G == 0;
        if (bundle != null) {
            this.f516a = bundle.getInt("android:style", 0);
            this.f517b = bundle.getInt("android:theme", 0);
            this.f518c = bundle.getBoolean("android:cancelable", true);
            this.f519d = bundle.getBoolean("android:showsDialog", this.f519d);
            this.f520e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater mo150c(Bundle bundle) {
        if (!this.f519d) {
            return super.mo150c(bundle);
        }
        this.f521f = mo157a(bundle);
        if (this.f521f == null) {
            return (LayoutInflater) this.C.m1000g().getSystemService("layout_inflater");
        }
        mo158a(this.f521f, this.f516a);
        return (LayoutInflater) this.f521f.getContext().getSystemService("layout_inflater");
    }

    public void mo151c() {
        super.mo151c();
        if (!this.f524i && !this.f523h) {
            this.f523h = true;
        }
    }

    public void mo152d() {
        super.mo152d();
        if (this.f521f != null) {
            this.f522g = false;
            this.f521f.show();
        }
    }

    public void mo153d(Bundle bundle) {
        super.mo153d(bundle);
        if (this.f519d) {
            View q = m880q();
            if (q != null) {
                if (q.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f521f.setContentView(q);
            }
            this.f521f.setOwnerActivity(m873k());
            this.f521f.setCancelable(this.f518c);
            this.f521f.setOnCancelListener(this);
            this.f521f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f521f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void mo154e() {
        super.mo154e();
        if (this.f521f != null) {
            this.f521f.hide();
        }
    }

    public void mo155e(Bundle bundle) {
        super.mo155e(bundle);
        if (this.f521f != null) {
            Bundle onSaveInstanceState = this.f521f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f516a != 0) {
            bundle.putInt("android:style", this.f516a);
        }
        if (this.f517b != 0) {
            bundle.putInt("android:theme", this.f517b);
        }
        if (!this.f518c) {
            bundle.putBoolean("android:cancelable", this.f518c);
        }
        if (!this.f519d) {
            bundle.putBoolean("android:showsDialog", this.f519d);
        }
        if (this.f520e != -1) {
            bundle.putInt("android:backStackId", this.f520e);
        }
    }

    public void mo156f() {
        super.mo156f();
        if (this.f521f != null) {
            this.f522g = true;
            this.f521f.dismiss();
            this.f521f = null;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f522g) {
            m895a(true);
        }
    }
}
