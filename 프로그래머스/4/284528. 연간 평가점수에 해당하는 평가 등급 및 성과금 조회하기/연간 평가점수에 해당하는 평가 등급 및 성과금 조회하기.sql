-- 코드를 작성해주세요
SELECT A.EMP_NO, A.EMP_NAME,  CASE WHEN B.SCORE >= 96 THEN 'S'
                          WHEN B.SCORE >= 90 THEN 'A'
                          WHEN B.SCORE >= 80 THEN 'B'
                          ELSE 'C' END AS GRADE, 
                          CASE WHEN B.SCORE >= 96 THEN SAL * 0.2
                          WHEN B.SCORE >= 90 THEN SAL * 0.15
                          WHEN B.SCORE >= 80 THEN SAL * 0.1
                          ELSE 0 END AS BONUS
FROM HR_EMPLOYEES A JOIN (SELECT EMP_NO, AVG(SCORE) AS SCORE
                            FROM HR_GRADE
                            GROUP BY EMP_NO) B
ON A.EMP_NO = B.EMP_NO
ORDER BY A.EMP_NO;