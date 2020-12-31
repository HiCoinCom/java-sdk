package com.github.hicoincom.crypto.rsa;

import java.io.Serializable;

public class RSAKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 私有数据成员，主要是公钥和私钥 由程序自己产生，公钥需传递给通信另一方
	 */
	public String publicKey;

	public String privateKey;

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
}
