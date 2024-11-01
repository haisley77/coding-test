-- 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수
-- 회원 ID, 닉네임, 시, 도로명 주소, 상세 주소, 전화번호

SELECT B.USER_ID, B.NICKNAME, SUM(A.PRICE) TOTAL_SALES
FROM USED_GOODS_BOARD A JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
WHERE A.STATUS = 'DONE'
GROUP BY B.USER_ID, B.NICKNAME
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES