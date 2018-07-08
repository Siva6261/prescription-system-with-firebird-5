package android.support.v7.p005a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

class C0287l extends ArrayAdapter {
    final /* synthetic */ ListView f1416a;
    final /* synthetic */ C0286k f1417b;

    C0287l(C0286k c0286k, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
        this.f1417b = c0286k;
        this.f1416a = listView;
        super(context, i, i2, charSequenceArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.f1417b.f1379C != null && this.f1417b.f1379C[i]) {
            this.f1416a.setItemChecked(i, true);
        }
        return view2;
    }
}
