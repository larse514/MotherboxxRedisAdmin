package test.com.motherboxx.hash;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.motherboxx.hash.HashService;

public class HashServiceTest {

	private HashService service;
	private String hash = "5d41402abc4b2a76b9719d911017c592";
	private String preHash = "hello";
	
	@Before
	public void before() throws NoSuchAlgorithmException{
		service = new HashService();
		service.init();
	}
	@Test
	public void test() {
		String val = service.hashValue(preHash);
		Assert.assertEquals(val, hash);
	}

}
