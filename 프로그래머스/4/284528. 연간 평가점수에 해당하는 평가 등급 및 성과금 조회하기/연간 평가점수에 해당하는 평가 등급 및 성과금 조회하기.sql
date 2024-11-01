-- 부서 ID, 국문 부서명, 영문 부서명, 부서 위치
-- 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉
-- 사번, 연도, 반기, 평가 점수

WITH T AS (SELECT EMP_NO, 
                  CASE WHEN AVG(SCORE) >= 96 THEN 'S'
                       WHEN AVG(SCORE) >= 90 THEN 'A'
                       WHEN AVG(SCORE) >= 80 THEN 'B'
                       ELSE 'C' END AS GRADE
          FROM HR_GRADE
          GROUP BY EMP_NO)
          
SELECT A.EMP_NO, A.EMP_NAME, T.GRADE,
        CASE WHEN GRADE = 'S' THEN SAL * 0.2
             WHEN GRADE = 'A' THEN SAL * 0.15
             WHEN GRADE = 'B' THEN SAL * 0.1
             ELSE 0 END AS BONUS
FROM HR_EMPLOYEES A JOIN T ON A.EMP_NO = T.EMP_NO
ORDER BY A.EMP_NO
