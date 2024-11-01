-- 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트
-- 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일
-- 요금 할인 정책 ID, 자동차 종류, 대여 기간 종류, 할인율(%)

WITH T AS (SELECT A.CAR_ID, A.CAR_TYPE, A.DAILY_FEE, DISCOUNT_RATE
          FROM CAR_RENTAL_COMPANY_CAR A JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN B
          ON A.CAR_TYPE = B.CAR_TYPE
          WHERE B.DURATION_TYPE = '30일 이상' AND B.CAR_TYPE IN ('세단','SUV'))


SELECT DISTINCT T.CAR_ID, T.CAR_TYPE, FLOOR(T.DAILY_FEE * 30 * (100-T.DISCOUNT_RATE) / 100) AS FEE
FROM T JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B ON T.CAR_ID = B.CAR_ID
WHERE ((T.DAILY_FEE * 30 * (100-T.DISCOUNT_RATE) / 100) BETWEEN 500000 AND 2000000) 
                    AND T.CAR_ID NOT IN (SELECT CAR_ID
                                         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                         WHERE (START_DATE >= '2022-11-01' AND START_DATE < '2022-12-01')
                                         OR (END_DATE >= '2022-11-01' AND END_DATE < '2022-12-01')
                                         OR (START_DATE < '2022-11-01' AND END_DATE >= '2022-12-01')
                                         GROUP BY CAR_ID)
ORDER BY FEE DESC, T.CAR_TYPE, T.CAR_ID DESC

