package com.example.ai.listviewbatchmanage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ListView listView;
    private List<DataBean> mDatas;
    private MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);

        mDatas = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            DataBean dataBean = new DataBean("" + i, "上邪", "山无棱，天地合，乃敢与君绝");
            mDatas.add(dataBean);
        }
        mAdapter = new MyAdapter(this, mDatas);
        listView.setAdapter(mAdapter);
    }

    /**     * 编辑、取消编辑     * @param view     */
    public void btnEditList(View view) {
        mAdapter.flage = !mAdapter.flage;
        if (mAdapter.flage) {
            button.setText("取消");
        } else {
            button.setText("编辑");
        }
        mAdapter.notifyDataSetChanged();
    }

    /**     * 全选     * @param view     */
    public void btnSelectAllList(View view) {
        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i).isCheck = true;
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    /**     * 全不选     * @param view     */
    public void btnNoList(View view) {
        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i).isCheck = false;
            }
            mAdapter.notifyDataSetChanged();
        }
    }
    /**     * 反选     * @param view     */
    public void btnfanxuanList(View view) {
        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                if (mDatas.get(i).isCheck) {
                    mDatas.get(i).isCheck = false;
                } else {
                    mDatas.get(i).isCheck = true;
                }
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    /**     * 获取选中数据     * @param view     */
    public void btnOperateList(View view) {
        List<String> ids = new ArrayList<>();
        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                if (mDatas.get(i).isCheck) {
                    ids.add(mDatas.get(i).id);
                }
            }
            Toast.makeText(MainActivity.this,ids.toString(), Toast.LENGTH_SHORT).show();
            Log.e("TAG", ids.toString());
        }
    }

}
