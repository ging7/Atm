package com.greed.ging.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //ListView lv_atm;
    GridView gv_atm;
    Spinner notify;
    public static final int RC_LOGIN = 1; //新增一個類別層級常數，代表登入功能
    boolean logon = false;
    String[] func = {"餘額查詢", "交易明細", "最新消息", "理財投資", "離開"};
    int[] icons = {R.drawable.func_balance,
            R.drawable.func_history,
            R.drawable.func_news,
            R.drawable.func_finance,
            R.drawable.func_exit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //使用GridView
        gv_atm = findViewById(R.id.gv_atm);
        IconAdapter gAdapter = new IconAdapter();
        gv_atm.setAdapter(gAdapter);
        gv_atm.setOnItemClickListener(this);
        //使用spinner
        notify = this.findViewById(R.id.spin_atm);
        final ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(this, R.array.notify_array, android.R.layout.simple_spinner_item);
        notify.setAdapter(nAdapter);
        notify.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, nAdapter.getItem(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //使用ListView
        /*lv_atm = this.findViewById(R.id.lv_atm);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, func);
        nAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lv_atm.setAdapter(adapter);*/
        //測試TestActivity
        //startActivity(new Intent(this, TestActivity.class));
        if (!logon){
            //如果未登入，則開啟LoginActivity
            Intent intent = new Intent(this, LoginActivity.class);
           // startActivity(intent);
            startActivityForResult(intent, RC_LOGIN);
        }
    }

    class IconAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return func.length;
        }

        @Override
        public Object getItem(int position) {
            return func[position];
        }

        @Override
        public long getItemId(int position) {
            return icons[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null){
                row = getLayoutInflater().inflate(R.layout.item_row, null);
                ImageView image = row.findViewById(R.id.img_item);
                TextView text = row.findViewById(R.id.txt_item);
                image.setImageResource(icons[position]);
                text.setText(func[position]);
            }
            return row;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_setting){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN){
            if (resultCode == RESULT_OK){
                String uid = data.getStringExtra("LOGIN_USERID");
                String pw = data.getStringExtra("LOGIN_PASSWD");
                Log.d("RESULT", uid + "/" + pw);
            }else{
                finish();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch ((int)id){
            case R.drawable.func_balance:
                break;
            case R.drawable.func_history:
                break;
            case R.drawable.func_news:
                break;
            case R.drawable.func_finance:
                startActivity(new Intent(this, FinanceActivity.class));
                break;
            case R.drawable.func_exit:
                finish();
                break;
        }
    }
}
