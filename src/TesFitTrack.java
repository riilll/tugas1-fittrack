public class TesFitTrack {

    public static void main(String[] args) {
        System.out.println("=== Membuat data member ===");
        Member[] daftarMember = {
                new Member("Budi Santoso", "081234567890", "17-08-2026", "Premium"),
                new Member("Siti Aminah", "085611223344", "18-08-2026", "VIP"),
                new Member("Rina Wijaya", "087788990011", "19-08-2026"),
                new Member("Andi Pratama", "081298765432", "20-08-2026", "Basic")
        };

        System.out.println();
        System.out.println("=== Daftar seluruh member ===");
        for (int i = 0; i < daftarMember.length; i++) {
            System.out.println((i + 1) + ". " + daftarMember[i]);
        }
    }
}
