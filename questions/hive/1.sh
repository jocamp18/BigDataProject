#!/bin/bash
# $1 --> year
in=`hive -S -e "USE dshs; SELECT COUNT(*) FROM inpatients WHERE YEAR='$1';"`
out=`hive -S -e "USE dshs; SELECT COUNT(*) FROM outpatients WHERE YEAR='$1';"`
total=$(echo "${in} + ${out}" | bc -l)
in_per=$(echo  "($in / $total) * 100" | bc -l)
echo "Inpatients proportion"
echo $in_per
#USE dshs;
#SET search_year="2011";
#2937134
#SELECT * FROM inpatients WHERE year=current_year LIMIT 10;
#SELECT ${hiveconf:a} AS inp;
# select * from inpatients where year='${hivevar:current}' LIMIT 10;
