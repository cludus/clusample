package com.cludus.clugest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
//@ActiveProfiles("jpa")
class ClugestApplicationTests {

	@Test
	void contextLoads() {
	}

}
