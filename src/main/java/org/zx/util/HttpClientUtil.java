package org.zx.util;

import java.util.List;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {

  private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

  public static String doPost(String url, List<NameValuePair> param, String charset) {
    CloseableHttpClient httpClient = null;
    HttpPost httpPost = null;
    String result = null;
    try {
      httpClient = HttpClients.createDefault();
      httpPost = new HttpPost(url);
      httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
      UrlEncodedFormEntity se = new UrlEncodedFormEntity(
          param, Consts.UTF_8);
      httpPost.setEntity(se);
      HttpResponse response = httpClient.execute(httpPost);
      if (response != null) {
        logger.info(response.toString());
        HttpEntity resEntity = response.getEntity();
        if (resEntity != null) {
          result = EntityUtils.toString(resEntity, charset);
          logger.info(result);
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      logger.error(ex.getMessage());
    }
    return result;
  }

  public static byte[] doPost(String url, String jsonStr) {
    byte[] result = null;
    HttpClient client = HttpClients.createDefault();
    //声明请求方式
    HttpPost post = new HttpPost(url);
    try {
      // 设置通用属性
      StringEntity s = new StringEntity(jsonStr, "UTF-8");
      s.setContentEncoding("UTF-8");
      s.setContentType("application/json");
      // 设置发送的数据(数据尽量为json格式)
      post.setEntity(s);
      post.addHeader("content-type", "application/json;charset=UTF-8");
      //  获取数据
      HttpResponse res = client.execute(post);
      //  判断网络请求的是否成功，成功的状态码为200
      if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        //  HttpEntity为消息实体，内容是http传送的报文,获取数据
        HttpEntity entity = res.getEntity();
        result = EntityUtils.toByteArray(entity);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      // 释放连接
      post.releaseConnection();
    }
    return result;
  }
}