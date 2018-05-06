#!/bin/bash
# $1 --> year
male_in=`hive -S -e "USE dshs; SELECT COUNT(*) FROM inpatients WHERE year='$1' AND sex_code='M';"`
male_out=`hive -S -e "USE dshs; SELECT COUNT(*) FROM outpatients WHERE year='$1' AND sex_code='M';"`
female_in=`hive -S -e "USE dshs; SELECT COUNT(*) FROM inpatients WHERE year='$1' AND sex_code='F';"`
female_out=`hive -S -e "USE dshs; SELECT COUNT(*) FROM outpatients WHERE year='$1' AND sex_code='F';"`
male=$(echo "${male_in} + ${male_out}" | bc -l)
female=$(echo "${female_in} + ${female_out}" | bc -l)
total=$(echo "${male} + ${female}" | bc -l)
male_per=$(echo "(${male} / ${total}) * 100" | bc -l)
female_per=$(echo "(${female} / ${total}) * 100" | bc -l)
echo "Male proportion: " $male_per
echo "Female proportion: " $female_per
