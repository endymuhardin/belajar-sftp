package com.muhardin.endy.belajar.sftp;

import com.muhardin.endy.belajar.sftp.service.FileUploadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BelajarSftpApplicationTests {

	@Autowired private FileUploadService fileUploadService;

	@Test
	void uploadTests() {
		fileUploadService.upload();
	}

}
