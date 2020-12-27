# CS101 Projektni Zadatak

> Simulacija kviza, ima opcije za više igrača, i vodi evidenciju o postignutim rezultatima. 
> Pitanja i rezultati se nalaze u odvojenim fajlovima.


Kviz - Pitanje

Osoba - Igrac

Tabela rezultata

pokrene se igra, izabere se ime igraca,
ako vec postoji igrac sa tim imenom, onda se preuzmu njihovi podaci.

pokrene se igra naredbom start

igrac moze da izadje naredbom exit (bilo kada)

u toku igre, ucitavaju se pitanja iz fajla, svako pitanje ima nekoliko ponudjenih odgovora
i informaciju o tome koje je pitanje tacno.

korisnik unosi redni (celi) broj odgovora.

Ako je odgovor tacno, dodaju se poeni,
ako je odgovor pogresan prikazuje se tacan odgovor,
ide se na sledece pitanje

max deset pitanja po igri.

Pitanja imaju nasumicni raspored svaki put (arrayList.shuffle?)

ako se unese komanda help, prikazuje se lista komandi

komanda results se moze videti samo van igre, i prikazuje listu igraca sa njihovim poenima, npr:
- 99 Darko
- 77 Jovan

Person/Player i Pitanje klase trebaju da budu Serializable da bi mogle da se cuvaju kao binarna vrednost.