#!/bin/bash
# $1 --> year
in=`spark-sql -S -e "USE dshs; SELECT COUNT(*) FROM inpatients WHERE YEAR='$1';"`
out=`spark-sql -S -e "USE dshs; SELECT COUNT(*) FROM outpatients WHERE YEAR='$1';"`
total=$(echo "${in} + ${out}" | bc -l)
in_per=$(echo  "($in / $total) * 100" | bc -l)
echo "Inpatients proportion"
echo $in_per
