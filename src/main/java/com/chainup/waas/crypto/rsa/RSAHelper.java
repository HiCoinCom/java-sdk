package com.chainup.waas.crypto.rsa;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.rsa.RSAPrivateCrtKeyImpl;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class RSAHelper {

	/** *//**
	 * 加密算法RSA
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/** *//**
	 * RSA最大加密明文大小
	 */
	private static final int MAX_ENCRYPT_BLOCK = 234;

	/** *//**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 256;


	private static final String CHARSET ="UTF-8";

	/**
	 * 产生公钥和私钥
	 */
	public static RSAKey genRSAKeys() {
		RSAKey key = null;
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			// 密钥位数
			keyPairGen.initialize(2048);
			// 密钥对
			KeyPair keyPair = keyPairGen.generateKeyPair();
			// 公钥
			PublicKey pubKey = (RSAPublicKey) keyPair.getPublic();
			// 私钥
			PrivateKey privKey = (RSAPrivateKey) keyPair.getPrivate();
			String publicKey = getKeyString(pubKey);
//			System.out.println("publicKey \n"+publicKey);
			publicKey = publicKey.replace("\r", "").replace("\n", "");
			String privateKey = getKeyString(privKey);
//			System.out.println("privateKey \n"+privateKey);
			privateKey = privateKey.replace("\r", "").replace("\n", "");
			key = new RSAKey();
			key.setPrivateKey(privateKey);
			key.setPublicKey(publicKey);
		} catch (Exception e) {
			e.printStackTrace();
			return key;
		}

		return key;
	}

	/**
	 * 得到公钥
	 *
	 * @param key 公钥字符串（经过base64编码）
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = (new BASE64Decoder()).decodeBuffer(key);

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	public static  String getPublicKeyStringByPrivateKey(String privKey)throws Exception{
		PrivateKey privateKey = getPrivateKey(privKey);
		RSAPrivateCrtKeyImpl rsaPrivateKey = (RSAPrivateCrtKeyImpl)privateKey;
		//create a KeySpec and let the Factory due the Rest. You could also create the KeyImpl by your own.
		PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rsaPrivateKey.getModulus(), rsaPrivateKey.getPublicExponent()));
		return getKeyString(publicKey).replace("\r", "").replace("\n", "");
	}

	/**
	 * 得到私钥
	 *
	 * @param key 私钥字符串（经过base64编码）
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = (new BASE64Decoder()).decodeBuffer(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	/**
	 * 得到密钥字符串（经过base64编码）
	 *
	 * @return
	 */
	public static String getKeyString(Key key) throws Exception {
		byte[] keyBytes = key.getEncoded();
		String s = (new BASE64Encoder()).encode(keyBytes);
		return s;
	}

	/**
	 *  公钥验证签名
	 * @param data 待验证的数据
	 * @param sigStr 待验证的签名
	 * @param pubKey  base64公钥
	 * @return
	 * @throws Exception
	 */
	public static boolean verifySign(byte[] data, String sigStr, String pubKey) throws Exception {
		byte[] sign = Base64.decodeBase64(sigStr);
		PublicKey pubK = getPublicKey(pubKey);
		Signature sig = Signature.getInstance("SHA256withRSA");
		sig.initVerify(pubK);
		sig.update(data);
		return sig.verify(sign);
	}

	public static boolean verifySign(String text, String sigStr, String pubKey){
		try{
			return verifySign(text.getBytes("UTF-8"), sigStr, pubKey);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 *  私钥生成签名
	 * @param data 待签名的数据
	 * @param privKey base64私钥
	 * @return
	 * @throws Exception
	 */
	public static String getSign(byte[] data,  String privKey) throws Exception{
		PrivateKey key = getPrivateKey(privKey);
		Signature sign = Signature.getInstance("SHA256withRSA");
		sign.initSign(key);
		sign.update(data);
		byte[] signByte = sign.sign();
		return (new BASE64Encoder()).encode(signByte);
	}

	public static String getSign(String text, String privKey){
		try {
			return getSign(text.getBytes("UTF-8"), privKey);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return "";
	}

	public static String httpParamsBuild(Map parameters){
		StringBuffer sb = new StringBuffer();
		Map<String, Object> sortedParams = new TreeMap<String, Object>(parameters);
		Set es = sortedParams.entrySet();//所有参与传参的参数按照accsii排序（升序）
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			Object v = entry.getValue();
			if(null != v && !"".equals(v)
					&& !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}

		//System.out.println("params build: " + sb.toString());
		//去除最后一个&
		String strBuild = sb.substring(0, sb.length() - 1);
		//System.out.println("params build: " + strBuild);
		return strBuild;
	}

	/** *//**
	 * <p>
	 * 公钥解密
	 * </p>
	 *
	 * @param encryptedData 已加密数据
	 * @param publicKey 公钥(BASE64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)
			throws Exception {
		byte[] keyBytes =  (new BASE64Decoder()).decodeBuffer(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;
	}

	/**
	 *  公钥分段解密
	 * @param encryptedData 加密的base64数据
	 * @param publicKey rsa 公钥
	 * @return
	 */
	public static String decryptByPublicKey(String encryptedData, String publicKey){
		if(StringUtils.isBlank(encryptedData) || StringUtils.isBlank(publicKey)){
			return "";
		}

		try {
			encryptedData = encryptedData.replace("\r", "").replace("\n", "");
			Base64 decoder = new Base64(true);
			byte[] data = decryptByPublicKey(decoder.decode(encryptedData), publicKey);
			if(data == null || data.length < 1){
				return  "";
			}
			return new String(data);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return "";
	}

	/** *//**
	 * <p>
	 * 私钥加密
	 * </p>
	 *
	 * @param data 源数据
	 * @param privateKey 私钥(BASE64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, String privateKey)
			throws Exception {
		byte[] keyBytes =  (new BASE64Decoder()).decodeBuffer(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;
	}

	/**
	 *  私钥分段加密数据
	 * @param data 待加密数据
	 * @param privateKey  私钥
	 * @return
	 */
	public static String encryptByPrivateKey(String data, String privateKey){
		if(StringUtils.isBlank(data) || StringUtils.isBlank(privateKey)){
			return "";
		}

		try {
			byte[] encryptedData = encryptByPrivateKey(data.getBytes("UTF-8"), privateKey);
			if(encryptedData == null || encryptedData.length < 1){
				return  "";
			}

			Base64 encoder = new Base64(true);
			byte[] dataBytes = encoder.encode(encryptedData);
			return new String(dataBytes).replace("\r", "").replace("\n", "");
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) throws Exception {
		RSAKey key = genRSAKeys();

		System.out.println("priv: " + key.getPrivateKey());
		System.out.println("pub: " + key.getPublicKey());

		Map<String, Object> params = new HashMap<>();
		params.put("time",  new Date().getTime());
		params.put("a",  "eth");
		params.put("b",  "0.000001");
		params.put("c",  "12");
		params.put("d",  "中文");

		byte[] data = httpParamsBuild(params).getBytes("UTF-8");

		//生成签名
		String sign = getSign(data, key.getPrivateKey());
		System.out.println("prive sign: " + sign);

		//验证签名
		System.out.println("pub verify sign: " + verifySign(data, sign, key.getPublicKey()));

		//错误签名
		System.out.println("pub verify sign: " + verifySign("b=0.000001&a=eth&c=12&d=中文&time=1585032445347".getBytes("UTF-8"), sign, key.getPublicKey()));

		//错误签名
		System.out.println("pub verify sign: " + verifySign("b=0.000001&c=12&d=中文".getBytes("UTF-8"), sign, key.getPublicKey()));

	}

}