USE dshs;
SET searched_year='2011';
SELECT princ_diag_code, SUM(patients) AS pat FROM(SELECT princ_diag_code, COUNT(*) AS patients FROM inpatients WHERE year=${hiveconf:searched_year} GROUP BY princ_diag_code UNION SELECT princ_diag_code, COUNT(*) AS patients FROM outpatients WHERE year=${hiveconf:searched_year} GROUP BY princ_diag_code) AS diag_patients GROUP BY princ_diag_code ORDER BY pat DESC LIMIT 10;
