package lab.phb.prediksib.repo

import lab.phb.prediksib.model.Fakta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FaktaRepo: JpaRepository<Fakta, Int> {
}