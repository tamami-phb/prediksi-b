package lab.phb.prediksib.util

import lab.phb.prediksib.repo.ResumeRepo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LeastSquareTest {

    @Autowired
    lateinit var resumeRepo: ResumeRepo

    var log = LoggerFactory.getLogger("LeastSquareTest")

    @Test
    fun calculateTest() {
        var data = resumeRepo.findByTglBetween(20050817, 20050822)
        var result = LeastSquare.calculate(data)
        log.info("Hasilnya: " + result)
        Assertions.assertNotNull(result)
    }

    @Test
    fun getNextXTest() {
        val result = LeastSquare.getNextX(6)
        Assertions.assertEquals(7, result)
    }

    @Test
    fun calculateBTest() {
        var data = resumeRepo.findByTglBetween(20050817, 20050822)
        val result = LeastSquare.calculateB(data)
        log.info("Hasilnya : " + result)
        Assertions.assertNotNull(result)
    }

    @Test
    fun calculateX2Test() {
        val x = LeastSquare.generateX(6)
        val result = LeastSquare.calculateX2(x)
        log.info("Hasilnya : " + result)
        Assertions.assertNotNull(result)
    }

    @Test
    fun calculateATest() {
        val data = resumeRepo.findByTglBetween(20050817, 20050822)
        val result = LeastSquare.calculateA(data)
        log.info("Nilainya : " + result)
        Assertions.assertEquals(2648.915, result)
    }

    @Test
    fun generateXEvenTest() {
        val result = LeastSquare.generateXEven(6)
        log.info("Isinya : " + result)
        Assertions.assertEquals(6, result.size)
    }

    @Test
    fun generateXOddTest() {
        val result = LeastSquare.generateXOdd(7)
        log.info("Isinya : " + result)
        Assertions.assertEquals(7, result.size)
    }

    @Test
    fun calculateXYTest() {
        var data = resumeRepo.findByTglBetween(20050817, 20050822)
        val result = LeastSquare.calculateXY(
            LeastSquare.generateX(data.size), data
        )
        log.info("Nilainya : " + result)
        Assertions.assertNotNull(result)
    }

}