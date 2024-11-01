-- 회원 ID, 성별, 나이, 가입일
-- 온라인 상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일
SELECT DISTINCT YEAR(B.SALES_DATE) YEAR, MONTH(B.SALES_DATE) MONTH, A.GENDER, COUNT(DISTINCT A.USER_ID) USERS 
FROM USER_INFO A JOIN ONLINE_SALE B ON A.USER_ID = B.USER_ID
WHERE A.GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER