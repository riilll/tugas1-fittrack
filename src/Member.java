public class Member {

    private String nama = "Belum diisi";
    private String noTelepon = "Belum diisi";
    private String tanggalDaftar = "Belum diisi";
    private String jenisPaket = "Basic";

    public Member(String nama, String noTelepon, String tanggalDaftar, String jenisPaket){
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggalDaftar);
        setjenisPaket(jenisPaket);
    }
    
    public Member(String nama, String noTelepon, String tanggalDaftar){
        this(nama, noTelepon, tanggalDaftar, "Basic");
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()){
            System.out.println("Nama tidak boleh kosong atau hanya berisi spasi");
            return;
        }
        this.nama = nama.trim();
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        boolean valid = noTelepon != null
                && noTelepon.startsWith("0")
                && noTelepon.length()>= 10;
        if (valid){
            for(int i=0; i<noTelepon.length(); i++){
                if(!Character.isDigit(noTelepon.charAt(i))){
                    valid = false;
                }
            }
        }
        if (!valid){
            System.out.println("no harus diawali angka 0, hanya berisi angka dan minimal 10 digit");
            return;
        }
        this.noTelepon = noTelepon;
    }

    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(String tanggalDaftar) {
        if (tanggalDaftar == null || tanggalDaftar.trim().isEmpty()){
            System.out.println("Tanggal tidak boleh kosong");
            return;
        }
        this.tanggalDaftar = tanggalDaftar.trim();
    }

    public String getJenisPaket() {
        return jenisPaket;
    }

    public void setJenisPaket(String jenisPaket) {
        if (!"Basic".equals(jenisPaket) && !"Premium".equals(jenisPaket) && !"VIP".equals(jenisPaket)){
            System.out.println("Jenis paket harus Basic, Premium, atau VIP (penulisan harus sama)");
            return;
        }
        this.jenisPaket = jenisPaket;
    }
}
