SELECT 
    c.name as Customers
FROM Customers AS c
LEFT JOIN Orders o
ON c.id = o.CustomerId
WHERE o.CustomerId IS NULL