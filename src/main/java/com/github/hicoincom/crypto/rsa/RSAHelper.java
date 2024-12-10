package com.github.hicoincom.crypto.rsa;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//import sun.security.rsa.RSAPrivateCrtKeyImpl;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class RSAHelper {

	/** *//**
	 * Encryption Algorithm RSA
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/** *//**
	 * RSA maximum encrypted plaintext size
	 */
	private static final int MAX_ENCRYPT_BLOCK = 234;

	/** *//**
	 * RSA maximum decrypted ciphertext size
	 */
	private static final int MAX_DECRYPT_BLOCK = 256;


	private static final String CHARSET ="UTF-8";

	/**
	 * Generate public and private keys
	 *
	 * @return RSAKey
	 */
	public static RSAKey genRSAKeys() {
		RSAKey key = null;
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			// Key digits
			keyPairGen.initialize(2048);
			// key pair
			KeyPair keyPair = keyPairGen.generateKeyPair();
			// public key
			PublicKey pubKey = (RSAPublicKey) keyPair.getPublic();
			// private key
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
	 * get the public key
	 *
	 * @param key public key string (base 64 encoded)
	 * @return PublicKey
	 * @throws Exception msg
	 */
	public static PublicKey getPublicKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = Base64.decodeBase64(key);

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	public static  String getPublicKeyStringByPrivateKey(String privKey)throws Exception{
		PrivateKey privateKey = getPrivateKey(privKey);
		RSAPrivateCrtKey rsaPrivateKey = (RSAPrivateCrtKey) privateKey;
//		RSAPrivateCrtKeyImpl rsaPrivateKey = (RSAPrivateCrtKeyImpl)privateKey;
		//create a KeySpec and let the Factory due the Rest. You could also create the KeyImpl by your own.
		PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rsaPrivateKey.getModulus(), rsaPrivateKey.getPublicExponent()));
		return getKeyString(publicKey).replace("\r", "").replace("\n", "");
	}

	/**
	 * get private key
	 *
	 * @param key Private key string (base 64 encoded)
	 * @return  PrivateKey
	 * @throws Exception msg
	 */
	public static PrivateKey getPrivateKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = Base64.decodeBase64(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	/**
	 * Get the key string (base64 encoded)
	 *
	 * @param key to string
	 * @return String
	 * @throws Exception msg
	 */
	public static String getKeyString(Key key) throws Exception {
		byte[] keyBytes = key.getEncoded();
		String s = Base64.encodeBase64String(keyBytes);
		return s;
	}

	/**
	 *  Public key verification signature
	 * @param data Data to be verified
	 * @param sigStr Signature to be verified
	 * @param pubKey  base 64 public key
	 * @return boolean
	 * @throws Exception msg
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
	 *  Private key to generate signature
	 * @param data data to be signed
	 * @param privKey base 64 private key
	 * @return String
	 * @throws Exception msg
	 */
	public static String getSign(byte[] data,  String privKey) throws Exception{
		PrivateKey key = getPrivateKey(privKey);
		Signature sign = Signature.getInstance("SHA256withRSA");
		sign.initSign(key);
		sign.update(data);
		byte[] signByte = sign.sign();
		return Base64.encodeBase64String(signByte);
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
		//remove the last&
		String strBuild = sb.substring(0, sb.length() - 1);
		//System.out.println("params build: " + strBuild);
		return strBuild;
	}

	/**
	 * <p>
	 * public key decryption
	 * </p>
	 *
	 * @param encryptedData encrypted data
	 * @param publicKey public key base 64 encoded
	 * @return byte[]
	 * @throws Exception msg
	 */
	public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)
			throws Exception {
		byte[] keyBytes =  Base64.decodeBase64(publicKey);
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
		// Decrypt data segments
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
	 *  Public key segment decryption
	 * @param encryptedData encrypted base 64 data
	 * @param publicKey rsa public key
	 * @return String
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

	/**
	 * <p>
	 * private key encryption
	 * </p>
	 *
	 * @param data source data
	 * @param privateKey Private key (BASE 64 encoded)
	 * @return byte[]
	 * @throws Exception msg
	 */
	public static byte[] encryptByPrivateKey(byte[] data, String privateKey)
			throws Exception {
		byte[] keyBytes = Base64.decodeBase64(privateKey);
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
		// Encrypt data segments
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
	 *  Private key segment decryption
	 * @param data data to be encrypted
	 * @param privateKey  private key
	 * @return String
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
		params.put("time",  System.currentTimeMillis());
		params.put("a",  "eth");
		params.put("b",  "0.000001");
		params.put("c",  "12");
		params.put("d",  "English");

		byte[] data = httpParamsBuild(params).getBytes("UTF-8");

		//generate signature
		String sign = getSign(data, key.getPrivateKey());
		System.out.println("prive sign: " + sign);

		//verify signature
		System.out.println("pub verify sign: " + verifySign(data, sign, key.getPublicKey()));

		//wrong signature
		System.out.println("pub verify sign: " + verifySign("b=0.000001&a=eth&c=12&d=English&time=1585032445347".getBytes("UTF-8"), sign, key.getPublicKey()));

		//wrong signature
		System.out.println("pub verify sign: " + verifySign("b=0.000001&c=12&d=English".getBytes("UTF-8"), sign, key.getPublicKey()));

	}

}