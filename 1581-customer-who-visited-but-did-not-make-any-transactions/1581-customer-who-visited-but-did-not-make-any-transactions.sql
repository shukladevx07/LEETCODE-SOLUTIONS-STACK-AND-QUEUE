SELECT v.customer_id, COUNT(*) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;
