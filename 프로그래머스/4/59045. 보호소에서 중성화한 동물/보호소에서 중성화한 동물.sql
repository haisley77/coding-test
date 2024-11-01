-- 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부
-- 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부
SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS A JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE LIKE 'Intact%' AND (B.SEX_UPON_OUTCOME LIKE 'Neutered%' OR B.SEX_UPON_OUTCOME LIKE 'Spayed%')