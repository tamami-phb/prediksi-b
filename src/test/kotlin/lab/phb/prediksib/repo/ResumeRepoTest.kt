package lab.phb.prediksib.repo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ResumeRepoTest {

    @Autowired
    lateinit var resumeRepo: ResumeRepo

    @Test
    fun findByTglBetweenTest() {
        val result = resumeRepo.findByTglBetween(20050817, 20050822)
        Assertions.assertEquals(6, result.size)
    }

}