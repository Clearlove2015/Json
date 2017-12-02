package com.zc.json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zc.json.bean.JsonArrayBean;
import com.zc.json.bean.JsonCommonBean;
import com.zc.json.bean.JsonStrBean;
import com.zc.json.util.ReadAssetsUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.btn3)
    Button btn3;
    @Bind(R.id.btn4)
    Button btn4;
    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.btn5)
    Button btn5;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        gson = new Gson();
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,R.id.btn5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                jsonToJavaObjectByGson();
                break;
            case R.id.btn2:
                jsonToJavaListByGson();
                break;
            case R.id.btn3:
                javaToJsonObjectByGson();
                break;
            case R.id.btn4:
                javaToJsonArrayByGson();
                break;
            case R.id.btn5:
                useGson();
                break;
        }
    }

    /**
     * 将json对象转换为java对象
     */
    private void jsonToJavaObjectByGson() {
        String json = ReadAssetsUtil.getJson(this, "JsonStr.json");
        JsonStrBean jsonStrBean = gson.fromJson(json, JsonStrBean.class);
        tv1.setText(json);
        tv2.setText(jsonStrBean.toString());
    }

    /**
     * 将json数组转换为java集合
     */
    private void jsonToJavaListByGson() {
        String json = ReadAssetsUtil.getJson(this, "JsonArray.json");
        List<JsonArrayBean> beans = gson.fromJson(json, new TypeToken<List<JsonArrayBean>>() {
        }.getType());
        tv1.setText(json);
        tv2.setText(beans.toString());
    }

    /**
     * 将java对象转换为json对象
     */
    private void javaToJsonObjectByGson() {
        JsonStrBean jsonStrBean = new JsonStrBean(2, "大虾", 12.3, "http://192.168.10.165:8080/L05_Server/images/f1.jpg");
        String json = gson.toJson(jsonStrBean);
        tv1.setText(jsonStrBean.toString());
        tv2.setText(json);
    }

    /**
     * 将java集合转换为json数组
     */
    private void javaToJsonArrayByGson() {
        JsonArrayBean jsonArrayBean1 = new JsonArrayBean(1, "http://192.168.10.165:8080/f1.jpg", "大虾1", 12.3);
        JsonArrayBean jsonArrayBean2 = new JsonArrayBean(2, "http://192.168.10.165:8080/f2.jpg", "大虾2", 12.5);
        List<JsonArrayBean> beans = new ArrayList<>();
        beans.add(jsonArrayBean1);
        beans.add(jsonArrayBean2);
        String json = gson.toJson(beans);
        tv1.setText(beans.toString());
        tv2.setText(json);
    }

    private void useGson() {
        String json = ReadAssetsUtil.getJson(this,"JsonCommon.json");
        JsonCommonBean bean = gson.fromJson(json, JsonCommonBean.class);
        tv1.setText(json);
        tv2.setText("retcode = " + bean.getRetcode());
    }

}
