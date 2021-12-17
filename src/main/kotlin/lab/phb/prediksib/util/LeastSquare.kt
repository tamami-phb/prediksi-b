package lab.phb.prediksib.util

import lab.phb.prediksib.model.Resume

class LeastSquare {
    companion object {
        fun convertTglToInt(tgl: String): Int {
            val tanggal = tgl.substring(0,4) + tgl.substring(5,7) + tgl.substring(8,10)
            return Integer.parseInt(tanggal)
        }

        fun calculate(data: List<Resume>): Double {
            val a = calculateA(data)
            val b = calculateB(data)
            val nextX = getNextX(data.size)
            return a + (b * nextX)
        }

        fun getNextX(i: Int): Int {
            val x = generateX(i)
            if(i % 2 == 0) { // jumlah data genap
                return x[i-1] + 2
            } else {
                return x[i-1] + 1
            }
        }

        fun calculateB(data: List<Resume>): Double {
            val x = generateX(data.size)
            val xy = calculateXY(x, data)
            val x2 = calculateX2(x)
            return xy / x2
        }

        fun calculateX2(i: List<Int>): Double {
            var result = 0.0
            i.forEach {
                result += (it * it)
            }
            return result
        }

        fun calculateXY(x: List<Int>, data: List<Resume>): Double {
            var i=0
            var result = 0.0
            while(i < x.size) {
                result += (x[i] * data[i].nilai)
                i++
            }
            return result
        }

        fun generateX(jmlData: Int): List<Int> {
            if(jmlData % 2 == 0) { // jumlah data genap
                return generateXEven(jmlData)
            } else { // jumlah data ganjil
                return generateXOdd(jmlData)
            }
        }

        fun generateXOdd(jmlData: Int): List<Int> {
            var start = (jmlData / 2).toInt() - jmlData + 1
            var i=0
            var result = mutableListOf<Int>()
            while(i++ < jmlData) {
                result.add(start++)
            }
            return result
        }

        fun generateXEven(jmlData: Int): List<Int> {
            var start = (jmlData - 1) - ((jmlData - 1) * 2)
            var i=0
            var result = mutableListOf<Int>()
            while(i++ < jmlData) {
                result.add(start)
                start += 2
            }
            return result
        }

        fun calculateA(data: List<Resume>): Double {
            var nilai = 0.0
            data.forEach {
                nilai += it.nilai
            }
            return nilai / data.size
        }
    }
}