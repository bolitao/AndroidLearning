package xyz.bolitao.myim.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 请求服务端的封装类
 *
 * @author Boli Tao
 * @date 2018/12/25
 */
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
