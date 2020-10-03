package cn.mldn.com.DemoProject;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URI;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;










import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;



public class VertiCode  {
	@Test
	public void login()throws IOException{
	    HttpClientContext context=new HttpClientContext();
		CookieStore  cookie=  new BasicCookieStore();
		context.setCookieStore(cookie);
	HttpPost hPost=new HttpPost("http://localhost/HRProject/AdminLogin/login");
    List<NameValuePair> list=new ArrayList<>();
    list.add(new BasicNameValuePair("admin.aid","mldn"));
    list.add(new BasicNameValuePair("admin.password","java"));
    list.add(new BasicNameValuePair("code","cied"));
    UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,Charset.forName("UTF-8"));
    hPost.setEntity(entity);
    CloseableHttpClient hClient=HttpClients.createDefault();
  
    CloseableHttpResponse res = hClient.execute(hPost,context);
    
    System.out.println(res.getStatusLine().getStatusCode());
   String body= EntityUtils.toString(res.getEntity());
   System.out.println(body);
   System.out.println(cookie.toString());
  
    
}
}
