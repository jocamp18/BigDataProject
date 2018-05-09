USE dshs;
SET searched_year='2011';
SELECT county, SUM(patients) AS pat FROM (SELECT county, COUNT(*) AS `patients` FROM inpatients WHERE year=${hiveconf:searched_year} GROUP BY county UNION SELECT county, COUNT(*) AS `patients` FROM outpatients WHERE year=${hiveconf:searched_year} GROUP BY county) AS county_patients GROUP BY county ORDER BY pat DESC LIMIT 10;

