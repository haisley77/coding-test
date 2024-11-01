-- 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE LOCATE('el', NAME) >= 1 AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME