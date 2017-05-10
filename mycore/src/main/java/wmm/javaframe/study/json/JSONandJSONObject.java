package wmm.javaframe.study.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangmm on 2016/10/31.
 * json��jsonObject���߼�
 * jsonObject extends json
 * json.parse ֻ��תΪObject����ɹ�ǰ̨ʹ��
 * json.parseObject ��תΪ�̶�����
 *
 */
public class JSONandJSONObject {

    public static final void json(){
        String jsonString="{\"aa\":\"asdf\"}";
        JSONObject object =new JSONObject();
        object.put("asdf","asdf");
        JSONObject.parse(jsonString);

        System.out.println(JSONObject.parseObject(jsonString,HashMap.class));
        System.out.println(JSON.parse(jsonString));
        System.out.println(JSONObject.toJSONString(object));

    }

    public static void main(String[] args) {
        json();
    }

}
