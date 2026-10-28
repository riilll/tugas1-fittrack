/**
 * Merepresentasikan satu member yang terdaftar di FitTrack.
 * Class ini menyimpan data pribadi member dan memastikan setiap
 * perubahan data lolos validasi sebelum disimpan.
 */
public class Member {

    /** Awalan wajib untuk nomor telepon. */
    private static final String AWALAN_NOMOR_TELEPON = "0";

    /** Panjang minimal nomor telepon dalam jumlah digit. */
    private static final int PANJANG_MINIMAL_NOMOR_TELEPON = 10;

    /** Nama paket keanggotaan Basic. */
    public static final String PAKET_BASIC = "Basic";

    /** Nama paket keanggotaan Premium. */
    public static final String PAKET_PREMIUM = "Premium";

    /** Nama paket keanggotaan VIP. */
    public static final String PAKET_VIP = "VIP";

    /** Nilai default untuk data teks yang belum terisi atau tidak valid. */
    private static final String NILAI_BELUM_DIISI = "Belum diisi";

    private String nama = NILAI_BELUM_DIISI;
    private String noTelepon = NILAI_BELUM_DIISI;
    private String tanggalDaftar = NILAI_BELUM_DIISI;
    private String jenisPaket = PAKET_BASIC;

    /**
     * Membuat member lengkap. Setiap nilai diisi lewat setter sehingga
     * validasi berlaku juga di constructor. Nilai yang tidak valid diganti
     * dengan nilai default dan pesan penolakan dicetak.
     * 
     * @param nama          nama lengkap member, tidak boleh kosong
     * @param noTelepon     nomor telepon, diawali 0 dan minimal 10 digit
     * @param tanggalDaftar tanggal pendaftaran, tidak boleh kosong
     * @param jenisPaket    jenis paket: Basic, Premium, atau VIP
     */
    public Member(String nama, String noTelepon, String tanggalDaftar, String jenisPaket) {
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggalDaftar);
        setJenisPaket(jenisPaket);
    }

    /**
     * Membuat member dengan paket otomatis Basic.
     * 
     * @param nama          nama lengkap member, tidak boleh kosong
     * @param noTelepon     nomor telepon, diawali 0 dan minimal 10 digit
     * @param tanggalDaftar tanggal pendaftaran, tidak boleh kosong
     */
    public Member(String nama, String noTelepon, String tanggalDaftar) {
        this(nama, noTelepon, tanggalDaftar, PAKET_BASIC);
    }

    /**
     * Mengambil nama member.
     * 
     * @return nama member
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengubah nama member setelah melalui validasi. Jika nama kosong atau
     * hanya berisi spasi, nama lama dipertahankan dan pesan penolakan dicetak.
     * 
     * @param nama nama baru, tidak boleh kosong atau hanya spasi
     */
    public void setNama(String nama) {
        if (isTeksKosong(nama)) {
            System.out.println("Nama ditolak: nama tidak boleh kosong atau hanya berisi spasi");
            return;
        }
        this.nama = nama.trim();
    }

    /**
     * Mengambil nomor telepon member.
     * 
     * @return nomor telepon member
     */
    public String getNoTelepon() {
        return noTelepon;
    }

    /**
     * Mengubah nomor telepon member setelah melalui validasi format.
     * Jika format tidak valid, nomor lama dipertahankan dan pesan
     * penolakan dicetak.
     * 
     * @param noTelepon nomor telepon baru, wajib diawali angka 0
     *                  dan memiliki panjang minimal 10 digit
     */
    public void setNoTelepon(String noTelepon) {
        if (!isNomorTeleponValid(noTelepon)) {
            System.out.println("Nomor telepon ditolak: harus diawali angka "
                    + AWALAN_NOMOR_TELEPON + ", hanya berisi angka, dan minimal "
                    + PANJANG_MINIMAL_NOMOR_TELEPON + " digit");
            return;
        }
        this.noTelepon = noTelepon;
    }

    /**
     * Mengambil tanggal pendaftaran member.
     * 
     * @return tanggal pendaftaran member
     */
    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    /**
     * Mengubah tanggal pendaftaran setelah melalui validasi. Jika tanggal
     * kosong, tanggal lama dipertahankan dan pesan penolakan dicetak.
     * 
     * @param tanggalDaftar tanggal baru, tidak boleh kosong
     */
    public void setTanggalDaftar(String tanggalDaftar) {
        if (isTeksKosong(tanggalDaftar)) {
            System.out.println("Tanggal daftar ditolak: tanggal tidak boleh kosong");
            return;
        }
        this.tanggalDaftar = tanggalDaftar.trim();
    }

    /**
     * Mengambil jenis paket keanggotaan.
     * 
     * @return jenis paket member
     */
    public String getJenisPaket() {
        return jenisPaket;
    }

    /**
     * Mengubah jenis paket setelah melalui validasi. Jika paket di luar
     * Basic, Premium, atau VIP, paket lama dipertahankan dan pesan
     * penolakan dicetak.
     * 
     * @param jenisPaket paket baru, penulisan harus persis Basic, Premium, atau VIP
     */
    public void setJenisPaket(String jenisPaket) {
        if (!isPaketValid(jenisPaket)) {
            System.out.println("Jenis paket ditolak: pilihan hanya " + PAKET_BASIC + ", "
                    + PAKET_PREMIUM + ", atau " + PAKET_VIP + " (penulisan harus persis)");
            return;
        }
        this.jenisPaket = jenisPaket;
    }

    /**
     * Menghasilkan representasi teks member yang berlabel.
     * 
     * @return data member dalam satu baris berlabel
     */
    @Override
    public String toString() {
        return "Member{nama='" + nama + "', noTelepon='" + noTelepon
                + "', tanggalDaftar='" + tanggalDaftar + "', jenisPaket='" + jenisPaket + "'}";
    }

    /** Memeriksa apakah teks null, kosong, atau hanya berisi spasi. */
    private boolean isTeksKosong(String teks) {
        return teks == null || teks.trim().isEmpty();
    }

    /** Memeriksa awalan, panjang, dan isi nomor telepon. */
    private boolean isNomorTeleponValid(String nomor) {
        return nomor != null
                && nomor.startsWith(AWALAN_NOMOR_TELEPON)
                && nomor.length() >= PANJANG_MINIMAL_NOMOR_TELEPON
                && isSemuaDigit(nomor);
    }

    /** Memeriksa apakah seluruh karakter teks adalah angka. */
    private boolean isSemuaDigit(String teks) {
        for (int i = 0; i < teks.length(); i++) {
            if (!Character.isDigit(teks.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /** Memeriksa apakah paket sama persis dengan salah satu pilihan resmi. */
    private boolean isPaketValid(String paket) {
        return PAKET_BASIC.equals(paket)
                || PAKET_PREMIUM.equals(paket)
                || PAKET_VIP.equals(paket);
    }
}
