insert into BOOKS (NAME, AUTHORS, BOUGHT, FORMAT, GENRES, HARDCOVER, ISBN, PAGES, PRICE, PUBLISHER, QUALITY, READ)
values ('Hellenike Glotta. Podręcznik do nauki języka greckiego ', 'Agnieszka Korus, Kazimierz Korus',
        true, 'Physical copy', 'languages, literature', false, '9788301159801', 328, 35.90, 'Wydawnictwo Naukowe PWN', 'Perfect', false);
insert into BOOKS (NAME, AUTHORS, BOUGHT, FORMAT, GENRES, HARDCOVER, ISBN, PAGES, PRICE, PUBLISHER, QUALITY, READ)
values ('Dialogi filozoficzne', 'Św. Augustyn',
        false, null, 'philosophy, ethics', false, '837006681X', 917, 0.00, 'Wydawnictwo Znak', null, false);
insert into BOOKS (NAME, AUTHORS, BOUGHT, FORMAT, GENRES, HARDCOVER, ISBN, PAGES, PRICE, PUBLISHER, QUALITY, READ)
values ('Sztuka Kochania', 'Owidiusz',
        false, null, 'literature', false, '8320717981', 168, 21.99, 'Wydawnictwo Iskry', null, false);
insert into BOOKS (NAME, AUTHORS, BOUGHT, FORMAT, GENRES, HARDCOVER, ISBN, PAGES, PRICE, PUBLISHER, QUALITY, READ)
values ('De Doctrina Christiana', 'Św. Augustyn',
        true, 'Physical', 'theology', false, '8321717981', 342, 24.99, 'Instytut Wydawniczy PAX', 'Good', false);
insert into BOOKS (NAME, AUTHORS, BOUGHT, FORMAT, GENRES, HARDCOVER, ISBN, PAGES, PRICE, PUBLISHER, QUALITY, READ)
values ('O zasadach', 'Orygenes',
        true, 'Physical', 'theology', false, '8320217981', 415, 211.99, 'Wydawnictwo ATK', 'Good-', false);
insert into BOOKS (NAME, AUTHORS, BOUGHT, FORMAT, GENRES, HARDCOVER, ISBN, PAGES, PRICE, PUBLISHER, QUALITY, READ)
values ('Historia Chrześcijaństwa: Narodziny Chrześcijaństwa', 'Warren H. Carol',
        true, 'Physical', 'literature, history', true, '8320711381', 721, 111.99, 'Wydawnictwo Wektory', 'Perfect', true);
insert into BOOKS (NAME, AUTHORS, BOUGHT, FORMAT, GENRES, HARDCOVER, ISBN, PAGES, PRICE, PUBLISHER, QUALITY, READ)
values ('Potworny Regiment', 'Terry Pratchett',
        true, 'Digital: mobi, pdf', 'fantasy, adventure', false, '8323217981', 210, 25.99, 'Wydawnictwo X', 'Perfect', true);

insert into NOTES (TITLE, CONTENT, BOOK_ID)
values ('Do zrobienia', 'Ćwiczenia ze strony 28', 1);
insert into NOTES (TITLE, CONTENT, BOOK_ID)
values ('Pożyczyć Michałowi', null, 2);
insert into NOTES (TITLE, CONTENT, BOOK_ID)
values ('Ciekawostki', '1. Na stronie 34 zawarty opis kwestii oddechu na uwodzenia' ||
                       '2. Fragment ze strony 84 przypomina mocno poezje z Metamorfoz', 3);

