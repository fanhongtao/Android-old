/*
 * This file is in PUBLIC DOMAIN. You can use it freely. No guarantee.
 */
package name.fanhongtao.listview;

import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Demo of using BaseAdapter.
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public class ListView4 extends BaseActivity {

    private ListView listView;
    
    private List<Map<String, Object>> data;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TAG = "ListView4";
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        data = ListView3.getData();
        ColorListAdapter adapter = new ColorListAdapter();
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = data.get(position);
                String colorName = (String) map.get("name");
                Log.i(TAG, colorName);
                
                AlertDialog.Builder builder = new AlertDialog.Builder(ListView4.this);
                builder.setTitle("Selected Item");
                builder.setMessage("Color: " + colorName);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
        setContentView(listView);
    }

    class ColorListAdapter extends BaseAdapter {
        
        private LayoutInflater mInflater;
        
        public ColorListAdapter() {
            super();
            mInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        
        @Override
        public int getCount() {
            return data.size();
        }
    
        @Override
        public Object getItem(int position) {
            return data.get(position);
        }
    
        @Override
        public long getItemId(int position) {
            return position;
        }
    
        /*
         * Android will cache view
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get Holder
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_item_3, null);
                
                holder = new ViewHolder();
                holder.image = (ImageView) convertView.findViewById(R.id.imageView1);
                holder.name = (TextView) convertView.findViewById(R.id.textView1);
                
                convertView.setTag(holder);
                
                // The setting in list_item_3.xml (layout_height="40dip") does't take effect.
                // So I set view's height in the code.
                convertView.setMinimumHeight(100);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            
            // Set content
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>)getItem(position);
            Bitmap bitmap = BitmapFactory.decodeResource(convertView.getResources(), (Integer)map.get("image"));
            holder.image.setImageBitmap(bitmap);
            holder.name.setText((String)map.get("name"));
            
            return convertView;
        }
    }
    
    public static class ViewHolder {
        public ImageView image;
        public TextView  name;
    }
}
