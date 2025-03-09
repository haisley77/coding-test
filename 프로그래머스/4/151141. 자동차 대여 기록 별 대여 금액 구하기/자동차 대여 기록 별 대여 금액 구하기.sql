WITH T AS (SELECT B.HISTORY_ID, A.CAR_TYPE, A.DAILY_FEE, DATEDIFF(B.END_DATE,B.START_DATE)+1 AS DIFF,
           CASE WHEN DATEDIFF(B.END_DATE,B.START_DATE)+1 >= 90 THEN '90일 이상'
           WHEN DATEDIFF(B.END_DATE,B.START_DATE)+1 >= 30 THEN '30일 이상' 
           WHEN DATEDIFF(B.END_DATE,B.START_DATE)+1 >= 7 THEN '7일 이상' 
           ELSE '0일 이상' END AS DURATION_TYPE
           FROM CAR_RENTAL_COMPANY_CAR A 
           JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B
           ON A.CAR_ID = B.CAR_ID
           WHERE A.CAR_TYPE = '트럭')

SELECT HISTORY_ID, ROUND(DIFF * (1-IFNULL(DISCOUNT_RATE,0)/100) * DAILY_FEE) AS FEE
FROM T LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN A
ON T.DURATION_TYPE = A.DURATION_TYPE AND T.CAR_TYPE = A.CAR_TYPE
ORDER BY FEE DESC, HISTORY_ID DESC

