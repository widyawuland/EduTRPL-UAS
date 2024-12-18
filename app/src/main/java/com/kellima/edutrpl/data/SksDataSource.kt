package com.kellima.edutrpl.data

import com.kellima.edutrpl.model.Sks

object SksDatasource {
    fun loadSemesterData(): List<List<Sks>> {
        return listOf(
            listOf( // Semester 1
                Sks("RPL1101", "Pengantar Teknologi Komputer dan Informasi", 4, 2, 2, 2, 6),
                Sks("RPL2101", "Basis data", 4, 2, 2, 2, 6),
                Sks("RPL2102", "Aljabar Linear", 3, 3, 0, 3, 0),
                Sks("RPL3101", "Algoritma Dan Pemrograman", 5, 3, 2, 3, 6),
                Sks("RPL3102", "Agama", 2, 2, 0, 2, 0),
                Sks("RPL3103", "Sistem Informasi", 2, 2, 0, 2, 0)
            ),
            listOf( // Semester 2
                Sks("RPL3201", "Struktur Data", 3, 2, 1, 2, 3),
                Sks("RPL3202", "Komunikasi data dan jaringan", 4, 2, 2, 2, 6),
                Sks("RPL2201", "Sistem Operasi", 3, 2, 1, 2, 3),
                Sks("RPL3203", "Sistem basis data", 4, 3, 1, 3, 3),
                Sks("RPL3204", "Pemrograman berorientasi objek", 4, 2, 2, 2, 6),
                Sks("RPL2202", "Matematika Diskrit", 3, 3, 0, 3, 0)
            ),
            listOf( // Semester 3
                Sks("RPL3301", "Pengantar Rekayasa perangkat lunak", 2, 2, 0, 2, 0),
                Sks("RPL2301", "Matematika for Computer Sciences", 3, 3, 0, 3, 0),
                Sks("RPL3302", "Pemrograman Web", 2, 0, 2, 0, 6),
                Sks("RPL3304", "Rekayasa Kebutuhan perangkat lunak", 2, 2, 0, 2, 0),
                Sks("RPL1301", "Bahasa Indonesia", 2, 2, 0, 2, 0),
                Sks("RPL2302", "Technopreneur", 2, 0, 2, 0, 6),
                Sks("RPL2303", "Perancangan antarmuka", 3, 2, 1, 2, 3),
                Sks("RPL2304", "Bahasa Inggris Fundamental", 3, 2, 1, 2, 3),
                Sks("RPL3305", "Komputasi Cloud", 3, 2, 1, 2, 3),
                Sks("RPL1302", "Kewarganegaraan", 2, 2, 0, 2, 0)
            ),
            listOf( // Semester 4
                Sks("RPL3401", "Pemrograman Web Framework", 2, 0, 2, 0, 6),
                Sks("RPL3402", "Analisis dan perancangan Perangkat Lunak", 5, 3, 2, 3, 6),
                Sks("RPL3403", "Proyek 1", 2, 0, 2, 0, 6),
                Sks("RPL3404", "Kecerdasan Buatan", 4, 3, 1, 3, 3),
                Sks("RPL2401", "Kesehatan dan keselamatan kerja", 2, 2, 0, 2, 0),
                Sks("RPL2402", "Statistik dan Probabilitas", 3, 2, 1, 2, 3),
                Sks("RPL1401", "Pancasila", 2, 2, 0, 2, 0)
            ),
            listOf( // Semester 5
                Sks("RPL3501", "Proyek 2", 2, 0, 2, 0, 6),
                Sks("RPL3502", "Pengujian dan Penjaminan Kualitas Perangkat Lunak", 4, 3, 1, 3, 3),
                Sks("RPL3503", "Pemrograman Mobile", 4, 2, 2, 2, 6),
                Sks("RPL2501", "Hukum Dan Etika Dalam TIK", 2, 2, 0, 2, 0),
                Sks("RPL2502", "Bahasa Inggris Professional", 2, 0, 2, 0, 6),
                Sks("RPL3504", "Machine Learning", 3, 2, 1, 2, 3),
                Sks("RPL3505", "Konstruksi dan Evolusi perangkat lunak", 3, 2, 1, 2, 3)
            ),
            listOf( // Semester 6
                Sks("RPL3601", "Keamanan Pengembangan perangkat lunak", 4, 3, 1, 3, 3),
                Sks("RPL3602", "Manajemen Proyek perangkat lunak", 4, 3, 1, 3, 3),
                Sks("RPL3603", "Data warehouse dan Business Intelligence", 4, 2, 2, 2, 6),
                Sks("RPL3604", "Proyek 3", 3, 0, 3, 0, 9),
                Sks("RPL3605", "Topik khusus", 2, 0, 2, 0, 6),
                Sks("RPL2601", "Metodologi penelitian", 3, 3, 0, 3, 0)
            ),
            listOf( // Semester 7
                Sks("RPL3701", "Magang", 12, 0, 12, 0, 36),
                Sks("RPL2701", "Bahasa Inggris Scientific", 2, 0, 2, 0, 6)
            ),
            listOf( // Semester 8
                Sks("RPL3801", "Seminar proposal", 3, 0, 3, 0, 9),
                Sks("RPL3802", "Penulisan Karya Ilmiah", 1, 0, 1, 0, 3),
                Sks("RPL3803", "Tugas akhir", 6, 0, 6, 0, 18)
            )
        )
    }
}

