-- 제품 ID, 제품 이름, 제품코드, 식품분류, 식품 가격
-- 주문 ID, 제품 ID, 주문량, 생산일자, 입고일자, 출고일자, 공장 ID, 창고 ID

SELECT A.PRODUCT_ID, A.PRODUCT_NAME, SUM((A.PRICE * B.AMOUNT)) TOTAL_SALES
FROM FOOD_PRODUCT A JOIN FOOD_ORDER B ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE YEAR(B.PRODUCE_DATE) = 2022 AND MONTH(B.PRODUCE_DATE) = 5
GROUP BY A.PRODUCT_ID, A.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID