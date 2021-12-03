package lab.phb.prediksib.repo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FaktaRepoTest {

    @Autowired
    lateinit var repo: FaktaRepo

    var logger = LoggerFactory.getLogger("FaktaRepoTest")

    @Test
    fun getAllDataTest() {
        var result = repo.findAll()
        logger.info("Jumlah data : " + result.size)
        Assertions.assertNotNull(result)
    }

}