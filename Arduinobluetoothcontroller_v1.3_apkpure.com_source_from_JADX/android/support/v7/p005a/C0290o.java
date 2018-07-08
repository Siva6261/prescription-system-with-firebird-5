package android.support.v7.p005a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

class C0290o implements OnItemClickListener {
    final /* synthetic */ ListView f1425a;
    final /* synthetic */ C0280e f1426b;
    final /* synthetic */ C0286k f1427c;

    C0290o(C0286k c0286k, ListView listView, C0280e c0280e) {
        this.f1427c = c0286k;
        this.f1425a = listView;
        this.f1426b = c0280e;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f1427c.f1379C != null) {
            this.f1427c.f1379C[i] = this.f1425a.isItemChecked(i);
        }
        this.f1427c.f1383G.onClick(this.f1426b.f1339b, i, this.f1425a.isItemChecked(i));
    }
}
