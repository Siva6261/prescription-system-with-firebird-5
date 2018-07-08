package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.p005a.C0294s;
import android.support.v7.p005a.C0295t;
import android.support.v7.p018b.C0305i;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class C0336l implements OnClickListener, OnDismissListener, OnKeyListener, C0273y {
    C0334g f1606a;
    private C0329i f1607b;
    private C0294s f1608c;
    private C0273y f1609d;

    public C0336l(C0329i c0329i) {
        this.f1607b = c0329i;
    }

    public void m3447a() {
        if (this.f1608c != null) {
            this.f1608c.dismiss();
        }
    }

    public void m3448a(IBinder iBinder) {
        C0329i c0329i = this.f1607b;
        C0295t c0295t = new C0295t(c0329i.m3371e());
        this.f1606a = new C0334g(c0295t.m3208a(), C0305i.abc_list_menu_item_layout);
        this.f1606a.m3439a((C0273y) this);
        this.f1607b.m3351a(this.f1606a);
        c0295t.m3212a(this.f1606a.m3436a(), this);
        View o = c0329i.m3381o();
        if (o != null) {
            c0295t.m3211a(o);
        } else {
            c0295t.m3210a(c0329i.m3380n()).m3213a(c0329i.m3379m());
        }
        c0295t.m3209a((OnKeyListener) this);
        this.f1608c = c0295t.m3214b();
        this.f1608c.setOnDismissListener(this);
        LayoutParams attributes = this.f1608c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1608c.show();
    }

    public void mo518a(C0329i c0329i, boolean z) {
        if (z || c0329i == this.f1607b) {
            m3447a();
        }
        if (this.f1609d != null) {
            this.f1609d.mo518a(c0329i, z);
        }
    }

    public boolean mo519a(C0329i c0329i) {
        return this.f1609d != null ? this.f1609d.mo519a(c0329i) : false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1607b.m3357a((C0337m) this.f1606a.m3436a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1606a.mo609a(this.f1607b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f1608c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f1608c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f1607b.m3355a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1607b.performShortcut(i, keyEvent, 0);
    }
}
