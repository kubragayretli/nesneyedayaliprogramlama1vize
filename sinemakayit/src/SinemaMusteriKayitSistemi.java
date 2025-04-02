import java.util.Scanner;

public class SinemaMusteriKayitSistemi {
    private static String[] filmler = new String[10];
    private static int[] sureler = new int[10];
    private static String[] turler = new String[10];
    private static String[] musteriler = new String[20];
    private static String[] emailAdresleri = new String[20];
    private static int[][] biletler = new int[20][10]; // Müşteri x Film ilişkisini tutar

    private static int filmSayisi = 0;
    private static int musteriSayisi = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\nSinema Müşteri Kayıt Sistemi");
            System.out.println("1. Film Ekle");
            System.out.println("2. Müşteri Ekle");
            System.out.println("3. Bilet Satışı Yap");
            System.out.println("4. Filmleri Listele");
            System.out.println("5. Müşterileri Listele");
            System.out.println("6. Biletleri Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    filmEkle(scanner);
                    break;
                case 2:
                    musteriEkle(scanner);
                    break;
                case 3:
                    biletSatisi(scanner);
                    break;
                case 4:
                    filmleriListele();
                    break;
                case 5:
                    musterileriListele();
                    break;
                case 6:
                    biletleriListele();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        } while (secim != 0);
    }

    private static void filmEkle(Scanner scanner) {
        if (filmSayisi >= 10) {
            System.out.println("Maksimum film sayısına ulaşıldı.");
            return;
        }
        System.out.print("Film adı: ");
        filmler[filmSayisi] = scanner.nextLine();
        System.out.print("Süre (dakika): ");
        sureler[filmSayisi] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tür: ");
        turler[filmSayisi] = scanner.nextLine();
        filmSayisi++;
        System.out.println("Film başarıyla eklendi.");
    }

    private static void musteriEkle(Scanner scanner) {
        if (musteriSayisi >= 20) {
            System.out.println("Maksimum müşteri sayısına ulaşıldı.");
            return;
        }
        System.out.print("Müşteri adı: ");
        musteriler[musteriSayisi] = scanner.nextLine();
        System.out.print("E-posta: ");
        emailAdresleri[musteriSayisi] = scanner.nextLine();
        musteriSayisi++;
        System.out.println("Müşteri başarıyla eklendi.");
    }

    private static void biletSatisi(Scanner scanner) {
        if (musteriSayisi == 0 || filmSayisi == 0) {
            System.out.println("Önce müşteri ve film ekleyin.");
            return;
        }

        System.out.println("Müşteriler:");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println(i + " - " + musteriler[i]);
        }
        System.out.print("Müşteri seçin: ");
        int musteriIndex = scanner.nextInt();

        System.out.println("Filmler:");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println(i + " - " + filmler[i]);
        }
        System.out.print("Film seçin: ");
        int filmIndex = scanner.nextInt();

        if (musteriIndex < musteriSayisi && filmIndex < filmSayisi) {
            biletler[musteriIndex][filmIndex] = 1;
            System.out.println("Bilet başarıyla oluşturuldu.");
        } else {
            System.out.println("Geçersiz seçim.");
        }
    }

    private static void filmleriListele() {
        System.out.println("\nFilmler:");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println(filmler[i] + " - " + sureler[i] + " dk - " + turler[i]);
        }
    }

    private static void musterileriListele() {
        System.out.println("\nMüşteriler:");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println(musteriler[i] + " - " + emailAdresleri[i]);
        }
    }

    private static void biletleriListele() {
        System.out.println("\nSatılan Biletler:");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.print(musteriler[i] + " -> ");
            for (int j = 0; j < filmSayisi; j++) {
                if (biletler[i][j] == 1) {
                    System.out.print(filmler[j] + " | ");
                }
            }
            System.out.println();
        }
    }
}
