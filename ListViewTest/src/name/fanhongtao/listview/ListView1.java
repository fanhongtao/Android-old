/*
 * This file is in PUBLIC DOMAIN. You can use it freely. No guarantee.
 */
package name.fanhongtao.listview;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Demo of using ArrayAdapter.
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public class ListView1 extends BaseActivity {

    private ListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TAG = "ListView1";
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        setContentView(listView);
    }

    private List<String> getData(){
        List<String> data = new ArrayList<String>(26);
        for (int i=0; i<26; i++) {
            data.add("Item " + (char)('A' + i));
        }
        return data;
    }
}
