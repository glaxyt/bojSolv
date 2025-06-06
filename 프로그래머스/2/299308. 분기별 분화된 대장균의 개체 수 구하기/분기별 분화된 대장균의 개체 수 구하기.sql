WITH TEMP AS (
    SELECT
        CASE
            WHEN MONTH(DIFFERENTIATION_DATE) <= '3' THEN '1Q'
            WHEN MONTH(DIFFERENTIATION_DATE) <= '6' THEN '2Q'
            WHEN MONTH(DIFFERENTIATION_DATE) <= '9' THEN '3Q'
            ELSE '4Q'
        END 'QUARTER'
    FROM ECOLI_DATA
)

SELECT QUARTER, COUNT(*) AS ECOLI_COUNT
FROM TEMP
GROUP BY QUARTER
ORDER BY QUARTER