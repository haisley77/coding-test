-- 코드를 작성해주세요

WITH DS AS (SELECT D.ID, D.EMAIL,
            CASE 
                WHEN NAME = 'Python' THEN 1
            ELSE 0 END AS Python,
            CASE 
                WHEN NAME = 'C#' THEN 1
            ELSE 0 END AS C,
            CASE 
                WHEN CATEGORY = 'Front End' THEN 1
            ELSE 0 END AS CATEGORY
            FROM DEVELOPERS D, SKILLCODES S
            WHERE D.SKILL_CODE & S.CODE
            ORDER BY D.ID)

SELECT CASE WHEN SUM(Python) >= 1 AND SUM(CATEGORY) >= 1 THEN 'A'
WHEN SUM(C) >= 1 THEN 'B'
WHEN SUM(CATEGORY) >= 1 THEN 'C'
ELSE NULL END AS GRADE, ID, EMAIL
FROM DS
GROUP BY ID, EMAIL
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID