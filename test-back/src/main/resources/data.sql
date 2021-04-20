INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
              
INSERT INTO prevoznik(id, pib, adresa, naziv) VALUES(1, "421412512", "Novi Sad", "Novi Sad Trans");
INSERT INTO prevoznik(id, pib, adresa, naziv) VALUES(2, "532412512", "Beograd", "Beograd Trans");
INSERT INTO prevoznik(id, pib, adresa, naziv) VALUES(3, "123412512", "Srbobran", "Srbobran Trans");
INSERT INTO prevoznik(id, pib, adresa, naziv) VALUES(4, "222112512", "Kamenica", "Kamenica Trans");
INSERT INTO prevoznik(id, pib, adresa, naziv) VALUES(5, "111212512", "Zrenjanin", "Zrenjanin Trans");

INSERT INTO linija(id, broj_mesta, cena_karte, destinacija, vreme_polaska, prevoznik_id) VALUES (1, 7, 250.00, "Zlatibor", "08:00", 2);
INSERT INTO linija(id, broj_mesta, cena_karte, destinacija, vreme_polaska, prevoznik_id) VALUES (2, 53, 350.00, "Nis", "18:20", 1);
INSERT INTO linija(id, broj_mesta, cena_karte, destinacija, vreme_polaska, prevoznik_id) VALUES (3, 40, 1250.00, "Budva", "12:00", 3);
INSERT INTO linija(id, broj_mesta, cena_karte, destinacija, vreme_polaska, prevoznik_id) VALUES (4, 47, 650.00, "Sarajevo", "05:00", 2);
INSERT INTO linija(id, broj_mesta, cena_karte, destinacija, vreme_polaska, prevoznik_id) VALUES (5, 35, 750.00, "Zagreb", "04:30", 4);

INSERT INTO rezervacija(id, linija_id) VALUES (1, 2);
INSERT INTO rezervacija(id, linija_id) VALUES (2, 4);
INSERT INTO rezervacija(id, linija_id) VALUES (3, 3);
INSERT INTO rezervacija(id, linija_id) VALUES (4, 5);
INSERT INTO rezervacija(id, linija_id) VALUES (5, 4);
INSERT INTO rezervacija(id, linija_id) VALUES (6, 1);
