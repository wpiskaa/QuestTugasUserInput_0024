# QuestTugasUserInput_0024 - Tugas Layout Jetpack Compose

Proyek aplikasi Android berbasis **Jetpack Compose** untuk penugasan mata kuliah **Pengembangan Aplikasi Mobile (PAM)**. Aplikasi ini mengimplementasikan tata letak formulir biodata modern dengan struktur komponen **Box mengapung (*floating card*) di atas Scaffold**, dengan kepatuhan penuh terhadap aturan **Zero Hardcode (seluruh warna, dimensi, gambar, dan teks dikelola melalui sistem resource Android)**.

---

## 👤 Identitas Mahasiswa
- **Nama:** wpiskaa
- **NIM:** 20220140024 (0024)
- **Mata Kuliah:** Pengembangan Aplikasi Mobile (PAM)
- **Topik:** Tugas Layout User Input Form Biodata

---

## 📋 Kepatuhan Aturan Penugasan (Rules Compliance)

| Aturan | Status | Keterangan Implementasi |
| :--- | :---: | :--- |
| **1. Resource Management** | ✅ Terpenuhi | Seluruh Warna (`colors.xml`), Dimensi & Ukuran Font (`dimens.xml`), Teks & Format String (`strings.xml`), serta Gambar/Ikon (`res/drawable`) diakses melalui `colorResource`, `dimensionResource`, `stringResource`, dan `painterResource`. |
| **2. Box Mengapung di atas Scaffold** | ✅ Terpenuhi | Struktur layout menggunakan `Scaffold` sebagai base container, diikuti `Image` wallpaper di bagian atas, dan `Box` formulir dengan `RoundedCornerShape` serta bayangan (`shadow`) yang mengapung tepat di atas Scaffold. |
| **3. Bebas HARDCODE (Zero Hardcoding)** | ✅ 100% Bebas Hardcode | Tidak ada nilai warna, string literal, spasi pemisah, ukuran pixel, maupun format tanggal yang ditulis langsung di dalam kode Kotlin. |
| **4. Layout Jetpack Compose** | ✅ Terpenuhi | Dibangun sepenuhnya secara deklaratif menggunakan Jetpack Compose & Material 3. |
| **5. Minimal 25 Commit** | ✅ Terpenuhi | Memiliki 25+ commit terstruktur secara bertahap dan bermakna (*conventional commits*). |

---

## 📱 Fitur & Struktur Komponen

1. **Header Wallpaper:**
   - Komponen: `Image` dengan `ContentScale.Crop`
   - Drawable: `@drawable/header_wallpaper` (Cyber Neon futuristic layout)
   - Deskripsi Aksesibilitas: `@string/header_wallpaper_desc`
   - Tinggi: `@dimen/header_wallpaper_height` (270dp)

2. **Floating Box Container:**
   - Komponen: `Box` mengapung dengan offset `@dimen/floating_box_top_offset` (210dp)
   - Sudut Membulat: `@dimen/floating_card_corner_radius` (34dp) pada sudut atas kiri dan kanan
   - Elevasi / Bayangan: `@dimen/floating_card_elevation` (16dp)
   - Latar Belakang: `@color/color_card_floating_bg` (Putih)
   - Dukungan `verticalScroll` sehingga responsif pada berbagai ukuran layar.

3. **Header Formulir:**
   - Judul: `@string/form_title` ("Form Biodata") dengan warna `@color/color_text_title` dan ukuran `@dimen/font_title`
   - Subjudul: `@string/form_subtitle` ("Silahkan isi biodata Anda dibawah ini !!!") dengan warna `@color/color_subtitle_gray`

4. **Input Nama Depan & Nama Belakang:**
   - Disusun berdampingan dalam satu `Row` dengan bobot seimbang (`weight(1f)`) dan celah `@dimen/field_row_gap`
   - Komponen: `OutlinedTextField` dengan sudut membulat `@dimen/field_corner_radius`

5. **Input Email:**
   - Komponen: `OutlinedTextField` dengan lebar penuh (`fillMaxWidth`)
   - Label: `@string/email_label`

6. **Input Tanggal Lahir (DatePicker):**
   - Komponen: `OutlinedTextField` read-only dengan trailing icon kalender (`@drawable/ic_calendar`)
   - Membuka dialog interaktif bawaan Android `DatePickerDialog` saat diklik
   - Format tanggal diambil dari resource: `@string/date_format_pattern`

7. **Pilihan Pengalaman (Experience Dropdown):**
   - Komponen: `OutlinedTextField` read-only dengan trailing icon dropdown (`@drawable/ic_arrow_drop_down`)
   - Menampilkan `DropdownMenu` interaktif dengan pilihan tingkat pengalaman:
     - `@string/exp_beginner` (Pemula < 1 Tahun)
     - `@string/exp_intermediate` (Menengah 1 - 3 Tahun)
     - `@string/exp_advanced` (Mahir 3 - 5 Tahun)
     - `@string/exp_expert` (Expert > 5 Tahun)

8. **Pilihan Keahlian (Skill Selection Checkboxes):**
   - Judul Bagian: `@string/skill_section_title` ("Pilih Skill Anda :")
   - Pilihan Multi-select Checkbox:
     - `Android` (`@string/skill_android`)
     - `UI/UX` (`@string/skill_uiux`)
     - `Web` (`@string/skill_web`)
   - Kustomisasi warna centang melalui `@color/color_checkbox_checked`

9. **Tombol Interaktif Proceed:**
   - Komponen: `Button` kapsul melengkung `@dimen/btn_proceed_corner_radius`
   - Status visual dinamis: Berubah dari `@color/color_btn_proceed_bg` menjadi warna ungu aktif `@color/color_btn_proceed_active_bg` saat pengguna mulai mengisi form
   - Teks tombol: `@string/btn_proceed` ("Proceed")

10. **Ringkasan Hasil Biodata (ResultSummaryCard):**
    - Komponen: `ElevatedCard` yang tampil elegan di bawah tombol setelah formulir disubmit
    - Menampilkan seluruh informasi yang diinputkan (Nama Lengkap, Email, Tanggal Lahir, Pengalaman, dan Skill Terpilih).

---

## 🛠️ Tech Stack
- **Language:** Kotlin
- **UI Toolkit:** Jetpack Compose (Material 3)
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 34+
- **Build System:** Gradle Kotlin DSL (`build.gradle.kts`)
