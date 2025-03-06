

SELECT A.PRODUCT_ID, A.PRODUCT_NAME, SUM(A.PRICE * B.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT A JOIN FOOD_ORDER B ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE YEAR(B.PRODUCE_DATE) = 2022 AND MONTH(B.PRODUCE_DATE) = 5
GROUP BY PRODUCT_ID
ORDER BY SUM(A.PRICE * B.AMOUNT) DESC, PRODUCT_ID