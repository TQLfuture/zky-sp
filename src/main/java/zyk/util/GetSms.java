package zyk.util;

import org.junit.Test;

import java.util.logging.Logger;

import static zyk.constant.Constant.ITEM_ID;
import static zyk.constant.Constant.TOKEN;


public class GetSms {

    public static Logger logger = Logger.getLogger("GetSms");

    public static String URL = "http://api.fxhyd.cn/UserInterface.aspx";
    public static String API_SMS = URL+"?action=getsms&token="+TOKEN+"&itemid="+ITEM_ID+"&mobile=";

    public static String getSms(String phone){

        logger.info("uti = " + API_SMS+phone);
        //获取短信
        String smsResult = HttpClient.doGet(API_SMS+phone);
        logger.info("短信 = " + smsResult);
        if (smsResult != null && smsResult.contains("success")) {
            smsResult = smsResult.replace("success|【知药客】您的验证码为","");
            smsResult = smsResult.replace("，请于5分钟内正确输入，如非本人操作，请忽略此短信。","");
            String yzm = smsResult.replace("\r\n","").trim();
            logger.info("验证码 = " + yzm);
            if (yzm != "") {
                return yzm;
            }
        }
        return null;
    }

    @Test
    public void test() throws InterruptedException {
        int i =0;
        while (true) {
            String zym = getSms("13784206854");

            Thread.sleep(5000);
            i += 1;
            if (i == 20) {
                break;
            }
        }

    }

    @Test
    public void test2(){

    }
}
