# Write your MySQL query statement below
SELECT Product.product_name,Sales.year,Sales.price
FROM Sales
JOIN Product
WHERE Product.product_id=Sales.product_id;