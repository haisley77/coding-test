-- 코드를 작성해주세요
WITH P AS (
    SELECT E1.ID ID, E2.ID PARENT_ID
    FROM ECOLI_DATA E1 JOIN ECOLI_DATA E2 ON E1.ID = E2.PARENT_ID)
    
SELECT E1.ID AS ID
FROM (SELECT PARENT_ID AS ID
      FROM P
      WHERE PARENT_ID NOT IN (SELECT E.ID
                              FROM ECOLI_DATA E JOIN P ON E.PARENT_ID = P.PARENT_ID))
                              A JOIN ECOLI_DATA E1 ON E1.PARENT_ID = A.ID