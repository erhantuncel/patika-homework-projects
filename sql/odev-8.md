# SQL - Ödev 8

1. test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.

```sql
CREATE TABLE employee (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	birthdate DATE NOT NULL,
	email VARCHAR(100)
);
```

2. Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.

```sql
insert into employee (id, name, birthdate, email) values (1, 'Alisun', '4/19/2006', 'agirke0@comsenz.com');
insert into employee (id, name, birthdate, email) values (2, 'Dorena', '9/24/1967', 'dcowlard1@cdc.gov');
insert into employee (id, name, birthdate, email) values (3, 'Brigit', '3/10/2003', 'bmilliken2@sfgate.com');
insert into employee (id, name, birthdate, email) values (4, 'Bendick', '2/9/2010', 'bwootton3@yandex.ru');
insert into employee (id, name, birthdate, email) values (5, 'Rickert', '10/8/1957', 'rkivits4@auda.org.au');
insert into employee (id, name, birthdate, email) values (6, 'Ronda', '7/11/1966', 'rsowle5@state.gov');
insert into employee (id, name, birthdate, email) values (7, 'Lucius', '11/1/2018', null);
insert into employee (id, name, birthdate, email) values (8, 'Susannah', '8/14/1967', 'scalbrathe7@diigo.com');
insert into employee (id, name, birthdate, email) values (9, 'Lilli', '11/16/1971', null);
insert into employee (id, name, birthdate, email) values (10, 'Obed', '7/3/1969', 'omacqueen9@barnesandnoble.com');
insert into employee (id, name, birthdate, email) values (11, 'Zora', '4/18/1962', 'zrawlingsa@symantec.com');
insert into employee (id, name, birthdate, email) values (12, 'Hugo', '12/22/2016', null);
insert into employee (id, name, birthdate, email) values (13, 'Sapphira', '6/20/2017', 'sclemersonc@jigsy.com');
insert into employee (id, name, birthdate, email) values (14, 'Kimberly', '4/6/1958', 'kmacallamd@godaddy.com');
insert into employee (id, name, birthdate, email) values (15, 'Tybalt', '12/16/1950', null);
insert into employee (id, name, birthdate, email) values (16, 'Kellina', '11/22/1958', 'kbassettf@blogs.com');
insert into employee (id, name, birthdate, email) values (17, 'Wilfred', '4/1/1996', null);
insert into employee (id, name, birthdate, email) values (18, 'Bobette', '7/5/2009', 'bdinzeyh@umich.edu');
insert into employee (id, name, birthdate, email) values (19, 'Adriane', '10/8/1964', 'achateri@reverbnation.com');
insert into employee (id, name, birthdate, email) values (20, 'Grace', '5/19/1975', 'gsagarj@wikipedia.org');
insert into employee (id, name, birthdate, email) values (21, 'Anica', '2/15/2014', 'amacdearmidk@wikia.com');
insert into employee (id, name, birthdate, email) values (22, 'Frannie', '3/19/1984', 'fsingletonl@seattletimes.com');
insert into employee (id, name, birthdate, email) values (23, 'Janel', '6/29/1964', 'jdalyielm@pen.io');
insert into employee (id, name, birthdate, email) values (24, 'Aurea', '10/11/2008', null);
insert into employee (id, name, birthdate, email) values (25, 'Blane', '2/5/2009', null);
insert into employee (id, name, birthdate, email) values (26, 'Reine', '10/20/1958', 'rcassarp@dropbox.com');
insert into employee (id, name, birthdate, email) values (27, 'Shel', '4/19/1952', 'smartelloq@people.com.cn');
insert into employee (id, name, birthdate, email) values (28, 'Catlaina', '12/8/2007', null);
insert into employee (id, name, birthdate, email) values (29, 'Klement', '11/7/1959', 'ksyratts@360.cn');
insert into employee (id, name, birthdate, email) values (30, 'Diena', '6/25/1985', 'dberkt@hc360.com');
insert into employee (id, name, birthdate, email) values (31, 'Herman', '11/4/2018', 'hmagovernu@ibm.com');
insert into employee (id, name, birthdate, email) values (32, 'Lina', '8/5/2005', 'lpascallv@hubpages.com');
insert into employee (id, name, birthdate, email) values (33, 'Shell', '1/5/1997', 'shazeleyw@springer.com');
insert into employee (id, name, birthdate, email) values (34, 'Marcelline', '10/23/1969', 'mwoodruffx@theatlantic.com');
insert into employee (id, name, birthdate, email) values (35, 'Hephzibah', '10/31/1966', null);
insert into employee (id, name, birthdate, email) values (36, 'Dianemarie', '5/14/1972', 'dcorneillez@squidoo.com');
insert into employee (id, name, birthdate, email) values (37, 'Lauritz', '11/12/1955', null);
insert into employee (id, name, birthdate, email) values (38, 'Jo-ann', '10/4/1990', 'jtoderi11@gravatar.com');
insert into employee (id, name, birthdate, email) values (39, 'Ringo', '10/29/1987', 'rtrathan12@geocities.com');
insert into employee (id, name, birthdate, email) values (40, 'Audy', '12/5/1951', 'adonnel13@vinaora.com');
insert into employee (id, name, birthdate, email) values (41, 'Sibel', '11/27/1944', 'sohingerty14@answers.com');
insert into employee (id, name, birthdate, email) values (42, 'Emile', '9/13/1982', null);
insert into employee (id, name, birthdate, email) values (43, 'Everett', '4/10/1991', 'eblackmore16@google.es');
insert into employee (id, name, birthdate, email) values (44, 'Conn', '3/24/1975', 'cboag17@google.es');
insert into employee (id, name, birthdate, email) values (45, 'Charlean', '11/2/1987', null);
insert into employee (id, name, birthdate, email) values (46, 'Hillard', '6/23/2014', 'hsyseland19@liveinternet.ru');
insert into employee (id, name, birthdate, email) values (47, 'Goldy', '11/2/1946', 'ggofford1a@liveinternet.ru');
insert into employee (id, name, birthdate, email) values (48, 'Armando', '10/3/1945', 'acutriss1b@i2i.jp');
insert into employee (id, name, birthdate, email) values (49, 'Addison', '12/15/2008', 'abow1c@gravatar.com');
insert into employee (id, name, birthdate, email) values (50, 'Calli', '4/29/2000', 'cwingrove1d@taobao.com');
```

3. Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.

```sql
-- id sütununa göre
UPDATE employee
SET
	name='Andree',
	birthdate='7/10/1974',
	email=null
WHERE id=10;

-- name sütununa göre
UPDATE employee
SET
	birthdate='4/6/1957',
	email='kmacallamd@abc.com'
WHERE name='Kimberly';

-- birthdate sütununa göre
UPDATE employee
SET
	name='Sandi',
	email='sgallyon3@newsvine.com'
WHERE birthdate='4/19/1952';

-- email sütununa göre
UPDATE employee
SET
	name='Minetta',
	birthdate='3/4/2015'
WHERE email='adonnel13@vinaora.com';

-- id sütununa göre
UPDATE employee
SET
	name='Jocelin',
	birthdate='9/21/1995',
	email='jevennett1@shareasale.com'
WHERE id=50;
```

4. Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.

```sql
-- id sütununa göre
DELETE FROM employee
WHERE id=4;

-- name sütununa göre
DELETE FROM employee
WHERE name='Wilfred';

-- birthdate sütununa göre
DELETE FROM employee
WHERE birthdate='4/10/1991';

-- email sütununa göre
DELETE FROM employee
WHERE email='lpascallv@hubpages.com';

-- name sütununa göre
DELETE FROM employee
WHERE name LIKE '%n';
```
