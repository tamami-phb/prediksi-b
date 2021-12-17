package lab.phb.prediksib.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "resume")
class Resume(
    @Id @Column(name = "tgl")
    var tgl: Int,
    @Column(name = "sum")
    var nilai: Double
) {
}