/*
 * This file is in PUBLIC DOMAIN. You can use it freely. No guarantee.
 */
package name.fanhongtao.tabhost;

import android.os.Bundle;
import android.widget.EditText;

/**
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public class View1 extends BaseActivity {
    
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TAG = "View1";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1);
        
        editText = (EditText) findViewById(R.id.editText1);
    }
    
    @Override
    protected void onResume() {
        editText.clearFocus();
        super.onResume();
    }
    
}
