SELECT NAME, DATETIME
FROM
(
SELECT ANIMAL_ID, NAME, DATETIME, DENSE_RANK() OVER (ORDER BY DATETIME ASC) AS RANK
FROM ANIMAL_INS
        WHERE ANIMAL_ID NOT IN (
                        SELECT ANIMAL_ID
                        FROM ANIMAL_OUTS)
)
WHERE RANK <= 3;
