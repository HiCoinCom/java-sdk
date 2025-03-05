package com.github.hicoincom;

import com.github.hicoincom.util.Md5Util;
import com.github.hicoincom.util.MpcSignUtil;
import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Q
 * @date 2024/9/10
 * @description
 */
public class Test {

    public static void main(String[] args) {
        // address_to=0x5edc9177997bf6b4db559a5c184051858b3b3704&amount=1.0001&request_id=123456789&sub_wallet_id=789&symbol=BTC

        String pri = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC7JPeVXPTYeK8AjYYyx6LzmLzH/qd/jbk2sBJ6r39cq8fPlVfNkYPP4BpVwD9Jl7S8RfnVc33Qq+rVrn/fSdkkAWxZVL5uQmUKHvOHtik/xva29XvwfZ/MnQo91p+dN+orZgwfXdkruDm4nJjd5LRA8tkv5lVNF5ZoUyBRhw0Qts7OMj7TtYN44XnSiXecrAu2CMQ+imRW1/fhygfRc0DppfDdSL4PD1smPc5CSItPg/L0dij6aCCWUCG2xY6zaa0xUw6ezz+o50Lx+2k0nhTRd8P60A+7hAGNsMnGrVKvpj/RBv3wchTc3R9uEVblHvCLP4ZNjO+YHED1Ai8n9je3AgMBAAECggEAA5ulWFBX+hptiU2xMiZuKlMeBJ8QvKFPWlIPsSTUCEXZjtN6w2BUUbwo1dFkhvcxSVXyCJ725ICEAQWhunzSfmK2o4xCNZ77ErRhDpNA/VVJKWLXNl49p/S5H1MVdbL/xUFs52foSXL+TeRbACAqJ3xnGojOyTM0t6MuotO/OTy8fDxDoV/GPuwekcyH4hP8m1OvQKF3rUMmaZzARfM68zjBf47RiCGcb3hXtI11dFIgQANIXNjDY3TQvlQ0FC8YSKkSt6OOSZjNEJajzQFQVxOPo1a60nZE8O5ct6w4QuBIksYhX3daNM++yr0mK2wrvO1fj0BiFy/l/2iHfe/jCQKBgQD+IRt4MFSlW0IBx4M+wNWj5H/EO4eiihogSg7QmOw/1R2yuSlXE2JLgxOe9cSokxVN4WYa6QPLJlCXhDzPbcYQ/Xb1NUQtsi9itZIRXbUfly15jQ/2FxdEVY86xXwYirhTFaDON+sbKUUjUVp4VtzsupcbgqT1imNkaJnstZMNCQKBgQC8haFjvFGlv/E5c9sHZj9sHHFHRGjpkQGUk4tsKbxpozsAyZeiW8lP2U6ejdMBEjjWR/ARSJQAS8pqQb2lxAieYSwn2ycyjaVnzkAiUhMh7QOJKEgFI79so/XdnGfYKXqmHDTSGDc2c63yfcb+25Yq5janPzeIrZXFsUbzO4EOvwKBgCpJJgH8wMj3A2e6ZAtYGPR5fA0R/sK8ChbfW9G38G+6rYNkrg1QK2X3PJeRu5R1TPE1lUDbDweJq5Vaqqe1U2TWWCn7IAoegSYConiDSDUmeamlIEfJldSIDBoybDDFPGCO08Acq+FMH7X9vnkRsxctASHRvlMhIOK/SQWLPRnJAoGBAIRYa4xQ0CDENtxWcRUouq1y6jNV2zDdE3byfZZZVmPyq6FJ5KGePh1IOOEmP1MpL61+oxH/Gad7jYY60KBmloZZQV5Zg5MBzXSqXmu5oqTWdvz6wlSZW/EwyZHiEyS1Od0TQCGdzmTzoNHzapfQIAPNyeBviNTyx4oZge2PgHKRAoGAd9PmM1iR4LUQYpqiJZK7aVrn0arQtWLESVUqNZWNHp5CjVjcjb41WEcYPUDzriGATuaRwKWye2tzYFzcTP4RUlBObxPmu8ibMYQP2UuXCeZxyYTF//7SRJsmG8qtZNqpSTl/z4DgPaP/xRTe+rlN3u4DKzE6XeQXUtaCHU9dDCg=";


        Map<String, String> signParamsMap = new HashMap<>(6, 1);
        signParamsMap.put("request_id", "123456789");
        signParamsMap.put("sub_wallet_id", "789");
        signParamsMap.put("symbol", "BTC");
        signParamsMap.put("address_to", "0x5edc9177997bf6b4db559a5c184051858b3b3704");
        signParamsMap.put("amount", "1.0001");
        signParamsMap.put("memo","");

        String signData = MpcSignUtil.paramsSort(signParamsMap);
        System.out.println(signData);

        System.out.println(Md5Util.getMd5(signData));
        String sign = MpcSignUtil.sign(signData, pri);
        System.out.println(sign);

    }
}
