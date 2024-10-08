-- 코드를 입력하세요
WITH PA (APNT_YMD, APNT_NO, PT_NAME, PT_NO, MCDP_CD, DR_ID) AS 
(SELECT A.APNT_YMD, A.APNT_NO, P.PT_NAME, A.PT_NO, A.MCDP_CD, A.MDDR_ID
FROM APPOINTMENT A LEFT JOIN PATIENT P ON A.PT_NO = P.PT_NO
WHERE A.APNT_CNCL_YN = 'N' AND YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 4 AND DAYOFMONTH(APNT_YMD) = 13 AND A.MCDP_CD = 'CS')

SELECT PA.APNT_NO, PA.PT_NAME, PA.PT_NO, PA.MCDP_CD, D.DR_NAME, PA.APNT_YMD
FROM PA LEFT JOIN DOCTOR D ON PA.DR_ID = D.DR_ID
ORDER BY PA.APNT_YMD