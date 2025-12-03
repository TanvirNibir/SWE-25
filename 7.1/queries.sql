SELECT *
FROM currency_converter.CURRENCY;

SELECT *
FROM currency_converter.CURRENCY
WHERE abbreviation = 'EUR';

SELECT COUNT(*) AS currency_count
FROM currency_converter.CURRENCY;

SELECT *
FROM currency_converter.CURRENCY
ORDER BY rate_to_usd DESC
LIMIT 1;

