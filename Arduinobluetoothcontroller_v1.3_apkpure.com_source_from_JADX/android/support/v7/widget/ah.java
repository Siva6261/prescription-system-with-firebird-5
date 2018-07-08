package android.support.v7.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

class ah implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
    final /* synthetic */ ActivityChooserView f1917a;

    private void m4020a() {
        if (this.f1917a.f1747l != null) {
            this.f1917a.f1747l.onDismiss();
        }
    }

    public void onClick(View view) {
        if (view == this.f1917a.f1742g) {
            this.f1917a.m3604b();
            Intent b = this.f1917a.f1737b.m4018d().m4956b(this.f1917a.f1737b.m4018d().m4954a(this.f1917a.f1737b.m4016b()));
            if (b != null) {
                b.addFlags(524288);
                this.f1917a.getContext().startActivity(b);
            }
        } else if (view == this.f1917a.f1740e) {
            this.f1917a.f1748m = false;
            this.f1917a.m3594a(this.f1917a.f1749n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onDismiss() {
        m4020a();
        if (this.f1917a.f1736a != null) {
            this.f1917a.f1736a.m2501a(false);
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (((ag) adapterView.getAdapter()).getItemViewType(i)) {
            case 0:
                this.f1917a.m3604b();
                if (!this.f1917a.f1748m) {
                    if (!this.f1917a.f1737b.m4019e()) {
                        i++;
                    }
                    Intent b = this.f1917a.f1737b.m4018d().m4956b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        this.f1917a.getContext().startActivity(b);
                        return;
                    }
                    return;
                } else if (i > 0) {
                    this.f1917a.f1737b.m4018d().m4958c(i);
                    return;
                } else {
                    return;
                }
            case 1:
                this.f1917a.m3594a(Integer.MAX_VALUE);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.f1917a.f1742g) {
            if (this.f1917a.f1737b.getCount() > 0) {
                this.f1917a.f1748m = true;
                this.f1917a.m3594a(this.f1917a.f1749n);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }
}
