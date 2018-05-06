#!/bin/bash
# $1 --> year
in=`hive -S -e "USE dshs; SELECT COUNT(*) FROM inpatients WHERE YEAR='$1';"`
out=`hive -S -e "USE dshs; SELECT COUNT(*) FROM outpatients WHERE YEAR='$1';"`
total=$(echo "${in} + ${out}" | bc -l)
out_per=$(echo  "($out / $total) * 100" | bc -l)
echo "Outpatients proportion"
echo $out_per
