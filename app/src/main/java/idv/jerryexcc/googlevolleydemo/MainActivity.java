package idv.jerryexcc.googlevolleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/*
* Google親生兒子Volley
* 簡化了Java又臭又長的HTTP請求
* 無需背景執行就可取得完整的網頁原始碼
*
* P.S 記得要在Manifest內加<uses-permission>
* */
public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化 Volley佇列
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        //宣告請求 參數: 1.使用GET請求 2.網址(字串即可 無需轉成URL) 3.請求成功後做的事 4.請求失敗時候做的事
        StringRequest request = new StringRequest(Request.Method.GET, "https://www.google.com.tw", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Response Listener 反饋成功後會看到整個網頁的HTML原始碼
                Log.d("TAG", "All HTML: " + response);
                //HTML原始碼可能因過長而在下方顯示不完,詳細可開瀏覽器去看該網頁的完整原始碼找你需要的資料
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Error Listener 反饋回來有錯誤的時候執行這個區塊
            }
        });
        //加入到請求佇列
        requestQueue.add(request);
    }
}
