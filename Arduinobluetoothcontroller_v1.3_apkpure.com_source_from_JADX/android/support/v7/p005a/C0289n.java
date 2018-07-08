package android.support.v7.p005a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class C0289n implements OnItemClickListener {
    final /* synthetic */ C0280e f1423a;
    final /* synthetic */ C0286k f1424b;

    C0289n(C0286k c0286k, C0280e c0280e) {
        this.f1424b = c0286k;
        this.f1423a = c0280e;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1424b.f1410u.onClick(this.f1423a.f1339b, i);
        if (!this.f1424b.f1381E) {
            this.f1423a.f1339b.dismiss();
        }
    }
}
