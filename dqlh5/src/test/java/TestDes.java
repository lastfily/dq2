import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestDes {
    @Test
    public void testDes(){
        Map<String,String> data=new HashMap();
        data.put("aaa","bbb");

//        String timestmap="20181028131941";
//
//        String detailEncode = DES.encryptDES(data, "E12E3941");
//
//        String str= null;
//        try {
//            str = EncryptUtils.getSginSHA1("9","E12E3941FA8D0732B647C1454B956F91",detailEncode,timestmap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        StringBuffer sb=new StringBuffer();
//
//        sb.append("data="+detailEncode+"&");
//        sb.append("appId="+"9"+"&");
//        sb.append("timestamp="+timestmap+"&");
//        sb.append("sign="+str);

        String result= HttpRequestUtils.sendPost(Constants.WEB_OPEN_URL+"/aaa.lm",data);

        System.out.println("从open系统中获取的内容:"+result);

    }
}
