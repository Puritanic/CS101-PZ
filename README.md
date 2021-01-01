# CS101 Projektni Zadatak

> Simulacija kviza, ima opcije za više igrača, i vodi evidenciju o postignutim rezultatima. 
> Pitanja i rezultati se nalaze u odvojenim fajlovima.

## Pokretanje projekta

Projekat se može pokrenuti preko komandne linije, ili iz IDE okruženja.

Iz komandne linije, projekat se može pokrenuti na sledeći način (_ako se nalazite u root direktorijumu projekta_):

```sh
javac ./src/main/*
cd src
java main.Main
```

## Uputstvo za korišćenje

Nakon pokretanja programa, imate opciju da izaberete jednu od nekoliko ponudjenih komandi:

- `start` - Pokreće kviz program, uz prethodno kreiranje profila igrača
- `res` - prikazuje rezultate svih igrača koji su igrali igru (_ukoliko ih ima_)
- `exit` - izlazak iz programa

Takodje postoji i `help` komanda koja ponovo prikazuje listu mogućih komandi nakon unosa.

Svaki kviz se sastoji od 10 nasumično izabranih pitanja, i na pitanje se odgovara tako što se unese redni broj nekog od ponudjenih odgovora.

## Zahtevi

Projekat **MORA** da sadrži:
 - [x] Bar jedan primer implementacije koja sadrži nasleđivanje
 - [x] Bar jedan interfejs koji se realizuje i bar jednu apstraktnu klasu
 - [x] Bar pet klasa
 - [x] Implementiranu podelu rada klasa po paketima – posebne klase za čuvanje podataka
(klase tipa Student, Profesor, Predmet... Zavisi od teme), posebne klase za komunikaciju sa korisnikom (klasa preko koje korisnik unosi podatke i klasa koja prikazuje/štampa korisniku podatke), obradu podataka (sadrži razne metode koje rade nad podacima, na primer traži najboljeg studenta po proseku), upis i čitanje iz fajlova.
 - [x] Rad sa listama (čuvanje podataka u vidu listi objekata i metode koje rade sa listama)
 - [x] Rad sa klasom String
 - [x] Korišćenje više uslova (if ili switch) i više petlji
 - [x] Bar jedan Enum (nabrojivi tip)
 - [x] Rad sa izuzecima (kreiranje novog izuzetka i njegova obrada)
 - [x] Rad sa datotekama (čitanje i pisanje)
 - [x] Podatke koje koristi aplikacija unosi korisnik ili se čitaju iz datoteka, izbegavati fiksirane vrednosti u kodu
 - [x] Enkapsulaciju - svaka klasa mora imati konstruktore, getere, setere i override toString metode.
 - [ ] Dokument koji opisuje funkcionalnosti aplikacije kao i uputstvo korišćenja (šablon u prilogu mejla)
 - [ ] Klasni dijagram u PowerDesigner-u koji prikazuje sve klase i relacije između klasa koji se poklapa sa kodom (bar delimično)