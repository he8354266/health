import com.aliyuncs.exceptions.ClientException;
import com.itheima.utils.SMSUtils;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1016:20
 */
public class SMSController {
    public static void main(String[] args) {
        try {
            SMSUtils.sendShortMessage("SMS_159620392","13022531273","1234");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
