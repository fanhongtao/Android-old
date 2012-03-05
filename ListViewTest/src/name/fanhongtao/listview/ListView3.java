/*
 * This file is in PUBLIC DOMAIN. You can use it freely. No guarantee.
 */
package name.fanhongtao.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Demo of using SimpleAdapter.
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public class ListView3 extends BaseActivity {

    private ListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TAG = "ListView3";
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        listView.setAdapter(new SimpleAdapter(this, getData(), R.layout.list_item_3, new String[] { "image", "name" },
                new int[] { R.id.imageView1, R.id.textView1 }));
        setContentView(listView);
    }

    protected static List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "blue");
        map.put("image", R.drawable.color_blue);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("name", "red");
        map.put("image", R.drawable.color_red);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("name", "green");
        map.put("image", R.drawable.color_green);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("name", "yellow");
        map.put("image", R.drawable.color_yellow);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("name", "white");
        map.put("image", R.drawable.color_white);
        list.add(map);
        return list;
    }
}
