package lab.phb.prediksib.controller

import lab.phb.prediksib.model.Periode
import lab.phb.prediksib.repo.ResumeRepo
import lab.phb.prediksib.util.LeastSquare
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class AppController {

    var log = LoggerFactory.getLogger("AppController")

    @Autowired
    lateinit var resumeRepo: ResumeRepo

    @RequestMapping("/")
    fun index(model: Model): String {
        model.addAttribute("param", Periode())
        return "home"
    }

    @RequestMapping("/proses", method = [ RequestMethod.POST ])
    fun proses(param: Periode, model: Model): String {
        val data = resumeRepo.findByTglBetween(LeastSquare.convertTglToInt(param.tglAwal),
            LeastSquare.convertTglToInt(param.tglAkhir))
        val result = LeastSquare.calculate(data)
        model.addAttribute("hasil", result)
        return "hasil"
    }

}