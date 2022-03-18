# SQL - Ödev 12

Aşağıdaki sorgu senaryolarını dvdrental örnek veri tabanı üzerinden gerçekleştiriniz.

1. **film** tablosunda film uzunluğu **length** sütununda gösterilmektedir. Uzunluğu ortalama film uzunluğundan fazla kaç tane film vardır?

```sql
SELECT COUNT(*)
FROM film
WHERE length > 
(
SELECT AVG(length)
FROM film
);
```

> **Sonuç :** 489

2. **film** tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?

```sql
SELECT COUNT(*)
FROM film
WHERE rental_rate = 
(
SELECT MAX(rental_rate)
FROM film
)
```

> **Sonuç :** 336

3. **film** tablosunda en düşük rental_rate ve en düşün replacement_cost değerlerine sahip filmleri sıralayınız.

```sql
SELECT COUNT(*)
FROM film
WHERE rental_rate = 
(
SELECT MIN(rental_rate)
FROM film
)
AND
replacement_cost = 
(
SELECT MAX(replacement_cost)
FROM film
)
```

> **Sonuç :** 22

4. **payment** tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.

```sql
SELECT * 
FROM customer 
WHERE customer_id = ANY
(
SELECT customer_id 
FROM payment
GROUP BY customer_id
ORDER BY COUNT(customer_id) DESC
LIMIT 10
)
```