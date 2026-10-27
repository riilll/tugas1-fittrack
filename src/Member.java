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

    public Member(String nama, String noTelepon, String tanggalDaftar, String jenisPaket) {
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggalDaftar);
        setJenisPaket(jenisPaket);
    }

    public Member(String nama, String noTelepon, String tanggalDaftar) {
        this(nama, noTelepon, tanggalDaftar, PAKET_BASIC);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (isTeksKosong(nama)) {
            System.out.println("Nama ditolak: nama tidak boleh kosong atau hanya berisi spasi");
            return;
        }
        this.nama = nama.trim();
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        if (!isNomorTeleponValid(noTelepon)) {
            System.out.println("Nomor telepon ditolak: harus diawali angka "
                    + AWALAN_NOMOR_TELEPON + ", hanya berisi angka, dan minimal "
                    + PANJANG_MINIMAL_NOMOR_TELEPON + " digit");
            return;
        }
        this.noTelepon = noTelepon;
    }

    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(String tanggalDaftar) {
        if (isTeksKosong(tanggalDaftar)) {
            System.out.println("Tanggal daftar ditolak: tanggal tidak boleh kosong");
            return;
        }
        this.tanggalDaftar = tanggalDaftar.trim();
    }

    public String getJenisPaket() {
        return jenisPaket;
    }

    public void setJenisPaket(String jenisPaket) {
        if (!isPaketValid(jenisPaket)) {
            System.out.println("Jenis paket ditolak: pilihan hanya " + PAKET_BASIC + ", "
                    + PAKET_PREMIUM + ", atau " + PAKET_VIP + " (penulisan harus persis)");
            return;
        }
        this.jenisPaket = jenisPaket;
    }

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
